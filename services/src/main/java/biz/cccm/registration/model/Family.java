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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ephesus
 */
@Entity
@Table(name = "family", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"FamilyID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Family.findAll", query = "SELECT f FROM Family f"),
    @NamedQuery(name = "Family.findByFamilyID", query = "SELECT f FROM Family f WHERE f.familyID = :familyID"),
    @NamedQuery(name = "Family.findByHeadOfFamilyPersonID", query = "SELECT f FROM Family f WHERE f.headOfFamilyPersonID = :headOfFamilyPersonID"),
    @NamedQuery(name = "Family.findByChurchID", query = "SELECT f FROM Family f WHERE f.churchID = :churchID"),
    @NamedQuery(name = "Family.findByFamilyName", query = "SELECT f FROM Family f WHERE f.familyName = :familyName"),
    @NamedQuery(name = "Family.findByHomeAddress", query = "SELECT f FROM Family f WHERE f.homeAddress = :homeAddress"),
    @NamedQuery(name = "Family.findByHomeCity", query = "SELECT f FROM Family f WHERE f.homeCity = :homeCity"),
    @NamedQuery(name = "Family.findByHomeState", query = "SELECT f FROM Family f WHERE f.homeState = :homeState"),
    @NamedQuery(name = "Family.findByHomeZip", query = "SELECT f FROM Family f WHERE f.homeZip = :homeZip"),
    @NamedQuery(name = "Family.findByCountry", query = "SELECT f FROM Family f WHERE f.country = :country"),
    @NamedQuery(name = "Family.findByHomePhone", query = "SELECT f FROM Family f WHERE f.homePhone = :homePhone"),
    @NamedQuery(name = "Family.findByHomeFax", query = "SELECT f FROM Family f WHERE f.homeFax = :homeFax"),
    @NamedQuery(name = "Family.findByNewsletter", query = "SELECT f FROM Family f WHERE f.newsletter = :newsletter"),
    @NamedQuery(name = "Family.findByLastModified", query = "SELECT f FROM Family f WHERE f.lastModified = :lastModified"),
    @NamedQuery(name = "Family.findByMisc1", query = "SELECT f FROM Family f WHERE f.misc1 = :misc1"),
    @NamedQuery(name = "Family.findByMisc2", query = "SELECT f FROM Family f WHERE f.misc2 = :misc2"),
    @NamedQuery(name = "Family.findByMisc3", query = "SELECT f FROM Family f WHERE f.misc3 = :misc3")})
public class Family extends BaseObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FamilyID", nullable = false)
    private Integer familyID;
    @Column(name = "HeadOfFamilyPersonID", length = 50)
    private String headOfFamilyPersonID;
    @Column(name = "ChurchID", length = 50)
    private String churchID;
    @Column(name = "FamilyName", length = 30)
    private String familyName;
    @Column(name = "HomeAddress", length = 60)
    private String homeAddress;
    @Column(name = "HomeAddress2", length = 60)
    private String homeAddress2;
    @Column(name = "HomeCity", length = 30)
    private String homeCity;
    @Column(name = "HomeState", length = 10)
    private String homeState;
    @Column(name = "HomeZip", length = 10)
    private String homeZip;
    @Column(name = "Country", length = 50)
    private String country;
    @Column(name = "HomePhone", length = 15)
    private String homePhone;
    @Column(name = "HomeFax", length = 15)
    private String homeFax;
    @Column(name = "Newsletter")
    private Boolean newsletter;
    @Basic(optional = false)
    @Column(name = "LastModified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "Misc1", length = 50)
    private String misc1;
    @Column(name = "Misc2", length = 50)
    private String misc2;
    @Column(name = "Misc3", length = 50)
    private String misc3;
    
    /**
     * The following code is added for issue21: input of other country and state.
     */
    private String otherCountry;
    private String otherState;
    private String ucCountry;
    private String ucState;
    /**
     * End of code for issue21.
     */
    
    /**
     * The following code is added for issue52: a field for need of hotel.
     */
    private Boolean hotel;
    
    public Family() {
    }

    public Family(Integer familyID) {
        this.familyID = familyID;
    }

    public Family(Integer familyID, Date lastModified) {
        this.familyID = familyID;
        this.lastModified = lastModified;
    }

    public Integer getFamilyID() {
        return familyID;
    }

    public void setFamilyID(Integer familyID) {
        this.familyID = familyID;
    }

    public String getHeadOfFamilyPersonID() {
        return headOfFamilyPersonID;
    }

    public void setHeadOfFamilyPersonID(String headOfFamilyPersonID) {
        this.headOfFamilyPersonID = headOfFamilyPersonID;
    }

    public String getChurchID() {
        return churchID;
    }

    public void setChurchID(String churchID) {
        this.churchID = churchID;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getHomeFax() {
        return homeFax;
    }

    public void setHomeFax(String homeFax) {
        this.homeFax = homeFax;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familyID != null ? familyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Family)) {
            return false;
        }
        Family other = (Family) object;
        if ((this.familyID == null && other.familyID != null) || (this.familyID != null && !this.familyID.equals(other.familyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "_Family[ familyID=" + familyID + " ]";
    }

    /**
     * @return the homeAddress2
     */
    public String getHomeAddress2() {
        return homeAddress2;
    }

    /**
     * @param homeAddress2 the homeAddress2 to set
     */
    public void setHomeAddress2(String homeAddress2) {
        this.homeAddress2 = homeAddress2;
    }
    
    /**
     * the following code is added for issue21: input of other country and state.
     */
    public String getOtherCountry(){
        return otherCountry;
    }
    
    public void setOtherCountry( String otherCountry ){
        this.otherCountry = otherCountry;
    }
    
    public String getOtherState(){
        return otherState;
    }
    
    public void setOtherState( String otherState ){
        this.otherState = otherState;
    }
     
    public String getUcCountry(){
        return ucCountry;
    }
    
    public void setUcCountry( String ucCountry ){
        this.ucCountry= ucCountry;
    }
     
    public String getUcState(){
        return ucState;
    }
    public void setUcState( String ucState ){
        this.ucState = ucState;
    }

    /**
     * @return the hotel
     */
    public Boolean getHotel() {
        return hotel;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(Boolean hotel) {
        this.hotel = hotel;
    }
}
