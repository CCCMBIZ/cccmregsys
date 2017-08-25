package biz.cccm.mgmt.registration.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import biz.cccm.dao.SearchException;
import biz.cccm.mgmt.registration.model.Mealplan;
import biz.cccm.mgmt.registration.model.Mealtracker;
import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.service.MealplanManager;
import biz.cccm.mgmt.registration.service.MealtrackerManager;
import biz.cccm.mgmt.registration.service.RegistrantManager;
import biz.cccm.webapp.action.BasePage;

public class MealplanList extends BasePage implements Serializable {

    private static final long serialVersionUID = 972359310602744031L;
    protected MealplanManager mealplanManager;
    protected MealtrackerManager mealtrackerManager;
    private RegistrantManager registrantManager;
    private String query;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setMealplanManager(MealplanManager mealplanManager) {
        this.mealplanManager = mealplanManager;
    }

    /**
     * @param mealtrackerManager the mealtrackerManager to set
     */
    public void setMealtrackerManager(MealtrackerManager mealtrackerManager) {
        this.mealtrackerManager = mealtrackerManager;
    }

    /**
     * @param registrantManager the registrantManager to set
     */
    public void setRegistrantManager(RegistrantManager registrantManager) {
        this.registrantManager = registrantManager;
    }

    public MealplanList() {
        setSortColumn("registrationID");
    }

    public List getMealplansStat() {
        
        List<Registrant> registrants = registrantManager.getRegistrant();
        List<Mealplan> mealplanStat = new ArrayList<>();
        List<String> container = new ArrayList<>();

        Mealplan totalMealplan = newInstance();
        totalMealplan.setRegistrationID("Total");

        for (Registrant reg : registrants) {
            if (reg.getAmount() > 0 && !container.contains(reg.getRegistrationID())) {
                totalMealplan.setDinner1(reg.getDinner1() + totalMealplan.getDinner1());
                totalMealplan.setDinner2(reg.getDinner2() + totalMealplan.getDinner2());
                totalMealplan.setDinner3(reg.getDinner3() + totalMealplan.getDinner3());
                totalMealplan.setDinner4(reg.getDinner4() + totalMealplan.getDinner4());
                totalMealplan.setLunch1(reg.getLunch1() + totalMealplan.getLunch1());
                totalMealplan.setLunch2(reg.getLunch2() + totalMealplan.getLunch2());
                totalMealplan.setLunch3(reg.getLunch3() + totalMealplan.getLunch3());
                totalMealplan.setLunch4(reg.getLunch4() + totalMealplan.getLunch4());
                totalMealplan.setBreakfast1(reg.getBreakfast1() + totalMealplan.getBreakfast1());
                totalMealplan.setBreakfast2(reg.getBreakfast2() + totalMealplan.getBreakfast2());
                totalMealplan.setBreakfast3(reg.getBreakfast3() + totalMealplan.getBreakfast3());
                totalMealplan.setBreakfast4(reg.getBreakfast4() + totalMealplan.getBreakfast4());
                container.add(reg.getRegistrationID());
            }
        }

        mealplanStat.add(totalMealplan);

        Mealplan scannedMealplan = newInstance();    
        scannedMealplan.setRegistrationID("Scanned");
        
        List<Mealtracker> mealtrackers = mealtrackerManager.getMealtracker();
        for (Mealtracker mt : mealtrackers) {
            if (mt.getMealType().equalsIgnoreCase("DINNER1")) {
                scannedMealplan.setDinner1(scannedMealplan.getDinner1() + 1);
            } else if (mt.getMealType().equalsIgnoreCase("BREAKFAST2")) {
                scannedMealplan.setBreakfast2(scannedMealplan.getBreakfast2() + 1);
            } else if (mt.getMealType().equalsIgnoreCase("LUNCH2")) {
                scannedMealplan.setLunch2(scannedMealplan.getLunch2() + 1);
            } else if (mt.getMealType().equalsIgnoreCase("DINNER2")) {
                scannedMealplan.setDinner2(scannedMealplan.getDinner2() + 1);
            } else if (mt.getMealType().equalsIgnoreCase("BREAKFAST3")) {
                scannedMealplan.setBreakfast3(scannedMealplan.getBreakfast3() + 1);
            } else if (mt.getMealType().equalsIgnoreCase("LUNCH3")) {
                scannedMealplan.setLunch3(scannedMealplan.getLunch3() + 1);
            } else if (mt.getMealType().equalsIgnoreCase("DINNER3")) {
                scannedMealplan.setDinner3(scannedMealplan.getDinner3() + 1);
            } else if (mt.getMealType().equalsIgnoreCase("BREAKFAST4")) {
                scannedMealplan.setBreakfast4(scannedMealplan.getBreakfast4() + 1);
            } else if (mt.getMealType().equalsIgnoreCase("LUNCH4")) {
                scannedMealplan.setLunch4(scannedMealplan.getLunch4() + 1);
            }
        }
        mealplanStat.add(scannedMealplan);

        return mealplanStat;
    }

    public List getMealplans() {

        try {
            return sort(mealplanManager.search(query));
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(mealplanManager.search(query));
        }
    }

    public String search() {
        return "success";
    }

    /**
     * @return the mealtrackerManager
     */
    public MealtrackerManager getMealtrackerManager() {
        return mealtrackerManager;
    }

    private Mealplan newInstance() {
        Mealplan mp = new Mealplan();
        mp.setDinner1(0);
        mp.setDinner2(0);
        mp.setDinner3(0);
        mp.setDinner4(0);

        mp.setLunch1(0);
        mp.setLunch2(0);
        mp.setLunch3(0);
        mp.setLunch4(0);

        mp.setBreakfast1(0);
        mp.setBreakfast2(0);
        mp.setBreakfast3(0);
        mp.setBreakfast4(0);
        return mp;
    }
}
