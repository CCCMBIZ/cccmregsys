/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "receipt_print_history", catalog = "cccmdb1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceiptPrintHistory.findAll", query = "SELECT r FROM ReceiptPrintHistory r"),
    @NamedQuery(name = "ReceiptPrintHistory.findByReceiptID", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.receiptID = :receiptID"),
    @NamedQuery(name = "ReceiptPrintHistory.findByContributionSource", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.contributionSource = :contributionSource"),
    @NamedQuery(name = "ReceiptPrintHistory.findByContributorID", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.contributorID = :contributorID"),
    @NamedQuery(name = "ReceiptPrintHistory.findByEventID", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.eventID = :eventID"),
    @NamedQuery(name = "ReceiptPrintHistory.findByReceiptType", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.receiptType = :receiptType"),
    @NamedQuery(name = "ReceiptPrintHistory.findByFirstName", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.firstName = :firstName"),
    @NamedQuery(name = "ReceiptPrintHistory.findByLastName", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "ReceiptPrintHistory.findByAddress", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.address = :address"),
    @NamedQuery(name = "ReceiptPrintHistory.findByCity", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.city = :city"),
    @NamedQuery(name = "ReceiptPrintHistory.findByState", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.state = :state"),
    @NamedQuery(name = "ReceiptPrintHistory.findByZip", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.zip = :zip"),
    @NamedQuery(name = "ReceiptPrintHistory.findByDate", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.date = :date"),
    @NamedQuery(name = "ReceiptPrintHistory.findByReceiptAmount", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.receiptAmount = :receiptAmount"),
    @NamedQuery(name = "ReceiptPrintHistory.findByCheckNumber", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.checkNumber = :checkNumber"),
    @NamedQuery(name = "ReceiptPrintHistory.findByCreditCardNumber", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.creditCardNumber = :creditCardNumber"),
    @NamedQuery(name = "ReceiptPrintHistory.findByReceiptPrintDate", query = "SELECT r FROM ReceiptPrintHistory r WHERE r.receiptPrintDate = :receiptPrintDate")})
public class ReceiptPrintHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ReceiptID", nullable = false, length = 50)
    private String receiptID;
    @Column(name = "ContributionSource", length = 50)
    private String contributionSource;
    @Column(name = "ContributorID", length = 50)
    private String contributorID;
    @Column(name = "EventID", length = 50)
    private String eventID;
    @Column(name = "ReceiptType", length = 50)
    private String receiptType;
    @Column(name = "FirstName", length = 50)
    private String firstName;
    @Column(name = "LastName", length = 50)
    private String lastName;
    @Column(name = "Address", length = 50)
    private String address;
    @Column(name = "City", length = 50)
    private String city;
    @Column(name = "State", length = 50)
    private String state;
    @Column(name = "Zip", length = 50)
    private String zip;
    @Column(name = "Date", length = 50)
    private String date;
    @Column(name = "ReceiptAmount", length = 50)
    private String receiptAmount;
    @Column(name = "CheckNumber", length = 50)
    private String checkNumber;
    @Column(name = "CreditCardNumber", length = 50)
    private String creditCardNumber;
    @Column(name = "ReceiptPrintDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiptPrintDate;

    public ReceiptPrintHistory() {
    }

    public ReceiptPrintHistory(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getContributionSource() {
        return contributionSource;
    }

    public void setContributionSource(String contributionSource) {
        this.contributionSource = contributionSource;
    }

    public String getContributorID() {
        return contributorID;
    }

    public void setContributorID(String contributorID) {
        this.contributorID = contributorID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getReceiptPrintDate() {
        return receiptPrintDate;
    }

    public void setReceiptPrintDate(Date receiptPrintDate) {
        this.receiptPrintDate = receiptPrintDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiptID != null ? receiptID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceiptPrintHistory)) {
            return false;
        }
        ReceiptPrintHistory other = (ReceiptPrintHistory) object;
        if ((this.receiptID == null && other.receiptID != null) || (this.receiptID != null && !this.receiptID.equals(other.receiptID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "_ReceiptPrintHistory[ receiptID=" + receiptID + " ]";
    }
    
}
