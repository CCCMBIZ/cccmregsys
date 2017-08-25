/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.controller;

import biz.cccm.registration.dao.GenericJPADao;
import biz.cccm.registration.dao.PaymentDao;
import biz.cccm.registration.model.Payment;
import biz.cccm.registration.model.Person;
import biz.cccm.registration.service.NotificationServiceImplTest;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
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
public class ConfirmationControllerTest {
    
    private static final Logger logger = Logger.getLogger(ConfirmationControllerTest.class);
    ApplicationContext applicationContext = null;
    private final String testId = "808155218";
    
    public ConfirmationControllerTest() {
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
     * Test of handleRequest method, of class ConfirmationController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testHandleRequest() throws Exception {
        PaymentDao paymentDao = (PaymentDao) applicationContext.getBean("paymentDao");
        Payment payment = new Payment();
        payment.setAmount(19.99);
        payment.setPaymentDate(new Date());
        payment.setCreditCard(true);
        payment.setReferenceNumber("AHSGDJKKKKKKWWW");
        payment.setRegistrationID(123456789L);
        payment.setCurrency("USD");
        paymentDao.save(payment);
        Long payId = payment.getId();
        logger.debug("Test Payment ID:" + payId);
        Payment p1 = paymentDao.findById(payId);
        p1.setRegistrationID(99999999L);
        paymentDao.save(p1);
        paymentDao.delete(payId);
    }
    
}
