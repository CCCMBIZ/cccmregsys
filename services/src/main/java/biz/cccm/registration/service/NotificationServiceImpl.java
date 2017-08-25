/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.service;

import biz.cccm.registration.dao.GenericJPADao;
import biz.cccm.registration.model.Family;
import biz.cccm.registration.model.Person;
import biz.cccm.registration.model.Profile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.mail.MessagingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CH1CHOO1
 */
@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {

    private static final Logger logger = Logger.getLogger(NotificationServiceImpl.class);
    @Autowired
    private GenericJPADao<Family> familyDao;
    @Autowired
    private GenericJPADao<Profile> profileDao;
    @Autowired
    private GenericJPADao<Person> personDao;
    @Autowired
    private MailEngine mailEngine;

    @Override
    public boolean sendConfirmationEmail(String familyId, String templateName, HashMap<String, String> params) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("registrationID", familyId);

        List<Profile> list = profileDao.findByNamedQuery("Profile.findByRegistrationID", map);

        Family family = null;
        if (list != null && !list.isEmpty()) {
            Profile savedReg = list.get(0);
            family = familyDao.find(savedReg.getFamilyID());
        }
        if (mailEngine != null && family != null) {
            try {
                logger.debug("Mail Engine:" + mailEngine.toString());

                String recipients[] = new String[1];
                recipients[0] = family.getMisc1();
                String subject = "Chicago Chinese Christian Conference And Grace conference 2016";
//
//                Map<String, Object> m = new HashMap<String, Object>();
//                m.put("registrationID", savedReg.getFamilyID());
//                for (Map.Entry pair : params.entrySet()) {
//                    m.put((String) pair.getKey(), pair.getValue());
//                }

                mailEngine.sendMessage(recipients, "cccc.register.1@gmail.com", subject, templateName, params);
                logger.debug("Message Sent :" + Arrays.toString(recipients));
            } catch (MessagingException ex) {
//                java.util.logging.Logger.getLogger(NotificationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                logger.error("Message Error " + ex);
                return false;
            }
        }

        logger.info("exit sendConfirmationEmail...");

        return true;
    }
//    @Override
//    public boolean sendPaymentConfirmationWithEmail(Object payment, String template) {
//
//        logger.info("enter sendConfirmationEmail...");
//
//        if (!(payment instanceof Payment)) {
//            return false;
//        }
//
//        Payment pay = (Payment) payment;
//
//        String familyId = pay.getRegistrationID().toString();
//
//        Fee fee = registrationService.calculateFee(familyId);
//
//        Registration savedReg = null;
//
//        List<Registration> list = registrationService.findRegistrationes(familyId);
//
//        if (list != null && !list.isEmpty()) {
//            savedReg = list.get(0);
//        }
//
//        if (mailEngine != null && savedReg != null) {
//
//            try {
//                logger.debug("Mail Engine:" + mailEngine.toString());
//                SimpleMailMessage mailMessage = null;
//
//                mailMessage = new SimpleMailMessage();
//
//                mailMessage.setFrom("registration@cccm.ws");
//                mailMessage.setBcc("cheh.cccm@gmail.com");
//                mailMessage.setTo(savedReg.getEmail());
//
//                String recipients[] = new String[1];
//                recipients[0] = savedReg.getEmail();
//
//                String subject = "CCCC/GRACE 2014 Registration Confirmation";
//                mailMessage.setSubject(subject);
//
//                Map<String, Object> m = new HashMap<String, Object>();
//                m.put("registrationId", savedReg.getFormID().intValue());
////            m.put("rname", savedReg.getFirstName() + " " + savedReg.getLastName());
////                m.put("rnames", rnames);
//                Double mealTotal = fee.getTotalBreakfastFee() + fee.getTotalLunchFee() + fee.getTotalDinnerFee();
//                Double registrationTotal = fee.getTotalAdultRegistrationFee() + fee.getTotalNonAdultRegistrationFee();
//                Double grandTotal = mealTotal + registrationTotal;
//
//                Double unitAdultRegistrationFee = fee.getUnitAdultRegistrationFee();
//                Double unitNonAdultRegistrationFee = fee.getUnitNonAdultRegistrationFee();
//
//                m.put("gandTotalFee", grandTotal.intValue());
//                m.put("totalMealFee", mealTotal.intValue());
//                m.put("totalRegFee", registrationTotal.intValue());
//                m.put("brFee", (int) fee.getTotalBreakfastFee());
//                m.put("luFee", (int) fee.getTotalLunchFee());
//                m.put("diFee", (int) fee.getTotalDinnerFee());
//                m.put("amountPaid", pay.getAmount().intValue());
//                m.put("fsupport", 0);
//                m.put("btotal", fee.getBreakfastCount());
//                m.put("ltotal", fee.getLunchCount());
//                m.put("dtotal", fee.getDinnerCount());
//                m.put("atotal", fee.getAdultHeadcount());
//                m.put("ntotal", fee.getNonAdultHeadcount());
//                m.put("nxtotal", fee.getNonAdultXHeadcount());
//
//                m.put("unitAdultRegFee", unitAdultRegistrationFee.intValue());
//                m.put("unitNonAdultRegFee", unitNonAdultRegistrationFee.intValue());
//
//                String template1 = "confirmationLetterPayByCC.htm";
//
//                if (savedReg.getEventID().compareTo(201403) == 0) {
//                    template1 = "confirmationLetterEng.htm";
//                }
//
//                mailEngine.sendMessage(recipients, "registration@cccm.ws", subject, template1, m);
//                logger.debug("Message Sent :" + savedReg.getEmail());
//            } catch (MessagingException ex) {
//                java.util.logging.Logger.getLogger(NotificationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        logger.info("exit sendConfirmationEmail...");
//
//        return true;
//    }

}
