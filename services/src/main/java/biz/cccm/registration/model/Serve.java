/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "serve", catalog = "cccmdb1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serve.findAll", query = "SELECT s FROM Serve s"),
    @NamedQuery(name = "Serve.findByPersonID", query = "SELECT s FROM Serve s WHERE s.personID = :personID"),
    @NamedQuery(name = "Serve.findByVideo", query = "SELECT s FROM Serve s WHERE s.video = :video"),
    @NamedQuery(name = "Serve.findByAudio", query = "SELECT s FROM Serve s WHERE s.audio = :audio"),
    @NamedQuery(name = "Serve.findByPicture", query = "SELECT s FROM Serve s WHERE s.picture = :picture"),
    @NamedQuery(name = "Serve.findByWorshipLead", query = "SELECT s FROM Serve s WHERE s.worshipLead = :worshipLead"),
    @NamedQuery(name = "Serve.findByRegistration", query = "SELECT s FROM Serve s WHERE s.registration = :registration"),
    @NamedQuery(name = "Serve.findByUsher", query = "SELECT s FROM Serve s WHERE s.usher = :usher"),
    @NamedQuery(name = "Serve.findByMarketing", query = "SELECT s FROM Serve s WHERE s.marketing = :marketing"),
    @NamedQuery(name = "Serve.findByTranslate", query = "SELECT s FROM Serve s WHERE s.translate = :translate"),
    @NamedQuery(name = "Serve.findByWorkshopHost", query = "SELECT s FROM Serve s WHERE s.workshopHost = :workshopHost"),
    @NamedQuery(name = "Serve.findByPrayer", query = "SELECT s FROM Serve s WHERE s.prayer = :prayer"),
    @NamedQuery(name = "Serve.findByFlyerDesign", query = "SELECT s FROM Serve s WHERE s.flyerDesign = :flyerDesign"),
    @NamedQuery(name = "Serve.findByPpt", query = "SELECT s FROM Serve s WHERE s.ppt = :ppt"),
    @NamedQuery(name = "Serve.findByLiterature", query = "SELECT s FROM Serve s WHERE s.literature = :literature"),
    @NamedQuery(name = "Serve.findByMeal", query = "SELECT s FROM Serve s WHERE s.meal = :meal"),
    @NamedQuery(name = "Serve.findBySiteArrangement", query = "SELECT s FROM Serve s WHERE s.siteArrangement = :siteArrangement"),
    @NamedQuery(name = "Serve.findByGeneralAffair", query = "SELECT s FROM Serve s WHERE s.generalAffair = :generalAffair"),
    @NamedQuery(name = "Serve.findByChildrenMinistry", query = "SELECT s FROM Serve s WHERE s.childrenMinistry = :childrenMinistry"),
    @NamedQuery(name = "Serve.findByYouthMinistry", query = "SELECT s FROM Serve s WHERE s.youthMinistry = :youthMinistry"),
    @NamedQuery(name = "Serve.findByChurchCoordinator", query = "SELECT s FROM Serve s WHERE s.churchCoordinator = :churchCoordinator")})
public class Serve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PersonID", nullable = false)
    private Integer personID;
    @Column(name = "Video")
    private Boolean video;
    @Column(name = "Audio")
    private Boolean audio;
    @Column(name = "Picture")
    private Boolean picture;
    @Column(name = "WorshipLead")
    private Boolean worshipLead;
    @Column(name = "Registration")
    private Boolean registration;
    @Column(name = "Usher")
    private Boolean usher;
    @Column(name = "Marketing")
    private Boolean marketing;
    @Column(name = "Translate")
    private Boolean translate;
    @Column(name = "WorkshopHost")
    private Boolean workshopHost;
    @Column(name = "Prayer")
    private Boolean prayer;
    @Column(name = "FlyerDesign")
    private Boolean flyerDesign;
    @Column(name = "PPT")
    private Boolean ppt;
    @Column(name = "Literature")
    private Boolean literature;
    @Column(name = "Meal")
    private Boolean meal;
    @Column(name = "SiteArrangement")
    private Boolean siteArrangement;
    @Column(name = "GeneralAffair")
    private Boolean generalAffair;
    @Column(name = "ChildrenMinistry")
    private Boolean childrenMinistry;
    @Column(name = "YouthMinistry")
    private Boolean youthMinistry;
    @Column(name = "ChurchCoordinator")
    private Boolean churchCoordinator;

    public Serve() {
    }

    public Serve(Integer personID) {
        this.personID = personID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Boolean getAudio() {
        return audio;
    }

    public void setAudio(Boolean audio) {
        this.audio = audio;
    }

    public Boolean getPicture() {
        return picture;
    }

    public void setPicture(Boolean picture) {
        this.picture = picture;
    }

    public Boolean getWorshipLead() {
        return worshipLead;
    }

    public void setWorshipLead(Boolean worshipLead) {
        this.worshipLead = worshipLead;
    }

    public Boolean getRegistration() {
        return registration;
    }

    public void setRegistration(Boolean registration) {
        this.registration = registration;
    }

    public Boolean getUsher() {
        return usher;
    }

    public void setUsher(Boolean usher) {
        this.usher = usher;
    }

    public Boolean getMarketing() {
        return marketing;
    }

    public void setMarketing(Boolean marketing) {
        this.marketing = marketing;
    }

    public Boolean getTranslate() {
        return translate;
    }

    public void setTranslate(Boolean translate) {
        this.translate = translate;
    }

    public Boolean getWorkshopHost() {
        return workshopHost;
    }

    public void setWorkshopHost(Boolean workshopHost) {
        this.workshopHost = workshopHost;
    }

    public Boolean getPrayer() {
        return prayer;
    }

    public void setPrayer(Boolean prayer) {
        this.prayer = prayer;
    }

    public Boolean getFlyerDesign() {
        return flyerDesign;
    }

    public void setFlyerDesign(Boolean flyerDesign) {
        this.flyerDesign = flyerDesign;
    }

    public Boolean getPpt() {
        return ppt;
    }

    public void setPpt(Boolean ppt) {
        this.ppt = ppt;
    }

    public Boolean getLiterature() {
        return literature;
    }

    public void setLiterature(Boolean literature) {
        this.literature = literature;
    }

    public Boolean getMeal() {
        return meal;
    }

    public void setMeal(Boolean meal) {
        this.meal = meal;
    }

    public Boolean getSiteArrangement() {
        return siteArrangement;
    }

    public void setSiteArrangement(Boolean siteArrangement) {
        this.siteArrangement = siteArrangement;
    }

    public Boolean getGeneralAffair() {
        return generalAffair;
    }

    public void setGeneralAffair(Boolean generalAffair) {
        this.generalAffair = generalAffair;
    }

    public Boolean getChildrenMinistry() {
        return childrenMinistry;
    }

    public void setChildrenMinistry(Boolean childrenMinistry) {
        this.childrenMinistry = childrenMinistry;
    }

    public Boolean getYouthMinistry() {
        return youthMinistry;
    }

    public void setYouthMinistry(Boolean youthMinistry) {
        this.youthMinistry = youthMinistry;
    }

    public Boolean getChurchCoordinator() {
        return churchCoordinator;
    }

    public void setChurchCoordinator(Boolean churchCoordinator) {
        this.churchCoordinator = churchCoordinator;
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
        if (!(object instanceof Serve)) {
            return false;
        }
        Serve other = (Serve) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "_Serve[ personID=" + personID + " ]";
    }
    
}
