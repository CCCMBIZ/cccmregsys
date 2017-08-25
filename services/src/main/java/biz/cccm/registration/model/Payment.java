/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ephesus
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findById", query = "SELECT p FROM Payment p WHERE p.id = :id"),
    @NamedQuery(name = "Payment.findByAmount", query = "SELECT p FROM Payment p WHERE p.amount = :amount"),
    @NamedQuery(name = "Payment.findByCash", query = "SELECT p FROM Payment p WHERE p.cash = :cash"),
    @NamedQuery(name = "Payment.findByCreditCard", query = "SELECT p FROM Payment p WHERE p.creditCard = :creditCard"),
    @NamedQuery(name = "Payment.findByPaidByConference", query = "SELECT p FROM Payment p WHERE p.paidByConference = :paidByConference"),
    @NamedQuery(name = "Payment.findByPaymentDate", query = "SELECT p FROM Payment p WHERE p.paymentDate = :paymentDate"),
    @NamedQuery(name = "Payment.findByPersonalCheck", query = "SELECT p FROM Payment p WHERE p.personalCheck = :personalCheck"),
    @NamedQuery(name = "Payment.findByRefund", query = "SELECT p FROM Payment p WHERE p.refund = :refund"),
    @NamedQuery(name = "Payment.findByRegistrationID", query = "SELECT p FROM Payment p WHERE p.registrationID = :registrationID"),
    @NamedQuery(name = "Payment.findByRemarks", query = "SELECT p FROM Payment p WHERE p.remarks = :remarks")})
public class Payment extends BaseObject {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "cash")
    private Boolean cash;
    @Column(name = "creditCard")
    private Boolean creditCard;
    @Column(name = "paidByConference")
    private Boolean paidByConference;
    @Column(name = "paymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Column(name = "personalCheck")
    private Boolean personalCheck;
    @Column(name = "refund")
    private Boolean refund;
    @Column(name = "registrationID")
    private Long registrationID;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "referenceNumber")
    private String referenceNumber;
    @Column(name = "RegistrationFee")
    private Double registrationFee;
    @Column(name = "MealFee")
    private Double mealFee;
    @Column(name = "Currency", length = 10)
    private String currency;

    public Payment() {
    }

    public Payment(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getCash() {
        return cash;
    }

    public void setCash(Boolean cash) {
        this.cash = cash;
    }

    public Boolean getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Boolean creditCard) {
        this.creditCard = creditCard;
    }

    public Boolean getPaidByConference() {
        return paidByConference;
    }

    public void setPaidByConference(Boolean paidByConference) {
        this.paidByConference = paidByConference;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Boolean getPersonalCheck() {
        return personalCheck;
    }

    public void setPersonalCheck(Boolean personalCheck) {
        this.personalCheck = personalCheck;
    }

    public Boolean getRefund() {
        return refund;
    }

    public void setRefund(Boolean refund) {
        this.refund = refund;
    }

    public Long getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(Long registrationID) {
        this.registrationID = registrationID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString() {
        return "com.cclife.application.model.Payment[ id=" + id + " ]";
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * @return the registrationFee
     */
    public Double getRegistrationFee() {
        return registrationFee;
    }

    /**
     * @param registrationFee the registrationFee to set
     */
    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
    }

    /**
     * @return the mealFee
     */
    public Double getMealFee() {
        return mealFee;
    }

    /**
     * @param mealFee the mealFee to set
     */
    public void setMealFee(Double mealFee) {
        this.mealFee = mealFee;
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
