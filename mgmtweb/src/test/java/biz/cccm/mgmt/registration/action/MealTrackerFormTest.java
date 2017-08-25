/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Mealtracker;
import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.service.MealtrackerManager;
import biz.cccm.mgmt.registration.service.RegistrantManager;
import biz.cccm.webapp.action.BasePageTestCase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author CH1CHOO1
 */
public class MealTrackerFormTest extends BasePageTestCase {

    private static final Logger logger = Logger.getLogger(MealTrackerFormTest.class);
    private MealTrackerForm bean;
    @Autowired
    private MealtrackerManager mealTrackerManager;
    @Autowired
    private RegistrantManager registrantManager;

    @Override
    @Before
    public void onSetUp() {
        super.onSetUp();
        bean = new MealTrackerForm();
        bean.setMealtrackerManager(mealTrackerManager);
        bean.setRegistrantManager(registrantManager);
        assertNotNull(bean);
    }

    @Override
    @After
    public void onTearDown() {
        super.onTearDown();
        bean = null;
    }

    @Test
    public void testEnter() throws Exception {
        List<Registrant> registrants = registrantManager.getRegistrant();
        HashMap<String, Integer> workshopMap = new HashMap<>();
        List<String> container = new ArrayList<>();
        for (Registrant reg : registrants) {
            if (reg.getAmount() > 0) {
                if (reg.getWorkshop1() != null && !reg.getWorkshop1().isEmpty()) {
                    String[] list = reg.getWorkshop1().split("\\|");
                    for (String w : list) {
                        if (workshopMap.containsKey(w)) {
                            Integer count = workshopMap.get(w);
                            count++;
                            workshopMap.put(w, count);
                        } else {
                            workshopMap.put(w, 0);
                        }
                    }

                }
                if (reg.getWorkshop2() != null && !reg.getWorkshop2().isEmpty()) {
                    String[] list = reg.getWorkshop2().split("\\|");

                    for (String w : list) {
//                        logger.info("Split:" + w);
                        if (workshopMap.containsKey(w)) {
                            Integer count = workshopMap.get(w);
                            count++;
                            workshopMap.put(w, count);
                        } else {
                            workshopMap.put(w, 0);
                        }
                    }
                }

//                if (!container.contains(reg.getRegistrationID())) {
//                    generateTestData(reg.getDinner1(), "DINNER1", reg);
//                    generateTestData(reg.getBreakfast2(), "BREAKFAST2", reg);
//                    generateTestData(reg.getLunch2(), "LUNCH2", reg);
//                    generateTestData(reg.getDinner2(), "DINNER2", reg);
//                    generateTestData(reg.getBreakfast3(), "BREAKFAST3", reg);
//                    generateTestData(reg.getLunch3(), "LUNCH3", reg);
//                    generateTestData(reg.getDinner3(), "DINNER3", reg);
//                    generateTestData(reg.getBreakfast4(), "BREAKFAST4", reg);
//                    generateTestData(reg.getLunch4(), "LUNCH4", reg);
//                    container.add(reg.getRegistrationID());
//                }
            }
        }

        logger.info("workshopMap SIZE:" + workshopMap.size());
        for (Object key : workshopMap.keySet()) {
            System.out.println("Workshop : " + key.toString() + " headcount : " + workshopMap.get(key));
        }
//        bean.setQuery("145");
//        assertEquals("success", bean.enter());
//        assertNotNull(bean.getMealtrackers());
//        assertFalse(bean.hasErrors());
    }

    private void generateMealTracker() {
        List<Registrant> registrants = registrantManager.getRegistrant();
        List<String> container = new ArrayList<>();
        for (Registrant reg : registrants) {
            if (reg.getAmount() > 0) {
                if (!container.contains(reg.getRegistrationID())) {
                    generateTestData(reg.getDinner1(), "DINNER1", reg);
                    generateTestData(reg.getBreakfast2(), "BREAKFAST2", reg);
                    generateTestData(reg.getLunch2(), "LUNCH2", reg);
                    generateTestData(reg.getDinner2(), "DINNER2", reg);
                    generateTestData(reg.getBreakfast3(), "BREAKFAST3", reg);
                    generateTestData(reg.getLunch3(), "LUNCH3", reg);
                    generateTestData(reg.getDinner3(), "DINNER3", reg);
                    generateTestData(reg.getBreakfast4(), "BREAKFAST4", reg);
                    generateTestData(reg.getLunch4(), "LUNCH4", reg);
                    container.add(reg.getRegistrationID());
                }
            }
        }
    }

    private void generateTestData(int count, String mealType, Registrant reg) {

        for (int i = 0; i < count; i++) {
            Mealtracker tracker = new Mealtracker();
            tracker.setMealType(mealType);
            tracker.setPersonID(reg.getPersonID());
            tracker.setRegistrationID(reg.getRegistrationID());
            tracker.setRemark(reg.getFirstName() + " " + reg.getLastName());
            tracker.setLastModified(new Date());
            try {
                mealTrackerManager.saveMealtracker(tracker);
            } catch (NonexistentEntityException ex) {

            }
        }
    }
}
