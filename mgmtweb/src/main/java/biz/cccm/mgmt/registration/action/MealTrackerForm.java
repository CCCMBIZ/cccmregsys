package biz.cccm.mgmt.registration.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import biz.cccm.dao.SearchException;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Mealtracker;
import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.service.MealtrackerManager;
import biz.cccm.mgmt.registration.service.RegistrantManager;
import biz.cccm.webapp.action.BasePage;

public class MealTrackerForm extends BasePage implements Serializable {

    private static final long serialVersionUID = 972359310602744041L;
    protected MealtrackerManager mealtrackerManager;
    protected RegistrantManager registrantManager;
    private List mealtrackers;
    private String query;

    private String mealTotalCount;
    private String mealTakenCount;
    private String mealLeftCount;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setMealtrackerManager(MealtrackerManager mealtrackerManager) {
        this.mealtrackerManager = mealtrackerManager;
    }

    public void setRegistrantManager(RegistrantManager registrantManager) {
        this.registrantManager = registrantManager;
    }

    public MealTrackerForm() {
    }

    public List getMealtrackers() {
        return this.mealtrackers;
    }

    public String enter() {

        reset();

        if (query != null && !query.isEmpty()) {

            try {

                Integer searchNmber = Integer.parseInt(query);

                Registrant registrant = registrantManager.getRegistrantByPersonID(searchNmber);

                Date now = new Date();
                Date firstDayDinner = new GregorianCalendar(2016, Calendar.DECEMBER, 12, 16, 00).getTime();
                Date secondDayBreakfast = new GregorianCalendar(2016, Calendar.DECEMBER, 29, 4, 0).getTime();
                Date secondDayLunch = new GregorianCalendar(2016, Calendar.DECEMBER, 29, 10, 0).getTime();
                Date secondDayDinner = new GregorianCalendar(2016, Calendar.DECEMBER, 29, 16, 0).getTime();
                Date thirdDayBreakfast = new GregorianCalendar(2016, Calendar.DECEMBER, 30, 4, 0).getTime();
                Date thirdDayLunch = new GregorianCalendar(2016, Calendar.DECEMBER, 30, 10, 0).getTime();
                Date thirdDayDinner = new GregorianCalendar(2016, Calendar.DECEMBER, 30, 16, 0).getTime();
                Date fourthDayBreakfast = new GregorianCalendar(2016, Calendar.DECEMBER, 31, 4, 0).getTime();
                Date fourthDayLunch = new GregorianCalendar(2016, Calendar.DECEMBER, 31, 10, 0).getTime();
//
//                Date firstDayDinner = new GregorianCalendar(2015, Calendar.DECEMBER, 12, 16, 00).getTime();
//                Date secondDayBreakfast = new GregorianCalendar(2015, Calendar.DECEMBER, 26, 17, 0).getTime();
//                Date secondDayLunch = new GregorianCalendar(2015, Calendar.DECEMBER, 26, 18, 5).getTime();
//                Date secondDayDinner = new GregorianCalendar(2015, Calendar.DECEMBER, 26, 18, 10).getTime();
//                Date thirdDayBreakfast = new GregorianCalendar(2015, Calendar.DECEMBER, 26, 18, 15).getTime();
//                Date thirdDayLunch = new GregorianCalendar(2015, Calendar.DECEMBER, 26, 18, 20).getTime();
//                Date thirdDayDinner = new GregorianCalendar(2015, Calendar.DECEMBER, 26, 18, 25).getTime();
//                Date fourthDayBreakfast = new GregorianCalendar(2015, Calendar.DECEMBER, 26, 18, 30).getTime();
//                Date fourthDayLunch = new GregorianCalendar(2015, Calendar.DECEMBER, 26, 18, 35).getTime();

                String caption = now.toString();
                int mealTime = 0;

                Mealtracker mt = new Mealtracker();
                mt.setPersonID(registrant.getPersonID());
                mt.setRegistrationID(registrant.getRegistrationID());
                mt.setLastModified(now);

                String name = null;

                if (registrant.getChineseName() != null && !registrant.getChineseName().isEmpty()) {
                    name = registrant.getChineseName();
                }
                if (registrant.getFirstName() != null && !registrant.getFirstName().isEmpty()) {
                    if (name == null) {
                        name = registrant.getFirstName();

                    } else {
                        name += " ";
                        name += registrant.getFirstName();
                    }
                }
                if (registrant.getLastName() != null && !registrant.getLastName().isEmpty()) {
                    if (name == null) {
                        name = registrant.getLastName();

                    } else {
                        name += " ";
                        name += registrant.getLastName();
                    }
                }
                mt.setRemark(name);

                if (now.after(fourthDayLunch)) {
                    mealTime = 9;
                    caption = "LUNCH4";
                    mealTotalCount = String.valueOf(registrant.getLunch4());
                } else if (now.after(fourthDayBreakfast)) {
                    mealTime = 8;
                    caption = "BREAKFAST4";
                    mealTotalCount = String.valueOf(registrant.getBreakfast4());
                } else if (now.after(thirdDayDinner)) {
                    mealTime = 7;
                    caption = "DINNER3";
                    mealTotalCount = String.valueOf(registrant.getDinner3());
                } else if (now.after(thirdDayLunch)) {
                    mealTime = 6;
                    caption = "LUNCH3";
                    mealTotalCount = String.valueOf(registrant.getLunch3());
                } else if (now.after(thirdDayBreakfast)) {
                    mealTime = 5;
                    caption = "BREAKFAST3";
                    mealTotalCount = String.valueOf(registrant.getBreakfast3());
                } else if (now.after(secondDayDinner)) {
                    mealTime = 4;
                    caption = "DINNER2";
                    mealTotalCount = String.valueOf(registrant.getDinner2());
                } else if (now.after(secondDayLunch)) {
                    mealTime = 3;
                    caption = "LUNCH2";
                    mealTotalCount = String.valueOf(registrant.getLunch2());
                } else if (now.after(secondDayBreakfast)) {
                    mealTime = 2;
                    caption = "BREAKFAST2";
                    mealTotalCount = String.valueOf(registrant.getBreakfast2());
                } else if (now.after(firstDayDinner)) {
                    mealTime = 1;
                    caption = "DINNER1";
                    mealTotalCount = String.valueOf(registrant.getDinner1());
                } else {
                }

                mt.setMealType(caption);

                int total = Integer.parseInt(mealTotalCount);
                int taken = 0;
                int left = 0;

//                mealtrackers = mealtrackerManager.search(registrant.getRegistrationID());
                try {
                    mealtrackers = mealtrackerManager.getMealtrackerListByRegistrationIDAndMealType(registrant.getRegistrationID(), caption);
                } catch (NonexistentEntityException ex) {
                    log.error(ex);
                }

                if (mealtrackers != null && !mealtrackers.isEmpty()) {
                    taken = mealtrackers.size();
                } else {
                    mealtrackers = new ArrayList<>();
                }

                if (total == 0) {
                    addError("No Order Record");
                } else if (total <= taken) {
                    addError("Exceed Order Count");
                } else {
                    mealtrackerManager.saveMealtracker(mt);
                    taken++;
                    mealtrackers.add(mt);
                }

                left = total - taken;

                mealTakenCount = String.valueOf(taken);
                mealLeftCount = String.valueOf(left);

                Collections.sort(mealtrackers, new Comparator<Mealtracker>() {
                    @Override
                    public int compare(Mealtracker m1, Mealtracker m2) {
                        return m2.getLastModified().compareTo(m1.getLastModified());
                    }
                });

            } catch (NumberFormatException ex) {
                addError("Invalid entry : " + ex.getMessage());
            } catch (SearchException | NonexistentEntityException se) {
                addError(se.getMessage());
            } finally {
                query = "";
            }
        }

        return "success";
    }



    private void reset() {
        if (mealtrackers != null) {
            mealtrackers.clear();
        }
        mealTotalCount = "0";
        mealTakenCount = "0";
        mealLeftCount = "0";
    }

    /**
     * @return the mealTotalCount
     */
    public String getMealTotalCount() {
        return mealTotalCount;
    }

    /**
     * @return the mealTakenCount
     */
    public String getMealTakenCount() {
        return mealTakenCount;
    }

    /**
     * @return the mealLeftCount
     */
    public String getMealLeftCount() {
        return mealLeftCount;
    }
}
