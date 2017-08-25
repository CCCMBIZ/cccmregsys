/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.action;

import java.io.Serializable;

/**
 * @author CH1CHOO1
 */
public class Statistic implements Serializable {

    /**
     * @return the totalSeminar1
     */
    public Integer getTotalSeminar1() {
        return totalSeminar1;
    }

    /**
     * @param totalSeminar1 the totalSeminar1 to set
     */
    public void setTotalSeminar1(Integer totalSeminar1) {
        this.totalSeminar1 = totalSeminar1;
    }

    /**
     * @return the totalSeminar2
     */
    public Integer getTotalSeminar2() {
        return totalSeminar2;
    }

    /**
     * @param totalSeminar2 the totalSeminar2 to set
     */
    public void setTotalSeminar2(Integer totalSeminar2) {
        this.totalSeminar2 = totalSeminar2;
    }

    /**
     * @return the totalSeminar3
     */
    public Integer getTotalSeminar3() {
        return totalSeminar3;
    }

    /**
     * @param totalSeminar3 the totalSeminar3 to set
     */
    public void setTotalSeminar3(Integer totalSeminar3) {
        this.totalSeminar3 = totalSeminar3;
    }

    /**
     * @return the totalSeminar4
     */
    public Integer getTotalSeminar4() {
        return totalSeminar4;
    }

    /**
     * @param totalSeminar4 the totalSeminar4 to set
     */
    public void setTotalSeminar4(Integer totalSeminar4) {
        this.totalSeminar4 = totalSeminar4;
    }

    private static final long serialVersionUID = -558954560L;
    private Long churchID;
    private String churchName;
    private Integer totalAdultA6;
    private Integer totalAdultA5;
    private Integer totalAdultA4;
    private Integer totalAdultA3;
    private Integer totalAdultA2;
    private Integer totalAdult;
    private Integer totalYouth;
    private Integer totalK6G;
    private Integer totalPreschool;
    private Integer totalBaby;
    private Integer totalNonAdult;
    private Integer totalChristian;
    private Integer totalSeeker;
    private Integer totalBreakfast1;
    private Integer totalBreakfast2;
    private Integer totalBreakfast3;
    private Integer totalBreakfast4;
    private Integer totalLunch1;
    private Integer totalLunch2;
    private Integer totalLunch3;
    private Integer totalLunch4;
    private Integer totalDinner1;
    private Integer totalDinner2;
    private Integer totalDinner3;
    private Integer totalDinner4;
    private Integer totalMisc1;
    private Integer totalMisc2;
    private Integer totalEnglishConference;
    private Integer totalChineseConference;
    private Integer totalChildrenGroup1;
    private Integer totalChildrenGroup2;
    private Integer totalToddler;
    private Integer totalSeminar1;
    private Integer totalSeminar2;
    private Integer totalSeminar3;
    private Integer totalSeminar4;

    public Statistic() {
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Long getChurchID() {
        return churchID;
    }

    public void setChurchID(Long churchID) {
        this.churchID = churchID;
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public Integer getTotalAdultA6() {
        return totalAdultA6;
    }

    public void setTotalAdultA6(Integer totalAdultA6) {
        this.totalAdultA6 = totalAdultA6;
    }

    public Integer getTotalAdultA5() {
        return totalAdultA5;
    }

    public void setTotalAdultA5(Integer totalAdultA5) {
        this.totalAdultA5 = totalAdultA5;
    }

    public Integer getTotalAdultA4() {
        return totalAdultA4;
    }

    public void setTotalAdultA4(Integer totalAdultA4) {
        this.totalAdultA4 = totalAdultA4;
    }

    public Integer getTotalAdultA3() {
        return totalAdultA3;
    }

    public void setTotalAdultA3(Integer totalAdultA3) {
        this.totalAdultA3 = totalAdultA3;
    }

    public Integer getTotalAdultA2() {
        return totalAdultA2;
    }

    public void setTotalAdultA2(Integer totalAdultA2) {
        this.totalAdultA2 = totalAdultA2;
    }

    public Integer getTotalAdult() {
        return totalAdult;
    }

    public void setTotalAdult(Integer totalAdult) {
        this.totalAdult = totalAdult;
    }

    public Integer getTotalYouth() {
        return totalYouth;
    }

    public void setTotalYouth(Integer totalYouth) {
        this.totalYouth = totalYouth;
    }

    public Integer getTotalK6G() {
        return totalK6G;
    }

    public void setTotalK6G(Integer totalK6G) {
        this.totalK6G = totalK6G;
    }

    public Integer getTotalPreschool() {
        return totalPreschool;
    }

    public void setTotalPreschool(Integer totalPreschool) {
        this.totalPreschool = totalPreschool;
    }

    public Integer getTotalBaby() {
        return totalBaby;
    }

    public void setTotalBaby(Integer totalBaby) {
        this.totalBaby = totalBaby;
    }

    public Integer getTotalNonAdult() {
        return totalNonAdult;
    }

    public void setTotalNonAdult(Integer totalNonAdult) {
        this.totalNonAdult = totalNonAdult;
    }

    public Integer getTotalChristian() {
        return totalChristian;
    }

    public void setTotalChristian(Integer totalChristian) {
        this.totalChristian = totalChristian;
    }

    public Integer getTotalSeeker() {
        return totalSeeker;
    }

    public void setTotalSeeker(Integer totalSeeker) {
        this.totalSeeker = totalSeeker;
    }

    public Integer getTotalBreakfast1() {
        return totalBreakfast1;
    }

    public void setTotalBreakfast1(Integer totalBreakfast1) {
        this.totalBreakfast1 = totalBreakfast1;
    }

    public Integer getTotalBreakfast2() {
        return totalBreakfast2;
    }

    public void setTotalBreakfast2(Integer totalBreakfast2) {
        this.totalBreakfast2 = totalBreakfast2;
    }

    public Integer getTotalBreakfast3() {
        return totalBreakfast3;
    }

    public void setTotalBreakfast3(Integer totalBreakfast3) {
        this.totalBreakfast3 = totalBreakfast3;
    }

    public Integer getTotalBreakfast4() {
        return totalBreakfast4;
    }

    public void setTotalBreakfast4(Integer totalBreakfast4) {
        this.totalBreakfast4 = totalBreakfast4;
    }

    public Integer getTotalLunch1() {
        return totalLunch1;
    }

    public void setTotalLunch1(Integer totalLunch1) {
        this.totalLunch1 = totalLunch1;
    }

    public Integer getTotalLunch2() {
        return totalLunch2;
    }

    public void setTotalLunch2(Integer totalLunch2) {
        this.totalLunch2 = totalLunch2;
    }

    public Integer getTotalLunch3() {
        return totalLunch3;
    }

    public void setTotalLunch3(Integer totalLunch3) {
        this.totalLunch3 = totalLunch3;
    }

    public Integer getTotalLunch4() {
        return totalLunch4;
    }

    public void setTotalLunch4(Integer totalLunch4) {
        this.totalLunch4 = totalLunch4;
    }

    public Integer getTotalDinner1() {
        return totalDinner1;
    }

    public void setTotalDinner1(Integer totalDinner1) {
        this.totalDinner1 = totalDinner1;
    }

    public Integer getTotalDinner2() {
        return totalDinner2;
    }

    public void setTotalDinner2(Integer totalDinner2) {
        this.totalDinner2 = totalDinner2;
    }

    public Integer getTotalDinner3() {
        return totalDinner3;
    }

    public void setTotalDinner3(Integer totalDinner3) {
        this.totalDinner3 = totalDinner3;
    }

    public Integer getTotalDinner4() {
        return totalDinner4;
    }

    public void setTotalDinner4(Integer totalDinner4) {
        this.totalDinner4 = totalDinner4;
    }

    public Integer getTotalMisc1() {
        return totalMisc1;
    }

    public void setTotalMisc1(Integer totalMisc1) {
        this.totalMisc1 = totalMisc1;
    }

    public Integer getTotalMisc2() {
        return totalMisc2;
    }

    public void setTotalMisc2(Integer totalMisc2) {
        this.totalMisc2 = totalMisc2;
    }

    /**
     * @return the totalEnglishConference
     */
    public Integer getTotalEnglishConference() {
        return totalEnglishConference;
    }

    /**
     * @param totalEnglishConference the totalEnglishConference to set
     */
    public void setTotalEnglishConference(Integer totalEnglishConference) {
        this.totalEnglishConference = totalEnglishConference;
    }

    /**
     * @return the totalChineseConference
     */
    public Integer getTotalChineseConference() {
        return totalChineseConference;
    }

    /**
     * @param totalChineseConference the totalChineseConference to set
     */
    public void setTotalChineseConference(Integer totalChineseConference) {
        this.totalChineseConference = totalChineseConference;
    }

    /**
     * @return the totalChildrenGroup1
     */
    public Integer getTotalChildrenGroup1() {
        return totalChildrenGroup1;
    }

    /**
     * @param totalChildrenGroup1 the totalChildrenGroup1 to set
     */
    public void setTotalChildrenGroup1(Integer totalChildrenGroup1) {
        this.totalChildrenGroup1 = totalChildrenGroup1;
    }

    /**
     * @return the totalChildrenGroup2
     */
    public Integer getTotalChildrenGroup2() {
        return totalChildrenGroup2;
    }

    /**
     * @param totalChildrenGroup2 the totalChildrenGroup2 to set
     */
    public void setTotalChildrenGroup2(Integer totalChildrenGroup2) {
        this.totalChildrenGroup2 = totalChildrenGroup2;
    }

    /**
     * @return the totalToddler
     */
    public Integer getTotalToddler() {
        return totalToddler;
    }

    /**
     * @param totalToddler the totalToddler to set
     */
    public void setTotalToddler(Integer totalToddler) {
        this.totalToddler = totalToddler;
    }
}
