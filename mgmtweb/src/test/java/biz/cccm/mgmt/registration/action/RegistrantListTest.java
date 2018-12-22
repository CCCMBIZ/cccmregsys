/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.action;

import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.service.RegistrantManager;
import biz.cccm.webapp.action.BasePageTestCase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.logging.Level;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import ws.cccm.receipt.service.ReceiptServiceImpl;
import ws.cccm.reg.service.NameTag;
import ws.cccm.reg.service.NameTagService;
import ws.cccm.reg.service.NameTagServiceImpl;

/**
 *
 * @author chehh
 */
public class RegistrantListTest extends BasePageTestCase {

    private static final Logger logger = Logger.getLogger(RegistrantListTest.class);
    private RegistrantList bean;
    @Autowired
    private RegistrantManager registrantManager;

    public RegistrantListTest() {
    }

    @Override
    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new RegistrantList();
        bean.setRegistrantManager(registrantManager);
        assertNotNull(bean);
    }

    @Override
    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    /**
     * Test of setQuery method, of class RegistrantList.
     */
//    @Test
//    public void testSetQuery() {
//        System.out.println("setQuery");
//        String query = "";
//        RegistrantList instance = new RegistrantList();
//        instance.setQuery(query);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getQuery method, of class RegistrantList.
//     */
//    @Test
//    public void testGetQuery() {
//        System.out.println("getQuery");
//        RegistrantList instance = new RegistrantList();
//        String expResult = "";
//        String result = instance.getQuery();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setRegistrantManager method, of class RegistrantList.
//     */
//    @Test
//    public void testSetRegistrantManager() {
//        System.out.println("setRegistrantManager");
//        RegistrantManager registrantManager = null;
//        RegistrantList instance = new RegistrantList();
//        instance.setRegistrantManager(registrantManager);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getRegistrants method, of class RegistrantList.
     */
    @Test
    public void testPrintSomeNametag() {
        System.out.println("testPrintSomeNametag");

        try {
            List<Registrant> registrants = new ArrayList<Registrant>();
            registrants.addAll(registrantManager.getRegistrant());

            Collections.sort(registrants, new RegistrantComparator());

            Set<NameTag> printRequest = new LinkedHashSet<>();
            for (Registrant reg : registrants) {

                NameTag nameTag = new NameTag();
                nameTag.setConferenceName("二零一八基督徒大會");
                if (reg.getChineseName() != null && !reg.getChineseName().isEmpty()) {
                    nameTag.setChineseFullName(reg.getChineseName());
                } else {
                    nameTag.setChineseFullName(reg.getFirstName()) ;
                }
                log.info("Name:" + nameTag.getChineseFullName());
                nameTag.setEnglishFullName(reg.getFirstName() + " " + reg.getLastName());
                nameTag.setChruchName(reg.getChurchName());
                nameTag.setCenterId(reg.getRegistrationID());

                String groupID = (reg.getHealthCardNo() == null ? "" : reg.getHealthCardNo());
                nameTag.setGroupId(groupID);
                nameTag.setBarcodeId(String.valueOf(reg.getPersonID()));

                String topic = "" ;
                if (reg.getWorkshop1() != null && !reg.getWorkshop1().isEmpty()) {
                    String[] list = reg.getWorkshop1().split("\\|");
                    for (String w : list) {
                        if (w != null && !w.isEmpty()) {
                            if (!topic.isEmpty()) {
                                topic += "," ;
                            }
                            topic += w ;
                        }
                    }
                }
                if (reg.getWorkshop2() != null && !reg.getWorkshop2().isEmpty()) {
                    String[] list = reg.getWorkshop2().split("\\|");
                    for (String s : list) {
                        if (s!= null && !s.isEmpty()) {
                            if (!topic.isEmpty()) {
                                topic += ",";
                            }
                            topic += s ;
                        }
                    }
                }
                nameTag.setTopic(topic);

                if (reg.getPreferredLanguage() != null && reg.getPreferredLanguage().equalsIgnoreCase("E")) {
                    nameTag.setGrace(true);
                }
                printRequest.add(nameTag);
            }
            NameTagService nameTagService = new NameTagServiceImpl();
            byte[] pdf = nameTagService.generateNameTagPrints(printRequest, 1);

            FileOutputStream fileOuputStream
                    = new FileOutputStream("target/registrationNametag.pdf");
            fileOuputStream.write(pdf);
            fileOuputStream.close();

            System.out.println("Done");

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(PersonForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public class RegistrantComparator implements Comparator<Registrant> {

        @Override
        public int compare(Registrant o1, Registrant o2) {
            return new CompareToBuilder()
                    .append(o1.getLastName(), o2.getLastName())
                    .append(o1.getFirstName(), o2.getFirstName()).toComparison();
        }
    }
    /**
     * Test of search method, of class RegistrantList.
     */
//    @Test
//    public void testPrintNameTag() {
//        System.out.println("testPrintNameTag");
//        try {
//            List<Registrant> registrants = registrantManager.getRegistrant();
//
//            Set<NameTag> printRequest = new LinkedHashSet<>();
//            for (Registrant reg : registrants) {
//                if (reg.getAmount() != 0) {
//                    NameTag nameTag = new NameTag();
//                    if (reg.getChineseName() != null && !reg.getChineseName().isEmpty()) {
//                        nameTag.setChineseFullName(reg.getChineseName());
//                    } else {
//                        nameTag.setChineseFullName(reg.getFirstName());
//                    }
//                    log.info("Name:" + nameTag.getChineseFullName());
//                    nameTag.setEnglishFullName(reg.getFirstName() + " " + reg.getLastName());
//                    nameTag.setChruchName(reg.getChurchName());
//                    nameTag.setCenterId(reg.getRegistrationID());
//                    nameTag.setAddress(reg.getHomeCity() + "," + reg.getHomeState());
//                    nameTag.setBarcodeId(String.valueOf(reg.getPersonID()));
//
//                    if (reg.getPreferredLanguage().equalsIgnoreCase("E")) {
//                        nameTag.setGrace(true);
//                    }
//                    printRequest.add(nameTag);
//                }
//            }
//            NameTagService nameTagService = new NameTagServiceImpl();
//            byte[] pdf = nameTagService.generateNameTagPrints(printRequest, 8);
//            FileOutputStream fileOuputStream
//                    = new FileOutputStream("target/registrationNametag.pdf");
//            fileOuputStream.write(pdf);
//            fileOuputStream.close();
//
//            System.out.println("Done");
//
//        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(PersonForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    /**
     * Test of print method, of class RegistrantList.
     */
//    @Test
//    public void testPrintReceipts() {
//        System.out.println("testPrintReceipts");
//        List<Registrant> registrants = registrantManager.getRegistrant();
//
//        logger.debug("Registrants# -> " + registrants.size());
//        System.out.println("Registrants# -> " + registrants.size());
//        assertNotNull(registrants);
//
//        Set<String> regIdSet = new HashSet<String>();
//
//        for (Registrant reg : registrants) {
//
//            if (reg.getAmount() != 0 && !regIdSet.contains(reg.getRegistrationID())) {
//                regIdSet.add(reg.getRegistrationID());
//            }
//        }
//
//        ReceiptServiceImpl service = new ReceiptServiceImpl();
//
//        System.out.println("RegistrationID# -> " + regIdSet.size());
//        try {
//
//            byte[] pdf = service.generatePDFReceipt(regIdSet);
//
//            //convert array of bytes into file
//            FileOutputStream fileOuputStream
//                    = new FileOutputStream("target/registrationReceipt.pdf");
//            fileOuputStream.write(pdf);
//            fileOuputStream.close();
//
//            System.out.println("Done");
//
//            // TODO review the generated test code and remove the default call to fail.
//            assertNotNull(pdf);
//        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(RegistrantListTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
