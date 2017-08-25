/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.model;

import java.io.Serializable;
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
@Table(name = "event", catalog = "cccmdb1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventID", query = "SELECT e FROM Event e WHERE e.eventID = :eventID"),
    @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e WHERE e.name = :name"),
    @NamedQuery(name = "Event.findByCategory", query = "SELECT e FROM Event e WHERE e.category = :category"),
    @NamedQuery(name = "Event.findByDescription", query = "SELECT e FROM Event e WHERE e.description = :description"),
    @NamedQuery(name = "Event.findByStartDate", query = "SELECT e FROM Event e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "Event.findByEndDate", query = "SELECT e FROM Event e WHERE e.endDate = :endDate"),
    @NamedQuery(name = "Event.findByAddress", query = "SELECT e FROM Event e WHERE e.address = :address"),
    @NamedQuery(name = "Event.findByCity", query = "SELECT e FROM Event e WHERE e.city = :city"),
    @NamedQuery(name = "Event.findByState", query = "SELECT e FROM Event e WHERE e.state = :state"),
    @NamedQuery(name = "Event.findByZip", query = "SELECT e FROM Event e WHERE e.zip = :zip"),
    @NamedQuery(name = "Event.findByPhone", query = "SELECT e FROM Event e WHERE e.phone = :phone"),
    @NamedQuery(name = "Event.findByDirection", query = "SELECT e FROM Event e WHERE e.direction = :direction"),
    @NamedQuery(name = "Event.findByContactPersonID1", query = "SELECT e FROM Event e WHERE e.contactPersonID1 = :contactPersonID1"),
    @NamedQuery(name = "Event.findByContactPersonID2", query = "SELECT e FROM Event e WHERE e.contactPersonID2 = :contactPersonID2"),
    @NamedQuery(name = "Event.findByContactPersonID3", query = "SELECT e FROM Event e WHERE e.contactPersonID3 = :contactPersonID3")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EventID", nullable = false)
    private Integer eventID;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name = "ContactEmail", length = 50)
    private String contactEmail;
    @Basic(optional = false)
    @Column(name = "Category", nullable = false)
    private int category;
    @Column(name = "Description", length = 50)
    private String description;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "Address", length = 50)
    private String address;
    @Column(name = "City", length = 50)
    private String city;
    @Column(name = "State", length = 50)
    private String state;
    @Column(name = "Zip")
    private Integer zip;
    @Column(name = "Phone")
    private Integer phone;
    @Column(name = "Direction", length = 50)
    private String direction;
    @Column(name = "ContactPersonID1")
    private Integer contactPersonID1;
    @Column(name = "ContactPersonID2")
    private Integer contactPersonID2;
    @Column(name = "ContactPersonID3")
    private Integer contactPersonID3;

    public Event() {
    }

    public Event(Integer eventID) {
        this.eventID = eventID;
    }

    public Event(Integer eventID, int category) {
        this.eventID = eventID;
        this.category = category;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getContactPersonID1() {
        return contactPersonID1;
    }

    public void setContactPersonID1(Integer contactPersonID1) {
        this.contactPersonID1 = contactPersonID1;
    }

    public Integer getContactPersonID2() {
        return contactPersonID2;
    }

    public void setContactPersonID2(Integer contactPersonID2) {
        this.contactPersonID2 = contactPersonID2;
    }

    public Integer getContactPersonID3() {
        return contactPersonID3;
    }

    public void setContactPersonID3(Integer contactPersonID3) {
        this.contactPersonID3 = contactPersonID3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventID != null ? eventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventID == null && other.eventID != null) || (this.eventID != null && !this.eventID.equals(other.eventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "_Event[ eventID=" + eventID + " ]";
    }

    /**
     * @return the contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * @param contactEmail the contactEmail to set
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

}
