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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ephesus
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonID", query = "SELECT p FROM Person p WHERE p.personID = :personID"),
    @NamedQuery(name = "Person.findByAcceptedChrist", query = "SELECT p FROM Person p WHERE p.acceptedChrist = :acceptedChrist"),
    @NamedQuery(name = "Person.findByAcceptedChristDate", query = "SELECT p FROM Person p WHERE p.acceptedChristDate = :acceptedChristDate"),
    @NamedQuery(name = "Person.findByAcceptedChristLocation", query = "SELECT p FROM Person p WHERE p.acceptedChristLocation = :acceptedChristLocation"),
    @NamedQuery(name = "Person.findByAge", query = "SELECT p FROM Person p WHERE p.age = :age"),
    @NamedQuery(name = "Person.findByBaptized", query = "SELECT p FROM Person p WHERE p.baptized = :baptized"),
    @NamedQuery(name = "Person.findByBaptizedDate", query = "SELECT p FROM Person p WHERE p.baptizedDate = :baptizedDate"),
    @NamedQuery(name = "Person.findByCellPhone", query = "SELECT p FROM Person p WHERE p.cellPhone = :cellPhone"),
    @NamedQuery(name = "Person.findByChineseName", query = "SELECT p FROM Person p WHERE p.chineseName = :chineseName"),
    @NamedQuery(name = "Person.findByChurchAdmin", query = "SELECT p FROM Person p WHERE p.churchAdmin = :churchAdmin"),
    @NamedQuery(name = "Person.findByChurchID", query = "SELECT p FROM Person p WHERE p.churchID = :churchID"),
    @NamedQuery(name = "Person.findByCommitServe", query = "SELECT p FROM Person p WHERE p.commitServe = :commitServe"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByFamilyAdmin", query = "SELECT p FROM Person p WHERE p.familyAdmin = :familyAdmin"),
    @NamedQuery(name = "Person.findByFamilyID", query = "SELECT p FROM Person p WHERE p.familyID = :familyID"),
    @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender"),
    @NamedQuery(name = "Person.findByLastModified", query = "SELECT p FROM Person p WHERE p.lastModified = :lastModified"),
    @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Person.findByLoginID", query = "SELECT p FROM Person p WHERE p.loginID = :loginID"),
    @NamedQuery(name = "Person.findByMisc1", query = "SELECT p FROM Person p WHERE p.misc1 = :misc1"),
    @NamedQuery(name = "Person.findByMisc2", query = "SELECT p FROM Person p WHERE p.misc2 = :misc2"),
    @NamedQuery(name = "Person.findByMisc3", query = "SELECT p FROM Person p WHERE p.misc3 = :misc3"),
    @NamedQuery(name = "Person.findByPassword", query = "SELECT p FROM Person p WHERE p.password = :password"),
    @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.phone = :phone"),
    @NamedQuery(name = "Person.findByPrc", query = "SELECT p FROM Person p WHERE p.prc = :prc"),
    @NamedQuery(name = "Person.findByPreferredLanguage", query = "SELECT p FROM Person p WHERE p.preferredLanguage = :language"),
    @NamedQuery(name = "Person.findByRelationship", query = "SELECT p FROM Person p WHERE p.relationship = :relationship"),
    @NamedQuery(name = "Person.findByRemarks", query = "SELECT p FROM Person p WHERE p.remarks = :remarks"),
    @NamedQuery(name = "Person.findBySearchable", query = "SELECT p FROM Person p WHERE p.searchable = :searchable"),
    @NamedQuery(name = "Person.findBySeeker", query = "SELECT p FROM Person p WHERE p.seeker = :seeker"),
    @NamedQuery(name = "Person.findByServingRole", query = "SELECT p FROM Person p WHERE p.servingRole = :servingRole"),
    @NamedQuery(name = "Person.findByStatus", query = "SELECT p FROM Person p WHERE p.status = :status"),
    @NamedQuery(name = "Person.findByTitle", query = "SELECT p FROM Person p WHERE p.title = :title"),
    @NamedQuery(name = "Person.findByVolunteerCode", query = "SELECT p FROM Person p WHERE p.volunteerCode = :volunteerCode"),
    @NamedQuery(name = "Person.findByWillingToAttendCCCMTraining", query = "SELECT p FROM Person p WHERE p.willingToAttendCCCMTraining = :willingToAttendCCCMTraining"),
    @NamedQuery(name = "Person.findByWillingToBeVolunteer", query = "SELECT p FROM Person p WHERE p.willingToBeVolunteer = :willingToBeVolunteer"),
    @NamedQuery(name = "Person.findByWorkPhone", query = "SELECT p FROM Person p WHERE p.workPhone = :workPhone")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PersonID", nullable = false)
    private Integer personID;
    @Column(name = "AcceptedChrist")
    private Boolean acceptedChrist;
    @Column(name = "AcceptedChristDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptedChristDate;
    @Column(name = "AcceptedChristLocation")
    private Integer acceptedChristLocation;
    @Size(max = 5)
    @Column(name = "Age")
    private String age;
    @Column(name = "Baptized")
    private Boolean baptized;
    @Column(name = "BaptizedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date baptizedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CellPhone")
    private Double cellPhone;
    @Size(max = 50)
    @Column(name = "ChineseName")
    private String chineseName;
    @Column(name = "ChurchAdmin")
    private Boolean churchAdmin;
    @Column(name = "ChurchID")
    private Integer churchID;
    @Size(max = 50)
    @Column(name = "CommitServe")
    private String commitServe;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @Column(name = "FamilyAdmin")
    private Boolean familyAdmin;
    @Column(name = "FamilyID")
    private Integer familyID;
    @Size(max = 20)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 2)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Size(max = 20)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 50)
    @Column(name = "LoginID")
    private String loginID;
    @Size(max = 50)
    @Column(name = "Misc1")
    private String misc1;
    @Size(max = 50)
    @Column(name = "Misc2")
    private String misc2;
    @Size(max = 50)
    @Column(name = "Misc3")
    private String misc3;
    @Size(max = 50)
    @Column(name = "Password")
    private String password;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "Phone")
    private String phone;
    @Size(max = 50)
    @Column(name = "PRC")
    private String prc;
    @Size(max = 50)
    @Column(name = "PreferredLanguage")
    private String preferredLanguage;
    @Size(max = 2)
    @Column(name = "Relationship")
    private String relationship;
    @Size(max = 255)
    @Column(name = "Remarks")
    private String remarks;
    @Column(name = "Searchable")
    private Boolean searchable;
    @Column(name = "Seeker")
    private Boolean seeker;
    @Size(max = 50)
    @Column(name = "ServingRole")
    private String servingRole;
    @Size(max = 5)
    @Column(name = "Status")
    private String status;
    @Size(max = 50)
    @Column(name = "Title")
    private String title;
    @Column(name = "VolunteerCode")
    private Integer volunteerCode;
    @Column(name = "WillingToAttendCCCMTraining")
    private Boolean willingToAttendCCCMTraining;
    @Column(name = "WillingToBeVolunteer")
    private Boolean willingToBeVolunteer;
    @Column(name = "WorkPhone")
    private Double workPhone;
    
    /**
     * The following code is added for issue5.
     */
    @Column(name = "headphone")
    private String headphone;
    /**
     * End of code for issue5.
     */
    
    /**
    * The following code is added for issue40.
    */
    private String healthCardNo;
    private String allergies;
    /**
     * End of code for issue40.
     */
    
    public Person() {
    }

    public Person(Integer personID) {
        this.personID = personID;
    }

    public Person(Integer personID, Date lastModified) {
        this.personID = personID;
        this.lastModified = lastModified;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Boolean getAcceptedChrist() {
        return acceptedChrist;
    }

    public void setAcceptedChrist(Boolean acceptedChrist) {
        this.acceptedChrist = acceptedChrist;
    }

    public Date getAcceptedChristDate() {
        return acceptedChristDate;
    }

    public void setAcceptedChristDate(Date acceptedChristDate) {
        this.acceptedChristDate = acceptedChristDate;
    }

    public Integer getAcceptedChristLocation() {
        return acceptedChristLocation;
    }

    public void setAcceptedChristLocation(Integer acceptedChristLocation) {
        this.acceptedChristLocation = acceptedChristLocation;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getBaptized() {
        return baptized;
    }

    public void setBaptized(Boolean baptized) {
        this.baptized = baptized;
    }

    public Date getBaptizedDate() {
        return baptizedDate;
    }

    public void setBaptizedDate(Date baptizedDate) {
        this.baptizedDate = baptizedDate;
    }

    public Double getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Double cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public Boolean getChurchAdmin() {
        return churchAdmin;
    }

    public void setChurchAdmin(Boolean churchAdmin) {
        this.churchAdmin = churchAdmin;
    }

    public Integer getChurchID() {
        return churchID;
    }

    public void setChurchID(Integer churchID) {
        this.churchID = churchID;
    }

    public String getCommitServe() {
        return commitServe;
    }

    public void setCommitServe(String commitServe) {
        this.commitServe = commitServe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFamilyAdmin() {
        return familyAdmin;
    }

    public void setFamilyAdmin(Boolean familyAdmin) {
        this.familyAdmin = familyAdmin;
    }

    public Integer getFamilyID() {
        return familyID;
    }

    public void setFamilyID(Integer familyID) {
        this.familyID = familyID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrc() {
        return prc;
    }

    public void setPrc(String prc) {
        this.prc = prc;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public Boolean getSeeker() {
        return seeker;
    }

    public void setSeeker(Boolean seeker) {
        this.seeker = seeker;
    }

    public String getServingRole() {
        return servingRole;
    }

    public void setServingRole(String servingRole) {
        this.servingRole = servingRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVolunteerCode() {
        return volunteerCode;
    }

    public void setVolunteerCode(Integer volunteerCode) {
        this.volunteerCode = volunteerCode;
    }

    public Boolean getWillingToAttendCCCMTraining() {
        return willingToAttendCCCMTraining;
    }

    public void setWillingToAttendCCCMTraining(Boolean willingToAttendCCCMTraining) {
        this.willingToAttendCCCMTraining = willingToAttendCCCMTraining;
    }

    public Boolean getWillingToBeVolunteer() {
        return willingToBeVolunteer;
    }

    public void setWillingToBeVolunteer(Boolean willingToBeVolunteer) {
        this.willingToBeVolunteer = willingToBeVolunteer;
    }

    public Double getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(Double workPhone) {
        this.workPhone = workPhone;
    }
    
    /**
     * The following code is added for issue5.
     * @return 
     */
    public String getHeadphone(){
        return this.headphone;
    }
    public void setHeadphone( String headphone){
        this.headphone = headphone;
    }
    /**
     * End of code for issue5.
     */
        
    /**
     * The following code is added for issue40.
     * @return 
     */
    public String getHealthCardNo(){
        return this.healthCardNo;
    }
    public void setHealthCardNo( String healthCardNo ){
        this.healthCardNo = healthCardNo;
    }
    
    public String getAllergies(){
        return this.allergies;
    }
    public void setAllergies( String allergies ){
        this.allergies = allergies;
    }
    /**
     * End of code for issue40.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getPersonID() != null ? getPersonID().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.getPersonID() == null && other.getPersonID() != null) || (this.getPersonID() != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biz.cccm.registration.model.Person[ personID=" + getPersonID() + " ]";
    }
    
}
