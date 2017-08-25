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
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Ephesus
 */
@Entity
@Table(name = "mealtracker")
@Indexed
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mealtracker.findAll", query = "SELECT m FROM Mealtracker m"),
    @NamedQuery(name = "Mealtracker.findByTid", query = "SELECT m FROM Mealtracker m WHERE m.tid = :tid"),
    @NamedQuery(name = "Mealtracker.findByPersonID", query = "SELECT m FROM Mealtracker m WHERE m.personID = :personID"),
    @NamedQuery(name = "Mealtracker.findByRegistrationID", query = "SELECT m FROM Mealtracker m WHERE m.registrationID = :registrationID"),
    @NamedQuery(name = "Mealtracker.findByMealType", query = "SELECT m FROM Mealtracker m WHERE m.mealType = :mealType"),
    @NamedQuery(name = "Mealtracker.findByLastModified", query = "SELECT m FROM Mealtracker m WHERE m.lastModified = :lastModified"),
    @NamedQuery(name = "Mealtracker.findByRemark", query = "SELECT m FROM Mealtracker m WHERE m.remark = :remark")})
public class Mealtracker implements Serializable {

    private static final long serialVersionUID = 1111223333L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DocumentId
    @Basic(optional = false)
    @NotNull
    @Column(name = "tid")
    private Integer tid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonID")
    @Field
    private int personID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "RegistrationID")
    @Field
    private String registrationID;
    @Size(max = 20)
    @Column(name = "MealType")
    private String mealType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastModified")
    @Field
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Size(max = 45)
    @Column(name = "Remark")
    @Field
    private String remark;

    public Mealtracker() {
    }

    public Mealtracker(Integer tid) {
        this.tid = tid;
    }

    public Mealtracker(Integer tid, int personID, String registrationID, Date lastModified) {
        this.tid = tid;
        this.personID = personID;
        this.registrationID = registrationID;
        this.lastModified = lastModified;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mealtracker)) {
            return false;
        }
        Mealtracker other = (Mealtracker) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biz.cccm.mgmt.registration.model.Mealtracker[ tid=" + tid + " ]";
    }

}
