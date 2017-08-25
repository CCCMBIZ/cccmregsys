package biz.cccm.registration.controller;

import biz.cccm.registration.dao.GenericJPADao;
import biz.cccm.registration.dao.PaymentDao;
import biz.cccm.registration.model.Mealplan;
import biz.cccm.registration.model.Payment;
import biz.cccm.registration.model.Person;
import biz.cccm.registration.model.Profile;
import biz.cccm.registration.service.NotificationService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfirmationController {

    private static final Logger logger = Logger.getLogger(ConfirmationController.class);

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private GenericJPADao<Person> personDao;
    @Autowired
    private GenericJPADao<Profile> profileDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    GenericJPADao<Mealplan> mealplanDao;
    @Autowired
    private String paypalUrl;
    @Autowired
    private String eventMailSubject;
    @Autowired
    private String eventMailSender;
    @Autowired
    private String eventMailTemplate;
//    @RequestMapping("/confirm.htm")
//    public ModelAndView handleRequest(HttpServletRequest request,
//            HttpServletResponse response)
//            throws Exception {
//
//        String itemId = request.getParameter("item_number");
//        logger.info("item_number:" + itemId);
//        String custom = request.getParameter("custom");
//        logger.info("custom:" + custom);
//        logger.debug(request.getParameterNames());
//        logger.debug(request.getAttributeNames());
//
//        ModelAndView model = new ModelAndView("confirm_gfcc2015");
//
//        model.addObject("registrationId", itemId);
//        model.addObject("amountPaid", custom);
//
//        return model;
//
//    }

    @RequestMapping("/instantPaymentNotification.htm")
    public void handleRequest(HttpServletRequest request) {

        try {
            //1. Read all posted request parameters
            String requestParams = this.getAllRequestParams(request);
            logger.info(requestParams);

            //2. Prepare 'notify-validate' command with exactly the same parameters
            Enumeration en = request.getParameterNames();
            StringBuilder cmd = new StringBuilder("cmd=_notify-validate");
            String paramName;
            String paramValue;
            while (en.hasMoreElements()) {
                paramName = (String) en.nextElement();
                paramValue = request.getParameter(paramName);
                cmd.append("&").append(paramName).append("=")
                        .append(URLEncoder.encode(paramValue, request.getParameter("charset")));
            }

            //3. Post above command to Paypal IPN URL {@link IpnConfig#ipnUrl}
            URL u = new URL(paypalUrl + "/cgi-bin/webscr");
            HttpsURLConnection uc = (HttpsURLConnection) u.openConnection();
            uc.setDoOutput(true);
            uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            uc.setRequestProperty("Host", "www.paypal.com");
            PrintWriter pw = new PrintWriter(uc.getOutputStream());
            pw.println(cmd.toString());
            pw.close();

            //4. Read response from Paypal
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String res = in.readLine();
            in.close();

            logger.debug("instantPaymentNotification.htm start..");
            String itemName = request.getParameter("item_name");
            String itemNumber = request.getParameter("item_number");
            String paymentStatus = request.getParameter("payment_status");
            String paymentAmount = request.getParameter("mc_gross");
            String paymentCurrency = request.getParameter("mc_currency");
            String txnId = request.getParameter("txn_id");
            String receiverEmail = request.getParameter("receiver_email");
            String payerEmail = request.getParameter("payer_email");

            logger.debug("Item Name:" + itemName);
            logger.debug("item Number:" + itemNumber);
            logger.debug("payment Status:" + paymentStatus);
            logger.debug("payment Amount:" + paymentAmount);
            logger.debug("payment Currency:" + paymentCurrency);
            logger.debug("receiver Email:" + receiverEmail);
            logger.debug("payer Email:" + payerEmail);
            logger.debug("Response:" + res);

            Double registrationFee = 0.0;
            Double mealsFee = 0.0;
            //6. Validate captured Paypal IPN Information
            if (res.equals("VERIFIED") && paymentStatus.equalsIgnoreCase("Completed")) {
                boolean dup = false;
                if (itemNumber != null && !itemNumber.isEmpty()) {

                    logger.debug("Item Number: " + itemName);
                    List<Payment> plist;
                    String searchString = "select p from Payment p where p.registrationID = " + itemNumber + "";
                    plist = paymentDao.findPaymentByQuery(searchString);

                    if (plist.isEmpty()) {
                        Payment payment = new Payment();
                        payment.setAmount(Double.parseDouble(paymentAmount));
                        payment.setPaymentDate(new Date());
                        payment.setCreditCard(true);
                        payment.setReferenceNumber(txnId);
                        payment.setRegistrationID(Long.parseLong(itemNumber));
                        payment.setCurrency(paymentCurrency);
                        paymentDao.save(payment);
                    } else {
                        Iterator<Payment> pit = plist.iterator();
                        while (pit.hasNext()) {
                            Payment p = pit.next();
                            if (p.getReferenceNumber() != null && p.getReferenceNumber().contains(txnId)) {
                                logger.debug("Same transaction " + txnId + "  already received");
                                dup = true;
                                break;
                            } else if (p.getRegistrationID().toString().contentEquals(itemNumber)) {

                                Payment p1 = paymentDao.findById(p.getId());
                                p1.setAmount(Double.parseDouble(paymentAmount));
                                p1.setPaymentDate(new Date());
                                p1.setCreditCard(true);
                                p1.setReferenceNumber(txnId);
                                p1.setRegistrationID(Long.parseLong(itemNumber));
                                p1.setCurrency(paymentCurrency);
                                paymentDao.update(p1);
                                registrationFee = p1.getRegistrationFee();
                                mealsFee = p1.getMealFee();
                            }

                        }
                    }
                }

                if (dup) {
                    logger.debug("VERIFIED duplicate " + itemNumber);
                    return;
                }

                Map<String, String> relationshipMap = new HashMap<String, String>();

                relationshipMap.put("H", "\u4e08\u592b");
                relationshipMap.put("W", "\u59bb\u5b50");
                relationshipMap.put("S", "\u5152\u5b50");
                relationshipMap.put("D", "\u5973\u5152");
                relationshipMap.put("F", "\u7236\u89aa");
                relationshipMap.put("M", "\u6bcd\u89aa");
                relationshipMap.put("B", "\u5144\u5F1F");
                relationshipMap.put("T", "\u59CA\u59B9");
                relationshipMap.put("C", "\u540C\u5B66");
                relationshipMap.put("O", "\u540C\u4E8B");
                relationshipMap.put("P", "\u4E3B\u62A5\u4EBA");

                List<Person> pslist = getPersonListByRegistraionID(itemNumber);
                String names = "";

                Integer adulttotal = 0;
                Integer nonadulttotal = 0;
                Integer nonxadulttotal = 0;

                for (Person person : pslist) {
                    if (!names.isEmpty()) {
                        names += "<br/>";
                    }
                    String rel = relationshipMap.get(person.getRelationship());
                    if (rel != null && !rel.isEmpty()) {
                        names += rel;
                        names += ":";
                    }
                    names += person.getChineseName();
                    names += " ";
                    names += person.getFirstName();
                    names += " ";
                    names += person.getLastName();

//                    if (person.getAge() != null && !person.getAge().isEmpty()) {
//                        if (person.getAge().startsWith("A")) {
//                            adulttotal++;
//                        } else if (Integer.parseInt(person.getAge()) >= 4) {
//                            nonadulttotal++;
//                        } else if (Integer.parseInt(person.getAge()) < 4) {
//                            nonxadulttotal++;
//                        }
//                    }
                    if (person.getPreferredLanguage().equalsIgnoreCase("M") || person.getPreferredLanguage().equalsIgnoreCase("E")) {
                        adulttotal++;
                    } else if (person.getPreferredLanguage().equalsIgnoreCase("C") || person.getPreferredLanguage().equalsIgnoreCase("K")) {
                        nonadulttotal++;
                    } else if (person.getPreferredLanguage().equalsIgnoreCase("T")) {
                        nonxadulttotal++;
                    }
                }

                Map<String, String> plan = getMealCount(itemNumber);
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("names", names);
                params.put("registrationId", itemNumber);
                params.put("amountPaid", paymentAmount);
                params.put("registrationFee", String.valueOf(registrationFee));
                params.put("mealFee", mealsFee.toString());
                params.put("currency", paymentCurrency);
                params.put("headCount", String.valueOf(pslist.size()));
                params.put("mealCount", plan.get("mealCount"));

                params.put("adulttotal", adulttotal.toString());
                params.put("nonadulttotal", nonadulttotal.toString());
                params.put("nonxadulttotal", nonxadulttotal.toString());

                params.put("breakfastTotal", plan.get("breakfastTotal"));
                params.put("breakfastFee", plan.get("breakfastFee"));
                params.put("lunchTotal", plan.get("lunchTotal"));
                params.put("lunchFee", plan.get("lunchFee"));
                params.put("dinnerTotal", plan.get("dinnerTotal"));
                params.put("dinnerFee", plan.get("dinnerFee"));
                params.put("grandTotalFee", String.valueOf(registrationFee + mealsFee));

                if (eventMailSubject != null) {
                    params.put("subject", eventMailSubject);
                }

                if (eventMailSender != null) {
                    params.put("sender", eventMailSender);
                }

                String template = "CCCC_2016_Registration_Confirmation.html";
                if (eventMailTemplate != null) {
                    template = eventMailTemplate;
                }

                notificationService.sendConfirmationEmail(itemNumber, template, params);

                logger.debug("VERIFIED");

            } else {
                logger.error("IPN Verification :" + res);
                logger.error("Payment Status :" + paymentStatus);
            }

        } catch (IOException | NumberFormatException ex) {
            logger.fatal("InstantPaymentNotification ERROR:" + ex.getMessage());
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            String stacktrace = sw.toString();
            logger.debug("InstantPaymentNotification STACK TRACE:" + stacktrace);

        } catch (Exception ex) {
            logger.fatal("InstantPaymentNotification ERROR:" + ex.getMessage());
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            String stacktrace = sw.toString();
            logger.debug("InstantPaymentNotification STACK TRACE:" + stacktrace);
        }
    }

    private String getAllRequestParams(HttpServletRequest request) {
        Map map = request.getParameterMap();
        StringBuilder sb = new StringBuilder("\nREQUEST PARAMETERS\n");
        for (Iterator it = map.keySet().iterator(); it.hasNext();) {
            String pn = (String) it.next();
            sb.append(pn).append("\n");
            String[] pvs = (String[]) map.get(pn);
            for (int i = 0; i < pvs.length; i++) {
                String pv = pvs[i];
                sb.append("\t").append(pv).append("\n");
            }
        }
        return sb.toString();
    }

    private List<Person> getPersonListByRegistraionID(String registrationId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("registrationID", registrationId);
        List<Profile> pflist = profileDao.findByNamedQuery("Profile.findByRegistrationID", map);
        logger.debug("Found registration:" + pflist.size());

        ArrayList<Person> pslist = new ArrayList<Person>();
        for (Profile profile : pflist) {
            logger.debug("Person ID:" + profile.getPersonID());
            Person person = personDao.find(profile.getPersonID());
            if (person != null) {
                pslist.add(person);
            }
//            if (profile.getChurchID().compareTo(9999)==0) {
//                eventMailTemplate = "GRACE_2015_Registration_Confirmation.html" ;
//            }
        }
        return pslist;
    }

    private Map<String, String> getMealCount(String registrationId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("registrationID", registrationId);
        List<Mealplan> meals = mealplanDao.findByNamedQuery("Mealplan.findByRegistrationID", map);

        Integer breakfastTotal = 0;
        Integer lunchTotal = 0;
        Integer dinnerTotal = 0;
        for (Mealplan mplan : meals) {

            breakfastTotal = (mplan.getBreakfast1() != null ? mplan.getBreakfast1() : 0)
                    + (mplan.getBreakfast2() != null ? mplan.getBreakfast2() : 0)
                    + (mplan.getBreakfast3() != null ? mplan.getBreakfast3() : 0)
                    + (mplan.getBreakfast4() != null ? mplan.getBreakfast4() : 0)
                    + (mplan.getBreakfast5() != null ? mplan.getBreakfast5() : 0);
            lunchTotal = (mplan.getLunch1() != null ? mplan.getLunch1() : 0)
                    + (mplan.getLunch2() != null ? mplan.getLunch2() : 0)
                    + (mplan.getLunch3() != null ? mplan.getLunch3() : 0)
                    + (mplan.getLunch4() != null ? mplan.getLunch4() : 0)
                    + (mplan.getLunch5() != null ? mplan.getLunch5() : 0);
            dinnerTotal = (mplan.getDinner1() != null ? mplan.getDinner1() : 0)
                    + (mplan.getDinner2() != null ? mplan.getDinner2() : 0)
                    + (mplan.getDinner3() != null ? mplan.getDinner3() : 0)
                    + (mplan.getDinner4() != null ? mplan.getDinner4() : 0)
                    + (mplan.getDinner5() != null ? mplan.getDinner5() : 0);
        }

        HashMap<String, String> plan = new HashMap<String, String>();

        plan.put("breakfastTotal", breakfastTotal.toString());
        plan.put("lunchTotal", lunchTotal.toString());
        plan.put("dinnerTotal", dinnerTotal.toString());

        plan.put("breakfastFee", String.valueOf(breakfastTotal * 5.0));
        plan.put("lunchFee", String.valueOf(lunchTotal * 6.0));
        plan.put("dinnerFee", String.valueOf(dinnerTotal * 9.0));

        plan.put("mealCount", String.valueOf(breakfastTotal + lunchTotal + dinnerTotal));

        return plan;
    }
}
