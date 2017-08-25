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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Ephesus
 */
@Entity
@Table(name = "church", catalog = "cccmdb1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ChurchID"})})
@Indexed
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Church.findAll", query = "SELECT c FROM Church c"),
    @NamedQuery(name = "Church.findByChurchID", query = "SELECT c FROM Church c WHERE c.churchID = :churchID"),
    @NamedQuery(name = "Church.findByAcronym", query = "SELECT c FROM Church c WHERE c.acronym = :acronym"),
    @NamedQuery(name = "Church.findByChurchNameEng", query = "SELECT c FROM Church c WHERE c.churchNameEng = :churchNameEng"),
    @NamedQuery(name = "Church.findByChurchNameChn", query = "SELECT c FROM Church c WHERE c.churchNameChn = :churchNameChn"),
    @NamedQuery(name = "Church.findByRegion", query = "SELECT c FROM Church c WHERE c.region = :region"),
    @NamedQuery(name = "Church.findByAddress", query = "SELECT c FROM Church c WHERE c.address = :address"),
    @NamedQuery(name = "Church.findByCity", query = "SELECT c FROM Church c WHERE c.city = :city"),
    @NamedQuery(name = "Church.findByState", query = "SELECT c FROM Church c WHERE c.state = :state"),
    @NamedQuery(name = "Church.findByZip", query = "SELECT c FROM Church c WHERE c.zip = :zip"),
    @NamedQuery(name = "Church.findByPhone", query = "SELECT c FROM Church c WHERE c.phone = :phone"),
    @NamedQuery(name = "Church.findByFax", query = "SELECT c FROM Church c WHERE c.fax = :fax"),
    @NamedQuery(name = "Church.findByWebURL", query = "SELECT c FROM Church c WHERE c.webURL = :webURL"),
    @NamedQuery(name = "Church.findByPastorPersonID1", query = "SELECT c FROM Church c WHERE c.pastorPersonID1 = :pastorPersonID1"),
    @NamedQuery(name = "Church.findByPastorPersonID2", query = "SELECT c FROM Church c WHERE c.pastorPersonID2 = :pastorPersonID2"),
    @NamedQuery(name = "Church.findByPastorPersonID3", query = "SELECT c FROM Church c WHERE c.pastorPersonID3 = :pastorPersonID3"),
    @NamedQuery(name = "Church.findByContactPersonID1", query = "SELECT c FROM Church c WHERE c.contactPersonID1 = :contactPersonID1"),
    @NamedQuery(name = "Church.findByContactPersonID2", query = "SELECT c FROM Church c WHERE c.contactPersonID2 = :contactPersonID2"),
    @NamedQuery(name = "Church.findByContactPersonID3", query = "SELECT c FROM Church c WHERE c.contactPersonID3 = :contactPersonID3"),
    @NamedQuery(name = "Church.findByMisc1", query = "SELECT c FROM Church c WHERE c.misc1 = :misc1"),
    @NamedQuery(name = "Church.findByMisc2", query = "SELECT c FROM Church c WHERE c.misc2 = :misc2"),
    @NamedQuery(name = "Church.findByMisc3", query = "SELECT c FROM Church c WHERE c.misc3 = :misc3"),
    @NamedQuery(name = "Church.findByLastModified", query = "SELECT c FROM Church c WHERE c.lastModified = :lastModified")})
public class Church implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ChurchID", nullable = false)
    @DocumentId
    private Integer churchID;
    @Column(name = "Acronym", length = 50)
    @Field
    private String acronym;
    @Column(name = "ChurchNameEng", length = 255)
    @Field
    private String churchNameEng;
    @Column(name = "ChurchNameChn", length = 50)
    @Field
    private String churchNameChn;
    @Column(name = "Region", length = 50)
    @Field
    private String region;
    @Column(name = "Address", length = 50)
    @Field
    private String address;
    @Column(name = "City", length = 30)
    @Field
    private String city;
    @Column(name = "State", length = 2)
    @Field
    private String state;
    @Column(name = "Zip")
    @Field
    private Integer zip;
    @Column(name = "Phone", length = 15)
    @Field
    private String phone;
    @Column(name = "Fax", length = 15)
    @Field
    private String fax;
    @Column(name = "WebURL", length = 50)
    @Field
    private String webURL;
    @Column(name = "PastorPersonID1")
    @Field
    private Integer pastorPersonID1;
    @Column(name = "PastorPersonID2")
    @Field
    private Integer pastorPersonID2;
    @Column(name = "PastorPersonID3")
    @Field
    private Integer pastorPersonID3;
    @Column(name = "ContactPersonID1")
    @Field
    private Integer contactPersonID1;
    @Column(name = "ContactPersonID2")
    @Field
    private Integer contactPersonID2;
    @Column(name = "ContactPersonID3")
    @Field
    private Integer contactPersonID3;
    @Column(name = "Misc1", length = 50)
    @Field
    private String misc1;
    @Column(name = "Misc2", length = 50)
    @Field
    private String misc2;
    @Column(name = "Misc3", length = 50)
    @Field
    private String misc3;
    @Column(name = "LastModified")
    @Field
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    public Church() {
    }

    public Church(Integer churchID) {
        this.churchID = churchID;
    }

    public Integer getChurchID() {
        return churchID;
    }

    public void setChurchID(Integer churchID) {
        this.churchID = churchID;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getChurchNameEng() {
        return churchNameEng;
    }

    public void setChurchNameEng(String churchNameEng) {
        this.churchNameEng = churchNameEng;
    }

    public String getChurchNameChn() {
        return churchNameChn;
    }

    public void setChurchNameChn(String churchNameChn) {
        this.churchNameChn = churchNameChn;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public Integer getPastorPersonID1() {
        return pastorPersonID1;
    }

    public void setPastorPersonID1(Integer pastorPersonID1) {
        this.pastorPersonID1 = pastorPersonID1;
    }

    public Integer getPastorPersonID2() {
        return pastorPersonID2;
    }

    public void setPastorPersonID2(Integer pastorPersonID2) {
        this.pastorPersonID2 = pastorPersonID2;
    }

    public Integer getPastorPersonID3() {
        return pastorPersonID3;
    }

    public void setPastorPersonID3(Integer pastorPersonID3) {
        this.pastorPersonID3 = pastorPersonID3;
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

    public String getMisc1() {
        return misc1;
    }

    public void setMisc1(String misc1) {
        this.misc1 = misc1;
    }

    public String getMisc2() {
        return misc2;
    }

    public void setMisc2(String misc2) {
        this.misc2 = misc2;
    }

    public String getMisc3() {
        return misc3;
    }

    public void setMisc3(String misc3) {
        this.misc3 = misc3;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (churchID != null ? churchID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Church)) {
            return false;
        }
        Church other = (Church) object;
        if ((this.churchID == null && other.churchID != null) || (this.churchID != null && !this.churchID.equals(other.churchID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "_Church[ churchID=" + churchID + " ]";
    }
    
}
