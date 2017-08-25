/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.domain;

import java.io.Serializable;
import org.joda.time.DateTime;

/**
 *
 * @author Ephesus
 */
public class Fee implements Serializable {

    /**
     * @return the expirationDate
     */
    public DateTime getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(DateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    private String eventID;
    private DateTime effectiveDate;
    private DateTime expirationDate;
    private Integer ageLevel;
    private int priority;
    private String codeName;
    private String description;
    private Double amount;
    private String currency;

    /**
     * @return the eventID
     */
    public String getEventID() {
        return eventID;
    }

    /**
     * @param eventID the eventID to set
     */
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    /**
     * @return the ageLevel
     */
    public Integer getAgeLevel() {
        return ageLevel;
    }

    /**
     * @param ageLevel the ageLevel to set
     */
    public void setAgeLevel(Integer ageLevel) {
        this.ageLevel = ageLevel;
    }

    /**
     * @return the effectiveDate
     */
    public DateTime getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * @param effectiveDate the effectiveDate to set
     */
    public void setEffectiveDate(DateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the codeName
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * @param codeName the codeName to set
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
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
