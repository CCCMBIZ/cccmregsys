/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.service;

import biz.cccm.registration.dao.ChurchDao;
import biz.cccm.registration.dao.GenericJPADao;
import biz.cccm.registration.dao.PaymentDao;
import biz.cccm.registration.dao.exceptions.RollbackFailureException;
import biz.cccm.registration.domain.PaymentMethod;
import biz.cccm.registration.domain.Registrant;
import biz.cccm.registration.domain.RegistrationForm;
import biz.cccm.registration.domain.Server;
import biz.cccm.registration.model.Church;
import biz.cccm.registration.model.Family;
import biz.cccm.registration.model.Person;
import biz.cccm.registration.model.Profile;
import biz.cccm.registration.model.Mealplan;
import biz.cccm.registration.model.Payment;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.mail.MessagingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ch1choo1
 */
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private GenericJPADao<Family> familyDao;
    @Autowired
    private GenericJPADao<Person> personDao;
    @Autowired
    GenericJPADao<Profile> profileDao;
    @Autowired
    GenericJPADao<Mealplan> mealplanDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private ChurchDao churchDao;
    @Autowired
    private MailEngine mailEngine;

    /**
     *
     * @param form
     * @return
     * @throws Exception
     */
    @Override
    public boolean submit(RegistrationForm form) throws Exception {

        // Check if same registration number already exist, cancel and resubmit
        // to avoid duolication
        cancel(form.getFormID().toString());

        Mealplan mealPlan = new Mealplan();
        mealPlan.setRegistrationID(form.getFormID().toString());
        mealPlan.setBreakfast1(0);
        mealPlan.setBreakfast2(0);
        mealPlan.setBreakfast3(0);
        mealPlan.setBreakfast4(0);
        mealPlan.setLunch1(0);
        mealPlan.setLunch2(0);
        mealPlan.setLunch3(0);
        mealPlan.setLunch4(0);
        mealPlan.setDinner1(0);
        mealPlan.setDinner2(0);
        mealPlan.setDinner3(0);
        mealPlan.setDinner4(0);

        // Family
        Family family = form.getAddress();
        logger.debug(family.getHomeAddress());
        if (form.getRegistrants().get(0) != null) {
            family.setFamilyName(form.getRegistrants().get(0).getPerson().getLastName());
        }
        familyDao.create(family);

        // Person / profile
        Iterator<Registrant> it = form.getRegistrants().iterator();
        while (it.hasNext()) {

            Registrant registrant = it.next();
            Person person = registrant.getPerson();

            logger.debug("PersonID:" + person.getPersonID());
            logger.debug("AcceptedChrist:" + person.getAcceptedChrist());
            logger.debug("AcceptedChristDate:" + person.getAcceptedChristDate());
            logger.debug("AcceptedChristLocation:" + person.getAcceptedChristLocation());
            logger.debug("Age[5]:" + person.getAge());
            logger.debug("Baptized:" + person.getBaptized());
            logger.debug("BaptizedDate:" + person.getBaptizedDate());
            logger.debug("CellPhone:" + person.getCellPhone());
            logger.debug("ChineseName[50]:" + person.getChineseName());
            logger.debug("ChurchAdmin:" + person.getChurchAdmin());
            logger.debug("ChurchID:" + person.getChurchID());
            logger.debug("CommitServe[50]:" + person.getCommitServe());
            logger.debug("Email[50]:" + person.getEmail());
            logger.debug("FamilyAdmin:" + person.getFamilyAdmin());
            logger.debug("FamilyID:" + person.getFamilyID());
            logger.debug("FirstName[20]:" + person.getFirstName());
            logger.debug("Gender[2]:" + person.getGender());
            logger.debug("LastModified:" + person.getLastModified());
            logger.debug("LastName[20]:" + person.getLastName());
            logger.debug("LoginID[50]:" + person.getLoginID());
            logger.debug("Misc1[50]:" + person.getMisc1());
            logger.debug("Misc2[50]:" + person.getMisc2());
            logger.debug("Misc3[50]:" + person.getMisc3());
            logger.debug("Password[50]:" + person.getPassword());
            logger.debug("Phone[15]:" + person.getPhone());
            logger.debug("PRC[50]:" + person.getPrc());
            logger.debug("PreferredLanguage[50]:" + person.getPreferredLanguage());
            logger.debug("Relationship[2]:" + person.getRelationship());
            logger.debug("Remarks[255]:" + person.getRemarks());
            logger.debug("Searchable:" + person.getSearchable());
            logger.debug("Seeker:" + person.getSeeker());
            logger.debug("ServingRole[50]:" + person.getServingRole());
            logger.debug("Status[5]:" + person.getStatus());
            logger.debug("Title[50]:" + person.getTitle());
            logger.debug("VolunteerCode:" + person.getVolunteerCode());
            logger.debug("WillingToAttendCCCMTraining:" + person.getWillingToAttendCCCMTraining());
            logger.debug("WillingToBeVolunteer:" + person.getWillingToBeVolunteer());
            logger.debug("WorkPhone:" + person.getWorkPhone());

            person.setChurchID(form.getChurchID().intValue());
            person.setFamilyID(form.getAddress().getFamilyID());
            person.setLastModified(new Date());

            personDao.create(person);

            logger.debug("Person ID:" + person.getPersonID());
            logger.debug("Family ID:" + person.getFamilyID());

            // Profile
            Profile profile = new Profile();

            if (form.getChurchName() != null) {
                profile.setChucrhName(form.getChurchName());
            }
            profile.setChurchID(form.getChurchID().intValue());
            profile.setPersonID(person.getPersonID());
            profile.setFamilyID(person.getFamilyID());
            profile.setRegistrationID(form.getFormID().toString());
            if (form.getAddress().getHotel() != null) {
                profile.setNeedHotel(form.getAddress().getHotel());
            }
            profile.setPreferredLanguage(person.getPreferredLanguage());

            if (!person.getAcceptedChrist()) {
                profile.setSeeker(true);
            }

            if (registrant.getSeminar() != null) {
                String seminar = "";
                if (registrant.getSeminar().getSession1() != null && !registrant.getSeminar().getSession1().isEmpty()) {
                    seminar += registrant.getSeminar().getSession1();
                }
                if (registrant.getSeminar().getSession2() != null && !registrant.getSeminar().getSession2().isEmpty()) {
                    if (!seminar.isEmpty()) {
                        seminar += "|";
                    }
                    seminar += registrant.getSeminar().getSession2();
                }
                profile.setWorkshop1(seminar);

                seminar = "";
                if (registrant.getSeminar().getSession3() != null && !registrant.getSeminar().getSession3().isEmpty()) {
                    seminar += registrant.getSeminar().getSession3();
                }
                if (registrant.getSeminar().getSession4() != null && !registrant.getSeminar().getSession4().isEmpty()) {
                    if (!seminar.isEmpty()) {
                        seminar += "|";
                    }
                    seminar += registrant.getSeminar().getSession4();
                }
                profile.setWorkshop2(seminar);
            }
            if (registrant.getVolunteerJobs() != null) {
                for (Server serve : registrant.getVolunteerJobs()) {
                    if (profile.getVolunteerJobs() == null || profile.getVolunteerJobs().isEmpty()) {
                        profile.setVolunteerJobs(serve.name());
                    } else {
                        String volunteerJobs = profile.getVolunteerJobs();
                        volunteerJobs += "|";
                        volunteerJobs += serve.name();
                        profile.setVolunteerJobs(volunteerJobs);
                    }
                }
            }

            if (person.getMisc1() != null) {
                int yr = 0;
                try {
                    yr = Integer.parseInt(person.getMisc1());
                } catch (NumberFormatException e) {
                    yr = 0;
                }
                profile.setFaithYear(yr);
            }

            profile.setRegisteredDate(form.getRegistrationDate());
            profile.setLastModified(new Date());

            if (profile.getChucrhName().length() > 50) {
                String temp = truncateToFitUtf8ByteLength(profile.getChucrhName(), 50);
                profile.setChucrhName(temp);
            }
            logger.debug("Profile chuch name:" + profile.getChucrhName());
            logger.debug("Profile family ID:" + profile.getFamilyID());
            logger.debug("Profile person ID:" + profile.getPersonID());
            logger.debug("Profile family ID:" + profile.getFamilyID());
            logger.debug("Profile hotel reservation:" + profile.getNeedHotel());
            logger.debug("Profile seminar 1:" + profile.getWorkshop1());
            logger.debug("Profile seminar 2:" + profile.getWorkshop2());
            logger.debug("Profile volunteers:" + profile.getVolunteerJobs());
            logger.debug("Profile registration date:" + profile.getRegisteredDate());

            profileDao.create(profile);

            mealPlan.setBreakfast1(mealPlan.getBreakfast1() + (registrant.getMealplan().getBreakfast1() == null ? 0 : registrant.getMealplan().getBreakfast1()));
            mealPlan.setBreakfast2(mealPlan.getBreakfast2() + (registrant.getMealplan().getBreakfast2() == null ? 0 : registrant.getMealplan().getBreakfast2()));
            mealPlan.setBreakfast3(mealPlan.getBreakfast3() + (registrant.getMealplan().getBreakfast3() == null ? 0 : registrant.getMealplan().getBreakfast3()));
            mealPlan.setBreakfast4(mealPlan.getBreakfast4() + (registrant.getMealplan().getBreakfast4() == null ? 0 : registrant.getMealplan().getBreakfast4()));

            mealPlan.setLunch1(mealPlan.getLunch1() + (registrant.getMealplan().getLunch1() == null ? 0 : registrant.getMealplan().getLunch1()));
            mealPlan.setLunch2(mealPlan.getLunch2() + (registrant.getMealplan().getLunch2() == null ? 0 : registrant.getMealplan().getLunch2()));
            mealPlan.setLunch3(mealPlan.getLunch3() + (registrant.getMealplan().getLunch3() == null ? 0 : registrant.getMealplan().getLunch3()));
            mealPlan.setLunch4(mealPlan.getLunch4() + (registrant.getMealplan().getLunch4() == null ? 0 : registrant.getMealplan().getLunch4()));

            mealPlan.setDinner1(mealPlan.getDinner1() + (registrant.getMealplan().getDinner1() == null ? 0 : registrant.getMealplan().getDinner1()));
            mealPlan.setDinner2(mealPlan.getDinner2() + (registrant.getMealplan().getDinner2() == null ? 0 : registrant.getMealplan().getDinner2()));
            mealPlan.setDinner3(mealPlan.getDinner3() + (registrant.getMealplan().getDinner3() == null ? 0 : registrant.getMealplan().getDinner3()));
            mealPlan.setDinner4(mealPlan.getDinner4() + (registrant.getMealplan().getDinner4() == null ? 0 : registrant.getMealplan().getDinner4()));
        }

        // Mealplan
        mealplanDao.create(mealPlan);

        // Payment
        Payment payment = new Payment();

        payment.setCash(Boolean.FALSE);
        payment.setCreditCard(Boolean.FALSE);
        payment.setPersonalCheck(Boolean.FALSE);
        payment.setPaidByConference(Boolean.FALSE);
        payment.setRefund(Boolean.FALSE);
        payment.setAmount(0.0);

        if (form.getPaymentMethod() == PaymentMethod.CREDIT_CARD) {
            payment.setCreditCard(Boolean.TRUE);
        } else if (form.getPaymentMethod() == PaymentMethod.PERSONAL_CHECK) {
            payment.setPersonalCheck(Boolean.TRUE);
        }

        payment.setRegistrationFee(form.getExpense().getTotalRegistrationFee());
        payment.setMealFee(form.getExpense().getTotalMealsFee());
        payment.setRegistrationID(form.getFormID());

        paymentDao.save(payment);

        return true;
    }

    /**
     *
     * @param form
     * @param params
     * @param template
     */
    @Override
    public void sendEmail(RegistrationForm form, Map<String, Object> params, String template) {
        try {
            logger.debug("Mail Engine:" + mailEngine.toString());

            String recipients[] = new String[1];
            recipients[0] = form.getAddress().getMisc1();
            String subject = form.getEvent().getName();
//            mailMessage.setSubject(subject);
            logger.debug("Message Sender :" + form.getEvent().getContactEmail());
            mailEngine.sendMessage(recipients, form.getEvent().getContactEmail(), subject, template, params);

            logger.debug("Message Recipient :" + recipients[0]);
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Church getChurchByID(Integer churchID) {
        return churchDao.get(churchID);
    }

    @Override
    public void cancel(String registrationID) {
        try {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("registrationID", registrationID);

            List<Profile> list = profileDao.findByNamedQuery("Profile.findByRegistrationID", map);
            if (list.isEmpty()) {
                return;
            }
            Integer fid = 0;
            Integer pid = 0;
            for (Profile p : list) {
                fid = p.getFamilyID();
                pid = p.getPersonID();
            }
            List<Payment> plist = paymentDao.findPaymentByQuery("SELECT p FROM Payment p WHERE p.registrationID = '" + registrationID + "'");
            for (Payment p : plist) {
                logger.debug("Payment ID:" + p.getId());
                paymentDao.delete(p.getId());
            }

            mealplanDao.destroy(registrationID);
            profileDao.destroy(pid);
            personDao.destroy(pid);
            familyDao.destroy(fid);
        } catch (RollbackFailureException ex) {
            java.util.logging.Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String trim(String s, int byteLimit) {
        if (s.getBytes().length <= byteLimit) {
            return s;
        }

        int n = Math.min(byteLimit - 1, s.length() - 1);
        do {
            s = s.substring(0, n--);
        } while (s.getBytes().length > byteLimit);

        return s;
    }

    /**
     * Truncates a string to the number of characters that fit in X bytes
     * avoiding multi byte characters being cut in half at the cut off point.
     * Also handles surrogate pairs where 2 characters in the string is actually
     * one literal character.
     *
     * Based on: http://www.jroller.com/holy/entry/truncating_utf_string_to_the
     * @param s
     * @param maxBytes
     * @return 
     */
    public static String truncateToFitUtf8ByteLength(String s, int maxBytes) {
        if (s == null) {
            return null;
        }
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        byte[] sba = s.getBytes(charset);
        if (sba.length <= maxBytes) {
            return s;
        }
        // Ensure truncation by having byte buffer = maxBytes
        ByteBuffer bb = ByteBuffer.wrap(sba, 0, maxBytes);
        CharBuffer cb = CharBuffer.allocate(maxBytes);
        // Ignore an incomplete character
        decoder.onMalformedInput(CodingErrorAction.IGNORE);
        decoder.decode(bb, cb, true);
        decoder.flush(cb);
        return new String(cb.array(), 0, cb.position());
    }

    @Override
    public List<Church> getChurchByState(String state) {   
        return churchDao.findChurchesByQuery("SELECT c FROM Church c WHERE c.state = '" + state + "'");
    }
}
