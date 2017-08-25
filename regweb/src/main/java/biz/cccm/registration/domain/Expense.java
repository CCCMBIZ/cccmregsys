/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.domain;

/**
 *
 * @author Ephesus
 */
public class Expense extends BaseObject {

    private Integer eventID;
    private Long registrationID;

    private int breakfastCount;
    private double totalBreakfastFee;

    private int lunchCount;
    private double totalLunchFee;

    private int dinnerCount;
    private double totalDinnerFee;

    private double totalMealsFee;

    // Registration Fee
    private int adultHeadcount;
    private int nonAdultHeadcount;
    private int nonAdultXHeadcount;

    private double adultRegistrationFee;
    private double nonAdultRegistrationFee;

    private double totalRegistrationFee;
    private String currency ;
    /**
     * @return the eventID
     */
    public Integer getEventID() {
        return eventID;
    }

    /**
     * @param eventID the eventID to set
     */
    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    /**
     * @return the registrationID
     */
    public Long getRegistrationID() {
        return registrationID;
    }

    /**
     * @param registrationID the registrationID to set
     */
    public void setRegistrationID(Long registrationID) {
        this.registrationID = registrationID;
    }

    /**
     * @return the breakfastCount
     */
    public int getBreakfastCount() {
        return breakfastCount;
    }

    /**
     * @param breakfastCount the breakfastCount to set
     */
    public void setBreakfastCount(int breakfastCount) {
        this.breakfastCount = breakfastCount;
    }

    /**
     * @return the totalBreakfastFee
     */
    public double getTotalBreakfastFee() {
        return totalBreakfastFee;
    }

    /**
     * @param totalBreakfastFee the totalBreakfastFee to set
     */
    public void setTotalBreakfastFee(double totalBreakfastFee) {
        this.totalBreakfastFee = totalBreakfastFee;
    }

    /**
     * @return the lunchCount
     */
    public int getLunchCount() {
        return lunchCount;
    }

    /**
     * @param lunchCount the lunchCount to set
     */
    public void setLunchCount(int lunchCount) {
        this.lunchCount = lunchCount;
    }

    /**
     * @return the totalLunchFee
     */
    public double getTotalLunchFee() {
        return totalLunchFee;
    }

    /**
     * @param totalLunchFee the totalLunchFee to set
     */
    public void setTotalLunchFee(double totalLunchFee) {
        this.totalLunchFee = totalLunchFee;
    }

    /**
     * @return the dinnerCount
     */
    public int getDinnerCount() {
        return dinnerCount;
    }

    /**
     * @param dinnerCount the dinnerCount to set
     */
    public void setDinnerCount(int dinnerCount) {
        this.dinnerCount = dinnerCount;
    }

    /**
     * @return the totalDinnerFee
     */
    public double getTotalDinnerFee() {
        return totalDinnerFee;
    }

    /**
     * @param totalDinnerFee the totalDinnerFee to set
     */
    public void setTotalDinnerFee(double totalDinnerFee) {
        this.totalDinnerFee = totalDinnerFee;
    }

    /**
     * @return the totalMealsFee
     */
    public double getTotalMealsFee() {
        return totalMealsFee;
    }

    /**
     * @param totalMealsFee the totalMealsFee to set
     */
    public void setTotalMealsFee(double totalMealsFee) {
        this.totalMealsFee = totalMealsFee;
    }

    /**
     * @return the adultHeadcount
     */
    public int getAdultHeadcount() {
        return adultHeadcount;
    }

    /**
     * @param adultHeadcount the adultHeadcount to set
     */
    public void setAdultHeadcount(int adultHeadcount) {
        this.adultHeadcount = adultHeadcount;
    }

    /**
     * @return the nonAdultHeadcount
     */
    public int getNonAdultHeadcount() {
        return nonAdultHeadcount;
    }

    /**
     * @param nonAdultHeadcount the nonAdultHeadcount to set
     */
    public void setNonAdultHeadcount(int nonAdultHeadcount) {
        this.nonAdultHeadcount = nonAdultHeadcount;
    }

    /**
     * @return the nonAdultXHeadcount
     */
    public int getNonAdultXHeadcount() {
        return nonAdultXHeadcount;
    }

    /**
     * @param nonAdultXHeadcount the nonAdultXHeadcount to set
     */
    public void setNonAdultXHeadcount(int nonAdultXHeadcount) {
        this.nonAdultXHeadcount = nonAdultXHeadcount;
    }

    /**
     * @return the totalAdultRegistrationFee
     */
    public double getAdultRegistrationFee() {
        return adultRegistrationFee;
    }

    /**
     * @param adultRegistrationFee
     */
    public void setAdultRegistrationFee(double adultRegistrationFee) {
        this.adultRegistrationFee = adultRegistrationFee;
    }

    /**
     * @return the totalNonAdultRegistrationFee
     */
    public double getNonAdultRegistrationFee() {
        return nonAdultRegistrationFee;
    }

    /**
     * @param nonAdultRegistrationFee
     */
    public void setnNonAdultRegistrationFee(double nonAdultRegistrationFee) {
        this.nonAdultRegistrationFee = nonAdultRegistrationFee;
    }

    /**
     * @return the totalRegistrationFee
     */
    public double getTotalRegistrationFee() {
        return totalRegistrationFee;
    }

    /**
     * @param totalRegistrationFee the totalRegistrationFee to set
     */
    public void setTotalRegistrationFee(double totalRegistrationFee) {
        this.totalRegistrationFee = totalRegistrationFee;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
