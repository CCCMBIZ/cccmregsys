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
@Indexed
@Table(name = "registrant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrant.findAll", query = "SELECT r FROM Registrant r"),
    @NamedQuery(name = "Registrant.findByRegistrationID", query = "SELECT r FROM Registrant r WHERE r.registrationID = :registrationID"),
    @NamedQuery(name = "Registrant.findByFamilyID", query = "SELECT r FROM Registrant r WHERE r.familyID = :familyID"),
    @NamedQuery(name = "Registrant.findByPersonID", query = "SELECT r FROM Registrant r WHERE r.personID = :personID"),
    @NamedQuery(name = "Registrant.findByRegisteredDate", query = "SELECT r FROM Registrant r WHERE r.registeredDate = :registeredDate"),
    @NamedQuery(name = "Registrant.findByFirstName", query = "SELECT r FROM Registrant r WHERE r.firstName = :firstName"),
    @NamedQuery(name = "Registrant.findByLastName", query = "SELECT r FROM Registrant r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "Registrant.findByChineseName", query = "SELECT r FROM Registrant r WHERE r.chineseName = :chineseName"),
    @NamedQuery(name = "Registrant.findByGender", query = "SELECT r FROM Registrant r WHERE r.gender = :gender"),
    @NamedQuery(name = "Registrant.findByAge", query = "SELECT r FROM Registrant r WHERE r.age = :age"),
    @NamedQuery(name = "Registrant.findByStatus", query = "SELECT r FROM Registrant r WHERE r.status = :status"),
    @NamedQuery(name = "Registrant.findByRelationship", query = "SELECT r FROM Registrant r WHERE r.relationship = :relationship"),
    @NamedQuery(name = "Registrant.findByPreferredLanguage", query = "SELECT r FROM Registrant r WHERE r.preferredLanguage = :preferredLanguage"),
    @NamedQuery(name = "Registrant.findByHeadphone", query = "SELECT r FROM Registrant r WHERE r.headphone = :headphone"),
    @NamedQuery(name = "Registrant.findByServingRole", query = "SELECT r FROM Registrant r WHERE r.servingRole = :servingRole"),
    @NamedQuery(name = "Registrant.findByAcceptedChrist", query = "SELECT r FROM Registrant r WHERE r.acceptedChrist = :acceptedChrist"),
    @NamedQuery(name = "Registrant.findByHealthCardNo", query = "SELECT r FROM Registrant r WHERE r.healthCardNo = :healthCardNo"),
    @NamedQuery(name = "Registrant.findByVolunteerJobs", query = "SELECT r FROM Registrant r WHERE r.volunteerJobs = :volunteerJobs"),
    @NamedQuery(name = "Registrant.findByChurchName", query = "SELECT r FROM Registrant r WHERE r.churchName = :churchName"),
    @NamedQuery(name = "Registrant.findByWorkshop1", query = "SELECT r FROM Registrant r WHERE r.workshop1 = :workshop1"),
    @NamedQuery(name = "Registrant.findByWorkshop2", query = "SELECT r FROM Registrant r WHERE r.workshop2 = :workshop2"),
    @NamedQuery(name = "Registrant.findByHomeAddress", query = "SELECT r FROM Registrant r WHERE r.homeAddress = :homeAddress"),
    @NamedQuery(name = "Registrant.findByHomeAddress2", query = "SELECT r FROM Registrant r WHERE r.homeAddress2 = :homeAddress2"),
    @NamedQuery(name = "Registrant.findByHomeCity", query = "SELECT r FROM Registrant r WHERE r.homeCity = :homeCity"),
    @NamedQuery(name = "Registrant.findByHomeState", query = "SELECT r FROM Registrant r WHERE r.homeState = :homeState"),
    @NamedQuery(name = "Registrant.findByHomeZip", query = "SELECT r FROM Registrant r WHERE r.homeZip = :homeZip"),
    @NamedQuery(name = "Registrant.findByCountry", query = "SELECT r FROM Registrant r WHERE r.country = :country"),
    @NamedQuery(name = "Registrant.findByOtherCountry", query = "SELECT r FROM Registrant r WHERE r.otherCountry = :otherCountry"),
    @NamedQuery(name = "Registrant.findByOtherState", query = "SELECT r FROM Registrant r WHERE r.otherState = :otherState"),
    @NamedQuery(name = "Registrant.findByUcCountry", query = "SELECT r FROM Registrant r WHERE r.ucCountry = :ucCountry"),
    @NamedQuery(name = "Registrant.findByUcState", query = "SELECT r FROM Registrant r WHERE r.ucState = :ucState"),
    @NamedQuery(name = "Registrant.findByHomePhone", query = "SELECT r FROM Registrant r WHERE r.homePhone = :homePhone"),
    @NamedQuery(name = "Registrant.findByMisc1", query = "SELECT r FROM Registrant r WHERE r.misc1 = :misc1"),
    @NamedQuery(name = "Registrant.findByEmail", query = "SELECT r FROM Registrant r WHERE r.email = :email"),
    @NamedQuery(name = "Registrant.findByCellPhone", query = "SELECT r FROM Registrant r WHERE r.cellPhone = :cellPhone"),
    @NamedQuery(name = "Registrant.findByBreakfast1", query = "SELECT r FROM Registrant r WHERE r.breakfast1 = :breakfast1"),
    @NamedQuery(name = "Registrant.findByBreakfast2", query = "SELECT r FROM Registrant r WHERE r.breakfast2 = :breakfast2"),
    @NamedQuery(name = "Registrant.findByBreakfast3", query = "SELECT r FROM Registrant r WHERE r.breakfast3 = :breakfast3"),
    @NamedQuery(name = "Registrant.findByBreakfast4", query = "SELECT r FROM Registrant r WHERE r.breakfast4 = :breakfast4"),
    @NamedQuery(name = "Registrant.findByLunch1", query = "SELECT r FROM Registrant r WHERE r.lunch1 = :lunch1"),
    @NamedQuery(name = "Registrant.findByLunch2", query = "SELECT r FROM Registrant r WHERE r.lunch2 = :lunch2"),
    @NamedQuery(name = "Registrant.findByLunch3", query = "SELECT r FROM Registrant r WHERE r.lunch3 = :lunch3"),
    @NamedQuery(name = "Registrant.findByLunch4", query = "SELECT r FROM Registrant r WHERE r.lunch4 = :lunch4"),
    @NamedQuery(name = "Registrant.findByDinner1", query = "SELECT r FROM Registrant r WHERE r.dinner1 = :dinner1"),
    @NamedQuery(name = "Registrant.findByDinner2", query = "SELECT r FROM Registrant r WHERE r.dinner2 = :dinner2"),
    @NamedQuery(name = "Registrant.findByDinner3", query = "SELECT r FROM Registrant r WHERE r.dinner3 = :dinner3"),
    @NamedQuery(name = "Registrant.findByDinner4", query = "SELECT r FROM Registrant r WHERE r.dinner4 = :dinner4"),
    @NamedQuery(name = "Registrant.findByMealFee", query = "SELECT r FROM Registrant r WHERE r.mealFee = :mealFee"),
    @NamedQuery(name = "Registrant.findByRegistrationFee", query = "SELECT r FROM Registrant r WHERE r.registrationFee = :registrationFee"),
    @NamedQuery(name = "Registrant.findByPaymentDate", query = "SELECT r FROM Registrant r WHERE r.paymentDate = :paymentDate"),
    @NamedQuery(name = "Registrant.findByAmount", query = "SELECT r FROM Registrant r WHERE r.amount = :amount"),
    @NamedQuery(name = "Registrant.findByRemarks", query = "SELECT r FROM Registrant r WHERE r.remarks = :remarks"),
    @NamedQuery(name = "Registrant.findByReferenceNumber", query = "SELECT r FROM Registrant r WHERE r.referenceNumber = :referenceNumber"),
    @NamedQuery(name = "Registrant.findByCurrency", query = "SELECT r FROM Registrant r WHERE r.currency = :currency"),
    @NamedQuery(name = "Registrant.findByCreditCard", query = "SELECT r FROM Registrant r WHERE r.creditCard = :creditCard"),
    @NamedQuery(name = "Registrant.findByPersonalCheck", query = "SELECT r FROM Registrant r WHERE r.personalCheck = :personalCheck"),
    @NamedQuery(name = "Registrant.findByLastModified", query = "SELECT r FROM Registrant r WHERE r.lastModified = :lastModified")})
public class Registrant extends BaseObject implements Serializable {

    private static final long serialVersionUID = 3832626162173359412L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonID")
    @DocumentId
    private int personID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FamilyID")
    @Field
    private int familyID;
    @Size(max = 50)
    @Column(name = "OtherChurchName")
    @Field
    private String otherChurchName;
    @Column(name = "Nametag")
    @Field
    private Boolean nametag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RegistrationID")
    @Field
    private String registrationID;
    @Column(name = "RegisteredDate")
    @Field
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredDate;
    @Size(max = 20)
    @Column(name = "FirstName")
    @Field
    private String firstName;
    @Size(max = 20)
    @Column(name = "LastName")
    @Field
    private String lastName;
    @Size(max = 50)
    @Column(name = "ChineseName")
    @Field
    private String chineseName;
    @Size(max = 2)
    @Column(name = "Gender")
    @Field
    private String gender;
    @Size(max = 5)
    @Column(name = "Age")
    @Field
    private String age;
    @Size(max = 5)
    @Column(name = "Status")
    @Field
    private String status;
    @Size(max = 2)
    @Column(name = "Relationship")
    @Field
    private String relationship;
    @Size(max = 50)
    @Column(name = "PreferredLanguage")
    @Field
    private String preferredLanguage;
    @Size(max = 255)
    @Column(name = "headphone")
    @Field
    private String headphone;
    @Size(max = 50)
    @Column(name = "ServingRole")
    @Field
    private String servingRole;
    @Column(name = "AcceptedChrist")
    @Field
    private Boolean acceptedChrist;
    @Size(max = 255)
    @Column(name = "healthCardNo")
    @Field
    private String healthCardNo;
    @Size(max = 255)
    @Column(name = "VolunteerJobs")
    @Field
    private String volunteerJobs;
    @Size(max = 255)
    @Column(name = "ChurchName")
    @Field
    private String churchName;
    @Size(max = 5)
    @Column(name = "Workshop1")
    @Field
    private String workshop1;
    @Size(max = 5)
    @Column(name = "Workshop2")
    @Field
    private String workshop2;
    @Size(max = 60)
    @Column(name = "HomeAddress")
    @Field
    private String homeAddress;
    @Size(max = 60)
    @Column(name = "HomeAddress2")
    @Field
    private String homeAddress2;
    @Size(max = 30)
    @Column(name = "HomeCity")
    @Field
    private String homeCity;
    @Size(max = 20)
    @Column(name = "HomeState")
    @Field
    private String homeState;
    @Size(max = 10)
    @Column(name = "HomeZip")
    @Field
    private String homeZip;
    @Size(max = 50)
    @Column(name = "Country")
    @Field
    private String country;
    @Size(max = 255)
    @Column(name = "otherCountry")
    @Field
    private String otherCountry;
    @Size(max = 255)
    @Column(name = "otherState")
    @Field
    private String otherState;
    @Size(max = 255)
    @Column(name = "ucCountry")
    @Field
    private String ucCountry;
    @Size(max = 255)
    @Column(name = "ucState")
    @Field
    private String ucState;
    @Size(max = 15)
    @Column(name = "HomePhone")
    @Field
    private String homePhone;
    @Size(max = 50)
    @Column(name = "misc1")
    @Field
    private String misc1;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    @Field
    private String email;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CellPhone")
    @Field
    private Double cellPhone;
    @Column(name = "breakfast1")
    @Field
    private Integer breakfast1;
    @Column(name = "breakfast2")
    @Field
    private Integer breakfast2;
    @Column(name = "breakfast3")
    @Field
    private Integer breakfast3;
    @Column(name = "breakfast4")
    @Field
    private Integer breakfast4;
    @Column(name = "lunch1")
    @Field
    private Integer lunch1;
    @Column(name = "lunch2")
    @Field
    private Integer lunch2;
    @Column(name = "lunch3")
    @Field
    private Integer lunch3;
    @Column(name = "lunch4")
    @Field
    private Integer lunch4;
    @Column(name = "dinner1")
    @Field
    private Integer dinner1;
    @Column(name = "dinner2")
    @Field
    private Integer dinner2;
    @Column(name = "dinner3")
    @Field
    private Integer dinner3;
    @Column(name = "dinner4")
    @Field
    private Integer dinner4;
    @Column(name = "MealFee")
    @Field
    private Double mealFee;
    @Column(name = "RegistrationFee")
    @Field
    private Double registrationFee;
    @Column(name = "paymentDate")
    @Field
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Column(name = "amount")
    @Field
    private Double amount;
    @Size(max = 255)
    @Column(name = "remarks")
    @Field
    private String remarks;
    @Size(max = 255)
    @Column(name = "referenceNumber")
    @Field
    private String referenceNumber;
    @Size(max = 10)
    @Column(name = "Currency")
    @Field
    private String currency;
    @Column(name = "creditCard")
    @Field
    private Boolean creditCard;
    @Column(name = "personalCheck")
    @Field
    private Boolean personalCheck;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastModified")
    @Field
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    public Registrant() {
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
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

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getHeadphone() {
        return headphone;
    }

    public void setHeadphone(String headphone) {
        this.headphone = headphone;
    }

    public String getServingRole() {
        return servingRole;
    }

    public void setServingRole(String servingRole) {
        this.servingRole = servingRole;
    }

    public Boolean getAcceptedChrist() {
        return acceptedChrist;
    }

    public void setAcceptedChrist(Boolean acceptedChrist) {
        this.acceptedChrist = acceptedChrist;
    }

    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }

    public String getVolunteerJobs() {
        return volunteerJobs;
    }

    public void setVolunteerJobs(String volunteerJobs) {
        this.volunteerJobs = volunteerJobs;
    }

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
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

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress2() {
        return homeAddress2;
    }

    public void setHomeAddress2(String homeAddress2) {
        this.homeAddress2 = homeAddress2;
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

    public String getOtherCountry() {
        return otherCountry;
    }

    public void setOtherCountry(String otherCountry) {
        this.otherCountry = otherCountry;
    }

    public String getOtherState() {
        return otherState;
    }

    public void setOtherState(String otherState) {
        this.otherState = otherState;
    }

    public String getUcCountry() {
        return ucCountry;
    }

    public void setUcCountry(String ucCountry) {
        this.ucCountry = ucCountry;
    }

    public String getUcState() {
        return ucState;
    }

    public void setUcState(String ucState) {
        this.ucState = ucState;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMisc1() {
        return misc1;
    }

    public void setMisc1(String misc1) {
        this.misc1 = misc1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Double cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Integer getBreakfast1() {
        return breakfast1;
    }

    public void setBreakfast1(Integer breakfast1) {
        this.breakfast1 = breakfast1;
    }

    public Integer getBreakfast2() {
        return breakfast2;
    }

    public void setBreakfast2(Integer breakfast2) {
        this.breakfast2 = breakfast2;
    }

    public Integer getBreakfast3() {
        return breakfast3;
    }

    public void setBreakfast3(Integer breakfast3) {
        this.breakfast3 = breakfast3;
    }

    public Integer getBreakfast4() {
        return breakfast4;
    }

    public void setBreakfast4(Integer breakfast4) {
        this.breakfast4 = breakfast4;
    }

    public Integer getLunch1() {
        return lunch1;
    }

    public void setLunch1(Integer lunch1) {
        this.lunch1 = lunch1;
    }

    public Integer getLunch2() {
        return lunch2;
    }

    public void setLunch2(Integer lunch2) {
        this.lunch2 = lunch2;
    }

    public Integer getLunch3() {
        return lunch3;
    }

    public void setLunch3(Integer lunch3) {
        this.lunch3 = lunch3;
    }

    public Integer getLunch4() {
        return lunch4;
    }

    public void setLunch4(Integer lunch4) {
        this.lunch4 = lunch4;
    }

    public Integer getDinner1() {
        return dinner1;
    }

    public void setDinner1(Integer dinner1) {
        this.dinner1 = dinner1;
    }

    public Integer getDinner2() {
        return dinner2;
    }

    public void setDinner2(Integer dinner2) {
        this.dinner2 = dinner2;
    }

    public Integer getDinner3() {
        return dinner3;
    }

    public void setDinner3(Integer dinner3) {
        this.dinner3 = dinner3;
    }

    public Integer getDinner4() {
        return dinner4;
    }

    public void setDinner4(Integer dinner4) {
        this.dinner4 = dinner4;
    }

    public Double getMealFee() {
        return mealFee;
    }

    public void setMealFee(Double mealFee) {
        this.mealFee = mealFee;
    }

    public Double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Boolean creditCard) {
        this.creditCard = creditCard;
    }

    public Boolean getPersonalCheck() {
        return personalCheck;
    }

    public void setPersonalCheck(Boolean personalCheck) {
        this.personalCheck = personalCheck;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Registrant)) {
            return false;
        }

        final Registrant registrant = (Registrant) o;

        return (personID == registrant.getPersonID()) ;
    }

    @Override
    public int hashCode() {
        return (registrationID != null ? registrationID.hashCode() : 0);
    }

    public int getFamilyID() {
        return familyID;
    }

    public void setFamilyID(int familyID) {
        this.familyID = familyID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getOtherChurchName() {
        return otherChurchName;
    }

    public void setOtherChurchName(String otherChurchName) {
        this.otherChurchName = otherChurchName;
    }

    public Boolean getNametag() {
        return nametag;
    }

    public void setNametag(Boolean nametag) {
        this.nametag = nametag;
    }
}
