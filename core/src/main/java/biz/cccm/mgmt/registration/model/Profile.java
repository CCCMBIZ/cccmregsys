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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Ephesus
 */
@Entity
@Table(name = "profile")
@Indexed
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByPersonID", query = "SELECT p FROM Profile p WHERE p.personID = :personID"),
    @NamedQuery(name = "Profile.findByLeader", query = "SELECT p FROM Profile p WHERE p.leader = :leader"),
    @NamedQuery(name = "Profile.findByDecision", query = "SELECT p FROM Profile p WHERE p.decision = :decision"),
    @NamedQuery(name = "Profile.findBySeeker", query = "SELECT p FROM Profile p WHERE p.seeker = :seeker"),
    @NamedQuery(name = "Profile.findByChurchID", query = "SELECT p FROM Profile p WHERE p.churchID = :churchID"),
    @NamedQuery(name = "Profile.findByRoomID", query = "SELECT p FROM Profile p WHERE p.roomID = :roomID"),
    @NamedQuery(name = "Profile.findByGroupID", query = "SELECT p FROM Profile p WHERE p.groupID = :groupID"),
    @NamedQuery(name = "Profile.findByComments", query = "SELECT p FROM Profile p WHERE p.comments = :comments"),
    @NamedQuery(name = "Profile.findByCheckIn", query = "SELECT p FROM Profile p WHERE p.checkIn = :checkIn"),
    @NamedQuery(name = "Profile.findByCheckInDate", query = "SELECT p FROM Profile p WHERE p.checkInDate = :checkInDate"),
    @NamedQuery(name = "Profile.findByCheckOut", query = "SELECT p FROM Profile p WHERE p.checkOut = :checkOut"),
    @NamedQuery(name = "Profile.findByCheckOutDate", query = "SELECT p FROM Profile p WHERE p.checkOutDate = :checkOutDate"),
    @NamedQuery(name = "Profile.findByRegisteredDate", query = "SELECT p FROM Profile p WHERE p.registeredDate = :registeredDate"),
    @NamedQuery(name = "Profile.findByNametag", query = "SELECT p FROM Profile p WHERE p.nametag = :nametag"),
    @NamedQuery(name = "Profile.findByArchive", query = "SELECT p FROM Profile p WHERE p.archive = :archive"),
    @NamedQuery(name = "Profile.findByPreferredLanguage", query = "SELECT p FROM Profile p WHERE p.preferredLanguage = :preferredLanguage"),
    @NamedQuery(name = "Profile.findByFaithYear", query = "SELECT p FROM Profile p WHERE p.faithYear = :faithYear"),
    @NamedQuery(name = "Profile.findByWorkshop", query = "SELECT p FROM Profile p WHERE p.workshop = :workshop"),
    @NamedQuery(name = "Profile.findByWorkshop1", query = "SELECT p FROM Profile p WHERE p.workshop1 = :workshop1"),
    @NamedQuery(name = "Profile.findByWorkshop2", query = "SELECT p FROM Profile p WHERE p.workshop2 = :workshop2"),
    @NamedQuery(name = "Profile.findByLastModified", query = "SELECT p FROM Profile p WHERE p.lastModified = :lastModified"),
    @NamedQuery(name = "Profile.findByFamilyID", query = "SELECT p FROM Profile p WHERE p.familyID = :familyID"),
    @NamedQuery(name = "Profile.findByRegistrationID", query = "SELECT p FROM Profile p WHERE p.registrationID = :registrationID"),
    @NamedQuery(name = "Profile.findByNeedTranspotation", query = "SELECT p FROM Profile p WHERE p.needTranspotation = :needTranspotation"),
    @NamedQuery(name = "Profile.findByNeedHotel", query = "SELECT p FROM Profile p WHERE p.needHotel = :needHotel")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonID")
    @DocumentId
    private Integer personID;
    @Column(name = "Leader")
    @Field
    private Boolean leader;
    @Column(name = "Decision")
    @Field
    private Boolean decision;
    @Column(name = "Seeker")
    @Field
    private Boolean seeker;
    @Column(name = "ChurchID")
    @Field
    private Integer churchID;
    @Size(max = 10)
    @Column(name = "RoomID")
    @Field
    private String roomID;
    @Column(name = "GroupID")
    @Field
    private Integer groupID;
    @Size(max = 255)
    @Column(name = "Comments")
    @Field
    private String comments;
    @Column(name = "CheckIn")
    @Field
    private Boolean checkIn;
    @Column(name = "CheckInDate")
    @Field
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;
    @Column(name = "CheckOut")
    @Field
    private Boolean checkOut;
    @Column(name = "CheckOutDate")
    @Field
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;
    @Column(name = "RegisteredDate")
    @Field
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredDate;
    @Column(name = "Nametag")
    @Field
    private Boolean nametag;
    @Column(name = "Archive")
    @Field
    private Boolean archive;
    @Size(max = 50)
    @Column(name = "PreferredLanguage")
    @Field
    private String preferredLanguage;
    @Column(name = "FaithYear")
    @Field
    private Integer faithYear;
    @Column(name = "Workshop")
    @Field
    private Boolean workshop;
    @Size(max = 5)
    @Column(name = "Workshop1")
    @Field
    private String workshop1;
    @Size(max = 5)
    @Column(name = "Workshop2")
    @Field
    private String workshop2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastModified")
    @Field
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FamilyID")
    @Field
    private int familyID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RegistrationID")
    @Field
    private String registrationID;
    @Column(name = "NeedTranspotation")
    @Field
    private Boolean needTranspotation;
    @Column(name = "NeedHotel")
    @Field
    private Boolean needHotel;
    @Size(max = 255)
    @Column(name = "volunteerJobs")
    @Field
    private String volunteerJobs;
    @Column(name = "ChurchName")
    @Field
    private String churchName;

    public Profile() {
    }

    public Profile(Integer personID) {
        this.personID = personID;
    }

    public Profile(Integer personID, Date lastModified, int familyID, String registrationID) {
        this.personID = personID;
        this.lastModified = lastModified;
        this.familyID = familyID;
        this.registrationID = registrationID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Boolean getLeader() {
        return leader;
    }

    public void setLeader(Boolean leader) {
        this.leader = leader;
    }

    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }

    public Boolean getSeeker() {
        return seeker;
    }

    public void setSeeker(Boolean seeker) {
        this.seeker = seeker;
    }

    public Integer getChurchID() {
        return churchID;
    }

    public void setChurchID(Integer churchID) {
        this.churchID = churchID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Boolean checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Boolean checkOut) {
        this.checkOut = checkOut;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Boolean getNametag() {
        return nametag;
    }

    public void setNametag(Boolean nametag) {
        this.nametag = nametag;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public Integer getFaithYear() {
        return faithYear;
    }

    public void setFaithYear(Integer faithYear) {
        this.faithYear = faithYear;
    }

    public Boolean getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Boolean workshop) {
        this.workshop = workshop;
    }

    public String getWorkshop1() {
        return workshop1;
    }

    public void setWorkshop1(String workshop1) {
        this.workshop1 = workshop1;
    }

    public String getWorkshop2() {
        return workshop2;
    }

    public void setWorkshop2(String workshop2) {
        this.workshop2 = workshop2;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getFamilyID() {
        return familyID;
    }

    public void setFamilyID(int familyID) {
        this.familyID = familyID;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public Boolean getNeedTranspotation() {
        return needTranspotation;
    }

    public void setNeedTranspotation(Boolean needTranspotation) {
        this.needTranspotation = needTranspotation;
    }

    public Boolean getNeedHotel() {
        return needHotel;
    }

    public void setNeedHotel(Boolean needHotel) {
        this.needHotel = needHotel;
    }

    public String getVolunteerJobs() {
        return volunteerJobs;
    }

    public void setVolunteerJobs(String volunteerJobs) {
        this.volunteerJobs = volunteerJobs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;

        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        if ((this.leader == null && other.leader != null) || (this.leader != null && !this.leader.equals(other.leader))) {
            return false;
        }
        if ((this.decision == null && other.decision != null) || (this.decision != null && !this.decision.equals(other.decision))) {
            return false;
        }
        if ((this.seeker == null && other.seeker != null) || (this.seeker != null && !this.seeker.equals(other.seeker))) {
            return false;
        }
        if ((this.churchID == null && other.churchID != null) || (this.churchID != null && !this.churchID.equals(other.churchID))) {
            return false;
        }
        if ((this.roomID == null && other.roomID != null) || (this.roomID != null && !this.roomID.equals(other.roomID))) {
            return false;
        }
        if ((this.groupID == null && other.groupID != null) || (this.groupID != null && !this.groupID.equals(other.groupID))) {
            return false;
        }
        if ((this.comments == null && other.comments != null) || (this.comments != null && !this.comments.equals(other.comments))) {
            return false;
        }
        if ((this.checkIn == null && other.checkIn != null) || (this.checkIn != null && !this.checkIn.equals(other.checkIn))) {
            return false;
        }
        if ((this.checkInDate == null && other.checkInDate != null) || (this.checkInDate != null && !this.checkInDate.equals(other.checkInDate))) {
            return false;
        }
        if ((this.checkOut == null && other.checkOut != null) || (this.checkOut != null && !this.checkOut.equals(other.checkOut))) {
            return false;
        }
        if ((this.checkOutDate == null && other.checkOutDate != null) || (this.checkOutDate != null && !this.checkOutDate.equals(other.checkOutDate))) {
            return false;
        }
        if ((this.registeredDate == null && other.registeredDate != null) || (this.registeredDate != null && !this.registeredDate.equals(other.registeredDate))) {
            return false;
        }
        if ((this.nametag == null && other.nametag != null) || (this.nametag != null && !this.nametag.equals(other.nametag))) {
            return false;
        }
        if ((this.archive == null && other.archive != null) || (this.archive != null && !this.archive.equals(other.archive))) {
            return false;
        }
        if ((this.preferredLanguage == null && other.preferredLanguage != null) || (this.preferredLanguage != null && !this.preferredLanguage.equals(other.preferredLanguage))) {
            return false;
        }
        if ((this.faithYear == null && other.faithYear != null) || (this.faithYear != null && !this.faithYear.equals(other.faithYear))) {
            return false;
        }
        if ((this.workshop == null && other.workshop != null) || (this.workshop != null && !this.workshop.equals(other.workshop))) {
            return false;
        }
        if ((this.workshop1 == null && other.workshop1 != null) || (this.workshop1 != null && !this.workshop1.equals(other.workshop1))) {
            return false;
        }
        if ((this.workshop2 == null && other.workshop2 != null) || (this.workshop2 != null && !this.workshop2.equals(other.workshop2))) {
            return false;
        }
        if (!this.lastModified.equals(other.lastModified)) {
            return false;
        }
        if (this.familyID != other.familyID) {
            return false;
        }
        if (!this.registrationID.equals(other.registrationID)) {
            return false;
        }
        if ((this.needTranspotation == null && other.needTranspotation != null) || (this.needTranspotation != null && !this.needTranspotation.equals(other.needTranspotation))) {
            return false;
        }
        if ((this.needHotel == null && other.needHotel != null) || (this.needHotel != null && !this.needHotel.equals(other.needHotel))) {
            return false;
        }
        if ((this.volunteerJobs == null && other.volunteerJobs != null) || (this.volunteerJobs != null && !this.volunteerJobs.equals(other.volunteerJobs))) {
            return false;
        }
        if ((this.churchName == null && other.churchName != null) || (this.churchName != null && !this.churchName.equals(other.churchName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cclife.registration.model.Profile[ personID=" + personID + " ]";
    }

    /**
     * @return the chucrhName
     */
    public String getChurchName() {
        return churchName;
    }

    /**
     * @param churchName the churchName to set
     */
    public void setChucrhName(String churchName) {
        this.churchName = churchName;
    }

}
