/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ephesus
 */
@Entity
@Table(name = "consent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consent.findAll", query = "SELECT c FROM Consent c"),
    @NamedQuery(name = "Consent.findByConsentID", query = "SELECT c FROM Consent c WHERE c.consentID = :consentID"),
    @NamedQuery(name = "Consent.findByInsurancePolicyNumber", query = "SELECT c FROM Consent c WHERE c.insurancePolicyNumber = :insurancePolicyNumber"),
    @NamedQuery(name = "Consent.findByEmergencyContact", query = "SELECT c FROM Consent c WHERE c.emergencyContact = :emergencyContact"),
    @NamedQuery(name = "Consent.findById", query = "SELECT c FROM Consent c WHERE c.id = :id"),
    @NamedQuery(name = "Consent.findByFamilyPhysicianPhoneNumber", query = "SELECT c FROM Consent c WHERE c.familyPhysicianPhoneNumber = :familyPhysicianPhoneNumber"),
    @NamedQuery(name = "Consent.findByGuardianEmail", query = "SELECT c FROM Consent c WHERE c.guardianEmail = :guardianEmail"),
    @NamedQuery(name = "Consent.findByGuardianFullName", query = "SELECT c FROM Consent c WHERE c.guardianFullName = :guardianFullName"),
    @NamedQuery(name = "Consent.findByGuardianPhoneNumber", query = "SELECT c FROM Consent c WHERE c.guardianPhoneNumber = :guardianPhoneNumber"),
    @NamedQuery(name = "Consent.findByMedicalCondition", query = "SELECT c FROM Consent c WHERE c.medicalCondition = :medicalCondition"),
    @NamedQuery(name = "Consent.findByPersonID", query = "SELECT c FROM Consent c WHERE c.personID = :personID"),
    @NamedQuery(name = "Consent.findByRegistrationID", query = "SELECT c FROM Consent c WHERE c.registrationID = :registrationID"),
    @NamedQuery(name = "Consent.findByRelationship", query = "SELECT c FROM Consent c WHERE c.relationship = :relationship")})
public class Consent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consentID")
    private Long consentID;
    @Column(name = "InsurancePolicyNumber")
    private String insurancePolicyNumber;
    @Column(name = "emergencyContact")
    private String emergencyContact;
    @Column(name = "id")
    private String id;
    @Column(name = "familyPhysicianPhoneNumber")
    private String familyPhysicianPhoneNumber;
    @Column(name = "guardianEmail")
    private String guardianEmail;
    @Column(name = "guardianFullName")
    private String guardianFullName;
    @Column(name = "guardianPhoneNumber")
    private String guardianPhoneNumber;
    @Column(name = "medicalCondition")
    private String medicalCondition;
    @Column(name = "personID")
    private Long personID;
    @Column(name = "registrationID")
    private Long registrationID;
    @Column(name = "relationship")
    private String relationship;
    @Column(name = "dietaryRestriction")
    private String dietaryRestriction;
    @Column(name = "allergies")
    private String allergies;

    public Consent() {
    }

    public Consent(Long consentID) {
        this.consentID = consentID;
    }

    public Long getConsentID() {
        return consentID;
    }

    public void setConsentID(Long consentID) {
        this.consentID = consentID;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamilyPhysicianPhoneNumber() {
        return familyPhysicianPhoneNumber;
    }

    public void setFamilyPhysicianPhoneNumber(String familyPhysicianPhoneNumber) {
        this.familyPhysicianPhoneNumber = familyPhysicianPhoneNumber;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }

    public String getGuardianFullName() {
        return guardianFullName;
    }

    public void setGuardianFullName(String guardianFullName) {
        this.guardianFullName = guardianFullName;
    }

    public String getGuardianPhoneNumber() {
        return guardianPhoneNumber;
    }

    public void setGuardianPhoneNumber(String guardianPhoneNumber) {
        this.guardianPhoneNumber = guardianPhoneNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    public Long getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(Long registrationID) {
        this.registrationID = registrationID;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * @return the dietaryRestriction
     */
    public String getDietaryRestriction() {
        return dietaryRestriction;
    }

    /**
     * @param dietaryRestriction the dietaryRestriction to set
     */
    public void setDietaryRestriction(String dietaryRestriction) {
        this.dietaryRestriction = dietaryRestriction;
    }

    /**
     * @return the allergies
     */
    public String getAllergies() {
        return allergies;
    }

    /**
     * @param allergies the allergies to set
     */
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consentID != null ? consentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consent)) {
            return false;
        }
        Consent other = (Consent) object;
        if ((this.consentID == null && other.consentID != null) || (this.consentID != null && !this.consentID.equals(other.consentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cclife.application.model.Consent[ consentID=" + consentID + " ]";
    }

}
