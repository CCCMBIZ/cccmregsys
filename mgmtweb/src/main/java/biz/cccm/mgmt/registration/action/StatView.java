package biz.cccm.mgmt.registration.action;

import java.io.Serializable;
import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.service.RegistrantManager;
import biz.cccm.webapp.action.BasePage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatView extends BasePage implements Serializable {

    private static final long serialVersionUID = 972359310603744041L;

    private RegistrantManager registrantManager;

    private List<Statistic> statistics;

    private List<Statistic> workshopStat;

    /**
     * @return the registrantManager
     */
    public RegistrantManager getRegistrantManager() {
        return registrantManager;
    }

    /**
     * @return the statistics
     */
    public List<Statistic> getStatistics() {

        try {
            generateReport();
        } catch (Exception ex) {
            Logger.getLogger(StatView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statistics;
    }

    /**
     * @param statistics the statistics to set
     */
    public void setStatistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    /**
     * @return the workshopStat
     */
    public List<Statistic> getWorkshopStat() {
        return workshopStat;
    }

    /**
     * @param workshopStat the workshopStat to set
     */
    public void setWorkshopStat(List<Statistic> workshopStat) {
        this.workshopStat = workshopStat;
    }

    public void setRegistrantManager(RegistrantManager registrantManager) {
        this.registrantManager = registrantManager;
    }

    public StatView() {
    }

    public String generateReport() throws Exception {
        log.debug("entering Statistic Controller...");
        log.debug("count = " + registrantManager.getAll().size());

        Statistic grandTotal = new Statistic();
        String currRegistrationId = "";
//
//        if (grandTotal == null) {
//            grandTotal = new Statistic();
//        }
//
        initialize(grandTotal);

//        List registrationList = null;
//        Iterator itr = registrantManager.getRegistrant().iterator();
//        registrationList = new ArrayList();
        HashMap churchStats = new HashMap();
        HashMap seminarStats = new HashMap();

        for (Registrant registrant : registrantManager.getRegistrant()) {

            if (registrant.getAmount() == null || registrant.getAmount() == 0.0) {
                continue;
            }

//        while (itr.hasNext()) {
//            Registrant reg = (Registrant) itr.next();
//            registrationList = registrantManager.getAll();
//            HashMap seminarStats = new HashMap();
//            HashMap statusStats = new HashMap();
//            Iterator<Registrant> iter = registrationList.iterator();
//            while (iter.hasNext()) {
//            Registrant registration = iter.next();
//            if (registrant.getMisc1() != null && registrant.getMisc1()) {
//                continue ;
//            }
//            if (registrant.getChurchID() == null || registrant.getChurchID().intValue() == 0) {
//                registrant.setChurchID(888L);
//                registrant.setLanguage("E");
//            }
            Statistic stat = (Statistic) churchStats.get(registrant.getChurchName());

            if (stat == null) {
                stat = new Statistic();
                initialize(stat);

                stat.setChurchName(registrant.getChurchName());

//                Church church = (Church) churchManager.get(stat.getChurchID());
//                stat.setChurchName(church.getAcronym() + " " + church.getChurchNameChn());
            }

            //Prefered Language
            if (registrant.getPreferredLanguage() != null && registrant.getPreferredLanguage().equalsIgnoreCase("M")) {
                stat.setTotalChineseConference(stat.getTotalChineseConference() + 1);
                grandTotal.setTotalChineseConference(grandTotal.getTotalChineseConference() + 1);
            } else if (registrant.getPreferredLanguage() != null && registrant.getPreferredLanguage().equalsIgnoreCase("E")) {
                stat.setTotalEnglishConference(stat.getTotalEnglishConference() + 1);
                grandTotal.setTotalEnglishConference(grandTotal.getTotalEnglishConference() + 1);
            } else if (registrant.getPreferredLanguage() != null && registrant.getPreferredLanguage().equalsIgnoreCase("C")) {
                stat.setTotalChildrenGroup2(stat.getTotalChildrenGroup2() + 1);
                grandTotal.setTotalChildrenGroup2(grandTotal.getTotalChildrenGroup2() + 1);
            } else if (registrant.getPreferredLanguage() != null && registrant.getPreferredLanguage().equalsIgnoreCase("K")) {
                stat.setTotalChildrenGroup1(stat.getTotalChildrenGroup1() + 1);
                grandTotal.setTotalChildrenGroup1(grandTotal.getTotalChildrenGroup1() + 1);
            } else if (registrant.getPreferredLanguage() != null && registrant.getPreferredLanguage().equalsIgnoreCase("T")) {
                stat.setTotalToddler(stat.getTotalToddler() + 1);
                grandTotal.setTotalToddler(grandTotal.getTotalToddler() + 1);
            }

            // Age
            if (registrant.getAge() != null && registrant.getAge().length() > 0 && registrant.getAge().charAt(0) == 'A') {

                if (registrant.getAge().equalsIgnoreCase("A6")) {
                    stat.setTotalAdultA6(stat.getTotalAdultA6() + 1);
                    grandTotal.setTotalAdultA6(grandTotal.getTotalAdultA6() + 1);
                } else if (registrant.getAge().equalsIgnoreCase("A5")) {
                    stat.setTotalAdultA5(stat.getTotalAdultA5() + 1);
                    grandTotal.setTotalAdultA5(grandTotal.getTotalAdultA5() + 1);
                } else if (registrant.getAge().equalsIgnoreCase("A4")) {
                    stat.setTotalAdultA4(stat.getTotalAdultA4() + 1);
                    grandTotal.setTotalAdultA4(grandTotal.getTotalAdultA4() + 1);
                } else if (registrant.getAge().equalsIgnoreCase("A3")) {
                    stat.setTotalAdultA3(stat.getTotalAdultA3() + 1);
                    grandTotal.setTotalAdultA3(grandTotal.getTotalAdultA3() + 1);
                } else if (registrant.getAge().equalsIgnoreCase("A2")) {
                    stat.setTotalAdultA2(stat.getTotalAdultA2() + 1);
                    grandTotal.setTotalAdultA2(grandTotal.getTotalAdultA2() + 1);
                }

                stat.setTotalAdult((Integer) (stat.getTotalAdult() + 1));
                grandTotal.setTotalAdult((Integer) (grandTotal.getTotalAdult() + 1));

                // Faith for Adult
                if (registrant.getAcceptedChrist() != null && registrant.getAcceptedChrist()) {
                    stat.setTotalChristian(stat.getTotalChristian() + 1);
                    grandTotal.setTotalChristian(grandTotal.getTotalChristian() + 1);
                } else if (registrant.getAcceptedChrist() != null && !registrant.getAcceptedChrist()) {
                    stat.setTotalSeeker(stat.getTotalSeeker() + 1);
                    grandTotal.setTotalSeeker(grandTotal.getTotalSeeker() + 1);
                } else {
                    // No faith status
                    stat.setTotalMisc2(stat.getTotalMisc2() + 1);
                    grandTotal.setTotalMisc2(grandTotal.getTotalMisc2() + 1);
                }
//                if (registrant.getLanguage() != null && registrant.getLanguage().equalsIgnoreCase("E")) {
//                    stat.setTotalEnglishSpeakingAdult(stat.getTotalEnglishSpeakingAdult() + 1);
//                    grandTotal.setTotalEnglishSpeakingAdult(grandTotal.getTotalEnglishSpeakingAdult() + 1);
//                }
                //   Obtain seminar statistics
                if (registrant.getWorkshop1() != null && registrant.getWorkshop1().length() > 0) {

                    StringTokenizer st = new StringTokenizer(registrant.getWorkshop1(), "|");
                    Statistic cstat = null;

                    while (st.hasMoreTokens()) {
                        String sem = st.nextToken();

                        if (sem != null && !sem.isEmpty()) {
                            cstat = (Statistic) seminarStats.get(sem);

                            if (cstat == null) {
                                cstat = new Statistic();
                                initialize(cstat);
                                cstat.setChurchName(sem);
                            }

                            cstat.setTotalAdult(cstat.getTotalAdult() + 1);
                            seminarStats.put(sem, cstat);

                        }
                    }

                }
                if (registrant.getWorkshop2() != null && registrant.getWorkshop2().length() > 0) {

                    StringTokenizer st = new StringTokenizer(registrant.getWorkshop2(), "|");
                    Statistic cstat = null;

                    while (st.hasMoreTokens()) {
                        String sem = st.nextToken();

                        if (sem != null && !sem.isEmpty()) {
                            cstat = (Statistic) seminarStats.get(sem);

                            if (cstat == null) {
                                cstat = new Statistic();
                                initialize(cstat);
                                cstat.setChurchName(sem);
                            }

                            cstat.setTotalAdult(cstat.getTotalAdult() + 1);
                            seminarStats.put(sem, cstat);

                        }
                    }

                }

            } else {
                Integer intAge;
                try {
                    intAge = Integer.valueOf(registrant.getAge());
                } catch (NumberFormatException ex) {
                    log.error("Missing Age information:" + ex.getMessage());
                    continue;
                }
                if (intAge >= 12) {
                    stat.setTotalYouth(stat.getTotalYouth() + 1);
                    grandTotal.setTotalYouth(grandTotal.getTotalYouth() + 1);
                } else if (intAge >= 5 && intAge < 12) {
                    stat.setTotalK6G(stat.getTotalK6G() + 1);
                    grandTotal.setTotalK6G(grandTotal.getTotalK6G() + 1);
                } else if (intAge >= 3 && intAge < 5) {
                    stat.setTotalPreschool(stat.getTotalPreschool() + 1);
                    grandTotal.setTotalPreschool(grandTotal.getTotalPreschool() + 1);
                } else if (intAge <= 2) {
                    stat.setTotalBaby(stat.getTotalBaby() + 1);
                    grandTotal.setTotalBaby(grandTotal.getTotalBaby() + 1);
                }

                stat.setTotalNonAdult((Integer) (stat.getTotalNonAdult() + 1));
                grandTotal.setTotalNonAdult((Integer) (grandTotal.getTotalNonAdult() + 1));
            }

            // Obtain meals count from each registration in same form
            if (currRegistrationId.compareTo(registrant.getRegistrationID()) != 0) {

                currRegistrationId = registrant.getRegistrationID();

                // Meals
                if (registrant.getBreakfast1() > 0) {
                    stat.setTotalBreakfast1(stat.getTotalBreakfast1() + registrant.getBreakfast1());
                    grandTotal.setTotalBreakfast1(grandTotal.getTotalBreakfast1() + registrant.getBreakfast1());
                }

                if (registrant.getBreakfast2() > 0) {
                    stat.setTotalBreakfast2(stat.getTotalBreakfast2() + registrant.getBreakfast2());
                    grandTotal.setTotalBreakfast2(grandTotal.getTotalBreakfast2() + registrant.getBreakfast2());
                }

                if (registrant.getBreakfast3() > 0) {
                    stat.setTotalBreakfast3(stat.getTotalBreakfast3() + registrant.getBreakfast3());
                    grandTotal.setTotalBreakfast3(grandTotal.getTotalBreakfast3() + registrant.getBreakfast3());
                }

                if (registrant.getBreakfast4() > 0) {
                    stat.setTotalBreakfast4(stat.getTotalBreakfast4() + registrant.getBreakfast4());
                    grandTotal.setTotalBreakfast4(grandTotal.getTotalBreakfast4() + registrant.getBreakfast4());
                }

                if (registrant.getLunch1() > 0) {
                    stat.setTotalLunch1(stat.getTotalLunch1() + registrant.getLunch1());
                    grandTotal.setTotalLunch1(grandTotal.getTotalLunch1() + registrant.getLunch1());
                }

                if (registrant.getLunch2() > 0) {
                    stat.setTotalLunch2(stat.getTotalLunch2() + registrant.getLunch2());
                    grandTotal.setTotalLunch2(grandTotal.getTotalLunch2() + registrant.getLunch2());
                }

                if (registrant.getLunch3() > 0) {
                    stat.setTotalLunch3(stat.getTotalLunch3() + registrant.getLunch3());
                    grandTotal.setTotalLunch3(grandTotal.getTotalLunch3() + registrant.getLunch3());
                }

                if (registrant.getLunch4() > 0) {
                    stat.setTotalLunch4(stat.getTotalLunch4() + registrant.getLunch4());
                    grandTotal.setTotalLunch4(grandTotal.getTotalLunch4() + registrant.getLunch4());
                }

                if (registrant.getDinner1() > 0) {
                    stat.setTotalDinner1(stat.getTotalDinner1() + registrant.getDinner1());
                    grandTotal.setTotalDinner1(grandTotal.getTotalDinner1() + registrant.getDinner1());
                }

                if (registrant.getDinner2() > 0) {
                    stat.setTotalDinner2(stat.getTotalDinner2() + registrant.getDinner2());
                    grandTotal.setTotalDinner2(grandTotal.getTotalDinner2() + registrant.getDinner2());
                }

                if (registrant.getDinner3() > 0) {
                    stat.setTotalDinner3(stat.getTotalDinner3() + registrant.getDinner3());
                    grandTotal.setTotalDinner3(grandTotal.getTotalDinner3() + registrant.getDinner3());
                }

                if (registrant.getDinner4() > 0) {
                    stat.setTotalDinner4(stat.getTotalDinner4() + registrant.getDinner4());
                    grandTotal.setTotalDinner4(grandTotal.getTotalDinner4() + registrant.getDinner4());
                }

            }

            // Misc
            stat.setTotalMisc1(stat.getTotalMisc1() + 1);
            grandTotal.setTotalMisc1(grandTotal.getTotalMisc1() + 1);

            churchStats.put(stat.getChurchName(), stat);
        }

        // Create grand total overview
        grandTotal.setChurchID(new Long(0));
        grandTotal.setChurchName("[\u5927\u4F1A\u7E3D\u6570]");

//        List<Statistic> grandTotalStat = new ArrayList();
//        grandTotalStat.add(grandTotal);
//        churchStats.put(grandTotal.getChurchName(), grandTotal) ;
        // Create English conference overview
//        Statistic grace = (Statistic) churchStats.remove(new Long(9999L));
//        List<Statistic> engStat = new ArrayList();
//        grace.setChurchName("English Conference");
//        engStat.add(grace);
        // Create Chinese total
//        Statistic chineseTotal = substract(grandTotal, grace);
//        chineseTotal.setChurchID(new Long(0));
//        chineseTotal.setChurchName("Chinese Total");
//
//        churchStats.put(chineseTotal.getChurchID(), chineseTotal);
        // Create Chinese conference overview
        setStatistics((List<Statistic>) new ArrayList(churchStats.values()));
        statistics.add(0, grandTotal);

        setWorkshopStat((List<Statistic>) new ArrayList(seminarStats.values()));
//
//        List<Statistic> seminarStatistics = new ArrayList(seminarStats.values());

//            model.addObject("statistics", statistics);
////        model.addObject("engStatistics", engStat);
//            model.addObject("totalStatistics", grandTotalStat);
//            model.addObject("grandTotal", grandTotal);
//            model.addObject("seminarStatistics", seminarStatistics);
        return "performance";
    }

    private void initialize(Statistic stat) {

        if (stat == null) {

            stat = new Statistic();
        }

        stat.setTotalAdultA6(0);
        stat.setTotalAdultA5(0);
        stat.setTotalAdultA4(0);
        stat.setTotalAdultA3(0);
        stat.setTotalAdultA2(0);
        stat.setTotalAdult(0);
        stat.setTotalYouth(0);
        stat.setTotalK6G(0);
        stat.setTotalPreschool(0);
        stat.setTotalBaby(0);
        stat.setTotalNonAdult(0);
        stat.setTotalChristian(0);
        stat.setTotalSeeker(0);
        stat.setTotalBreakfast1(0);
        stat.setTotalBreakfast2(0);
        stat.setTotalBreakfast3(0);
        stat.setTotalBreakfast4(0);
        stat.setTotalLunch1(0);
        stat.setTotalLunch2(0);
        stat.setTotalLunch3(0);
        stat.setTotalLunch4(0);
        stat.setTotalDinner1(0);
        stat.setTotalDinner2(0);
        stat.setTotalDinner3(0);
        stat.setTotalDinner4(0);
        stat.setTotalMisc1(0);
        stat.setTotalMisc2(0);
        stat.setTotalChineseConference(0);
        stat.setTotalEnglishConference(0);
        stat.setTotalChildrenGroup1(0);
        stat.setTotalChildrenGroup2(0);
        stat.setTotalToddler(0);

    }

//    private Statistic substract(Statistic stat1, Statistic stat2) {
//
//        Statistic stat = new Statistic();
//        stat.setTotalAdult(stat1.getTotalAdult() - stat2.getTotalAdult());
//        stat.setTotalAdultA2(stat1.getTotalAdultA2() - stat2.getTotalAdultA2());
//        stat.setTotalAdultA3(stat1.getTotalAdultA3() - stat2.getTotalAdultA3());
//        stat.setTotalAdultA4(stat1.getTotalAdultA4() - stat2.getTotalAdultA4());
//        stat.setTotalAdultA5(stat1.getTotalAdultA5() - stat2.getTotalAdultA5());
//        stat.setTotalAdultA6(stat1.getTotalAdultA6() - stat2.getTotalAdultA6());
//        stat.setTotalYouth(stat1.getTotalYouth() - stat2.getTotalYouth());
//        stat.setTotalK6G(stat1.getTotalK6G() - stat2.getTotalK6G());
//        stat.setTotalPreschool(stat1.getTotalPreschool() - stat2.getTotalPreschool());
//        stat.setTotalBaby(stat1.getTotalBaby() - stat2.getTotalBaby());
//        stat.setTotalNonAdult(stat1.getTotalNonAdult() - stat2.getTotalNonAdult());
//        stat.setTotalChristian(stat1.getTotalChristian() - stat2.getTotalChristian());
//        stat.setTotalSeeker(stat1.getTotalSeeker() - stat2.getTotalSeeker());
//        stat.setTotalBreakfast1(stat1.getTotalBreakfast1() - stat2.getTotalBreakfast1());
//        stat.setTotalBreakfast2(stat1.getTotalBreakfast2() - stat2.getTotalBreakfast2());
//        stat.setTotalBreakfast3(stat1.getTotalBreakfast3() - stat2.getTotalBreakfast3());
//        stat.setTotalBreakfast4(stat1.getTotalBreakfast4() - stat2.getTotalBreakfast4());
//        stat.setTotalLunch1(stat1.getTotalLunch1() - stat2.getTotalLunch1());
//        stat.setTotalLunch2(stat1.getTotalLunch2() - stat2.getTotalLunch2());
//        stat.setTotalLunch3(stat1.getTotalLunch3() - stat2.getTotalLunch3());
//        stat.setTotalLunch4(stat1.getTotalLunch4() - stat2.getTotalLunch4());
//        stat.setTotalDinner1(stat1.getTotalDinner1() - stat2.getTotalDinner1());
//        stat.setTotalDinner2(stat1.getTotalDinner2() - stat2.getTotalDinner2());
//        stat.setTotalDinner3(stat1.getTotalDinner3() - stat2.getTotalDinner3());
//        stat.setTotalDinner4(stat1.getTotalDinner4() - stat2.getTotalDinner4());
//        stat.setTotalMisc1(stat1.getTotalMisc1() - stat2.getTotalMisc1());
//        stat.setTotalMisc2(stat1.getTotalMisc2() - stat2.getTotalMisc2());
//        stat.setTotalEnglishConference(stat1.getTotalEnglishConference() - stat2.getTotalEnglishConference());
//
//        return stat;
//    }
}
