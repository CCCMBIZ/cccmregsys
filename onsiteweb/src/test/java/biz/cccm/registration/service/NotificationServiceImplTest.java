/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.service;

import biz.cccm.registration.dao.GenericJPADao;
import biz.cccm.registration.dao.PersonDao;
import biz.cccm.registration.model.Family;
import biz.cccm.registration.model.Payment;
import biz.cccm.registration.model.Person;
import biz.cccm.registration.model.Profile;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Ephesus
 */
public class NotificationServiceImplTest {

    private static final Logger logger = Logger.getLogger(NotificationServiceImplTest.class);
    ApplicationContext applicationContext = null;
    private final String testId = "808155218";

    public NotificationServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String[] xmlFiles = {"src/main/webapp/WEB-INF/spring/appservlet/config/web-application-config.xml"
        };

        try {
            applicationContext = new FileSystemXmlApplicationContext(xmlFiles);

//            Registration obj = new Registration();
//            RegistrationDao dao = (RegistrationDao) applicationContext.getBean("registrationDao");
//
//            obj.setRegistrationID(testId);
//            obj.setBreakfast1(1);
//            obj.setBreakfast2(1);
//            obj.setBreakfast3(1);
//            obj.setBreakfast4(1);
//            obj.setBreakfast5(1);
//
//            obj.setLunch1(2);
//            obj.setLunch2(2);
//            obj.setLunch3(2);
//            obj.setLunch4(2);
//            obj.setLunch5(2);
//
//            obj.setDinner1(5);
//            obj.setDinner2(5);
//            obj.setDinner3(5);
//            obj.setDinner4(5);
//            obj.setDinner5(5);
//
//            dao.save(obj);
//
//            testId = obj.getRegistrationID();
        } catch (org.springframework.beans.factory.BeanCreationException e) {
            logger.error(e.getMessage());
        } catch (BeansException ex) {
            java.util.logging.Logger.getLogger(NotificationServiceImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sendConfirmationEmail method, of class NotificationServiceImpl.
     */
    @Test
    public void testSendConfirmationEmail() {

        GenericJPADao<Profile> profileDao = (GenericJPADao<Profile>) applicationContext.getBean("profileDao");
        GenericJPADao<Family> familyDao = (GenericJPADao<Family>) applicationContext.getBean("familyDao");
        GenericJPADao<Person> personDao = (GenericJPADao<Person>) applicationContext.getBean("personDao");
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("registrationID", testId);

        List<Profile> list = profileDao.findByNamedQuery("Profile.findByRegistrationID", map);

        logger.debug("List:" + list.size());

        if (list.size() > 0) {
            Profile profile = list.get(0);
            Family family = familyDao.find(profile.getFamilyID());

            logger.debug("Email:" + family.getMisc1());
        }

        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("registrationID", testId);
        List<Profile> pflist = profileDao.findByNamedQuery("Profile.findByRegistrationID", map1);
        logger.debug("Found registration:" + pflist.size());
        String rtnStr = "";
        for (Profile profile : pflist) {
            logger.debug("Person ID:" + profile.getPersonID());
            Person person = personDao.find(profile.getPersonID());
            rtnStr += person.getChineseName();
            rtnStr += " ";
            logger.debug("Person ID:" + profile.getPersonID() + " " + rtnStr);
        }

//        System.out.println("sendConfirmationEmail");
//        String familyId = "";
//        String templateName = "";
//        HashMap<String, String> params = null;
//        NotificationServiceImpl instance = new NotificationServiceImpl();
//        boolean expResult = false;
//        boolean result = instance.sendConfirmationEmail(familyId, templateName, params);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
