/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author CH1CHOO1
 */
@Entity
@Table(name = "mealplan")
@Indexed
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mealplan.findAll", query = "SELECT m FROM Mealplan m"),
    @NamedQuery(name = "Mealplan.findByRegistrationID", query = "SELECT m FROM Mealplan m WHERE m.registrationID = :registrationID"),
    @NamedQuery(name = "Mealplan.findByBreakfast1", query = "SELECT m FROM Mealplan m WHERE m.breakfast1 = :breakfast1"),
    @NamedQuery(name = "Mealplan.findByBreakfast2", query = "SELECT m FROM Mealplan m WHERE m.breakfast2 = :breakfast2"),
    @NamedQuery(name = "Mealplan.findByBreakfast3", query = "SELECT m FROM Mealplan m WHERE m.breakfast3 = :breakfast3"),
    @NamedQuery(name = "Mealplan.findByBreakfast4", query = "SELECT m FROM Mealplan m WHERE m.breakfast4 = :breakfast4"),
    @NamedQuery(name = "Mealplan.findByBreakfast5", query = "SELECT m FROM Mealplan m WHERE m.breakfast5 = :breakfast5"),
    @NamedQuery(name = "Mealplan.findByDinner1", query = "SELECT m FROM Mealplan m WHERE m.dinner1 = :dinner1"),
    @NamedQuery(name = "Mealplan.findByDinner2", query = "SELECT m FROM Mealplan m WHERE m.dinner2 = :dinner2"),
    @NamedQuery(name = "Mealplan.findByDinner3", query = "SELECT m FROM Mealplan m WHERE m.dinner3 = :dinner3"),
    @NamedQuery(name = "Mealplan.findByDinner4", query = "SELECT m FROM Mealplan m WHERE m.dinner4 = :dinner4"),
    @NamedQuery(name = "Mealplan.findByDinner5", query = "SELECT m FROM Mealplan m WHERE m.dinner5 = :dinner5"),
    @NamedQuery(name = "Mealplan.findByLastScannedPerson", query = "SELECT m FROM Mealplan m WHERE m.lastScannedPerson = :lastScannedPerson"),
    @NamedQuery(name = "Mealplan.findByLunch1", query = "SELECT m FROM Mealplan m WHERE m.lunch1 = :lunch1"),
    @NamedQuery(name = "Mealplan.findByLunch2", query = "SELECT m FROM Mealplan m WHERE m.lunch2 = :lunch2"),
    @NamedQuery(name = "Mealplan.findByLunch3", query = "SELECT m FROM Mealplan m WHERE m.lunch3 = :lunch3"),
    @NamedQuery(name = "Mealplan.findByLunch4", query = "SELECT m FROM Mealplan m WHERE m.lunch4 = :lunch4"),
    @NamedQuery(name = "Mealplan.findByLunch5", query = "SELECT m FROM Mealplan m WHERE m.lunch5 = :lunch5")})
public class Mealplan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @DocumentId
    @Column(name = "RegistrationID")
    private String registrationID;
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
    @Column(name = "breakfast5")
    @Field
    private Integer breakfast5;
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
    @Column(name = "dinner5")
    @Field
    private Integer dinner5;
    @Column(name = "lastScannedPerson")
    @Field
    private String lastScannedPerson;
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
    @Column(name = "lunch5")
    @Field
    private Integer lunch5;

    public Mealplan() {
    }

    public Mealplan(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
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

    public Integer getBreakfast5() {
        return breakfast5;
    }

    public void setBreakfast5(Integer breakfast5) {
        this.breakfast5 = breakfast5;
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

    public Integer getDinner5() {
        return dinner5;
    }

    public void setDinner5(Integer dinner5) {
        this.dinner5 = dinner5;
    }

    public String getLastScannedPerson() {
        return lastScannedPerson;
    }

    public void setLastScannedPerson(String lastScannedPerson) {
        this.lastScannedPerson = lastScannedPerson;
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

    public Integer getLunch5() {
        return lunch5;
    }

    public void setLunch5(Integer lunch5) {
        this.lunch5 = lunch5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registrationID != null ? registrationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mealplan)) {
            return false;
        }
        Mealplan other = (Mealplan) object;

        if ((this.registrationID == null && other.registrationID != null) || (this.registrationID != null && !this.registrationID.equals(other.registrationID))) {
            return false;
        }
        if ((this.breakfast1 == null && other.breakfast1 != null) || (this.breakfast1 != null && !this.breakfast1.equals(other.breakfast1))) {
            return false;
        }
        if ((this.breakfast2 == null && other.breakfast2 != null) || (this.breakfast2 != null && !this.breakfast2.equals(other.breakfast2))) {
            return false;
        }
        if ((this.breakfast3 == null && other.breakfast3 != null) || (this.breakfast3 != null && !this.breakfast3.equals(other.breakfast3))) {
            return false;
        }
        if ((this.breakfast4 == null && other.breakfast4 != null) || (this.breakfast4 != null && !this.breakfast4.equals(other.breakfast4))) {
            return false;
        }
        if ((this.breakfast5 == null && other.breakfast5 != null) || (this.breakfast5 != null && !this.breakfast5.equals(other.breakfast5))) {
            return false;
        }
        if ((this.lunch1 == null && other.lunch1 != null) || (this.lunch1 != null && !this.lunch1.equals(other.lunch1))) {
            return false;
        }
        if ((this.lunch2 == null && other.lunch2 != null) || (this.lunch2 != null && !this.lunch2.equals(other.lunch2))) {
            return false;
        }
        if ((this.lunch3 == null && other.lunch3 != null) || (this.lunch3 != null && !this.lunch3.equals(other.lunch3))) {
            return false;
        }
        if ((this.lunch4 == null && other.lunch4 != null) || (this.lunch4 != null && !this.lunch4.equals(other.lunch4))) {
            return false;
        }
        if ((this.lunch5 == null && other.lunch5 != null) || (this.lunch5 != null && !this.lunch5.equals(other.lunch5))) {
            return false;
        }
        if ((this.dinner1 == null && other.dinner1 != null) || (this.dinner1 != null && !this.dinner1.equals(other.dinner1))) {
            return false;
        }
        if ((this.dinner2 == null && other.dinner2 != null) || (this.dinner2 != null && !this.dinner2.equals(other.dinner2))) {
            return false;
        }
        if ((this.dinner3 == null && other.dinner3 != null) || (this.dinner3 != null && !this.dinner3.equals(other.dinner3))) {
            return false;
        }
        if ((this.dinner4 == null && other.dinner4 != null) || (this.dinner4 != null && !this.dinner4.equals(other.dinner4))) {
            return false;
        }
        if ((this.dinner5 == null && other.dinner5 != null) || (this.dinner5 != null && !this.dinner5.equals(other.dinner5))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cclife.application.model.Mealplan[ registrationID=" + registrationID + " ]";
    }

}
