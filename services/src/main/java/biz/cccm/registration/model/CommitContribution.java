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
@Table(name = "commit_contribution", catalog = "cccmdb1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommitContribution.findAll", query = "SELECT c FROM CommitContribution c"),
    @NamedQuery(name = "CommitContribution.findByCommitContributionID", query = "SELECT c FROM CommitContribution c WHERE c.commitContributionID = :commitContributionID"),
    @NamedQuery(name = "CommitContribution.findByEventID", query = "SELECT c FROM CommitContribution c WHERE c.eventID = :eventID"),
    @NamedQuery(name = "CommitContribution.findByCategory", query = "SELECT c FROM CommitContribution c WHERE c.category = :category"),
    @NamedQuery(name = "CommitContribution.findByCommitContributionInterval", query = "SELECT c FROM CommitContribution c WHERE c.commitContributionInterval = :commitContributionInterval"),
    @NamedQuery(name = "CommitContribution.findByStartDate", query = "SELECT c FROM CommitContribution c WHERE c.startDate = :startDate"),
    @NamedQuery(name = "CommitContribution.findByNextDueDate", query = "SELECT c FROM CommitContribution c WHERE c.nextDueDate = :nextDueDate"),
    @NamedQuery(name = "CommitContribution.findByCommittedAmount", query = "SELECT c FROM CommitContribution c WHERE c.committedAmount = :committedAmount"),
    @NamedQuery(name = "CommitContribution.findByTotalAmountDue", query = "SELECT c FROM CommitContribution c WHERE c.totalAmountDue = :totalAmountDue"),
    @NamedQuery(name = "CommitContribution.findByTotalContributedAmount", query = "SELECT c FROM CommitContribution c WHERE c.totalContributedAmount = :totalContributedAmount"),
    @NamedQuery(name = "CommitContribution.findByLastModified", query = "SELECT c FROM CommitContribution c WHERE c.lastModified = :lastModified")})
public class CommitContribution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CommitContributionID", nullable = false)
    private Integer commitContributionID;
    @Column(name = "EventID")
    private Integer eventID;
    @Column(name = "Category", length = 50)
    private String category;
    @Column(name = "CommitContributionInterval", length = 50)
    private String commitContributionInterval;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "NextDueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextDueDate;
    @Column(name = "CommittedAmount")
    private Integer committedAmount;
    @Column(name = "TotalAmountDue")
    private Integer totalAmountDue;
    @Column(name = "TotalContributedAmount")
    private Integer totalContributedAmount;
    @Column(name = "LastModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    public CommitContribution() {
    }

    public CommitContribution(Integer commitContributionID) {
        this.commitContributionID = commitContributionID;
    }

    public Integer getCommitContributionID() {
        return commitContributionID;
    }

    public void setCommitContributionID(Integer commitContributionID) {
        this.commitContributionID = commitContributionID;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCommitContributionInterval() {
        return commitContributionInterval;
    }

    public void setCommitContributionInterval(String commitContributionInterval) {
        this.commitContributionInterval = commitContributionInterval;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(Date nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public Integer getCommittedAmount() {
        return committedAmount;
    }

    public void setCommittedAmount(Integer committedAmount) {
        this.committedAmount = committedAmount;
    }

    public Integer getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(Integer totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public Integer getTotalContributedAmount() {
        return totalContributedAmount;
    }

    public void setTotalContributedAmount(Integer totalContributedAmount) {
        this.totalContributedAmount = totalContributedAmount;
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
        hash += (commitContributionID != null ? commitContributionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommitContribution)) {
            return false;
        }
        CommitContribution other = (CommitContribution) object;
        if ((this.commitContributionID == null && other.commitContributionID != null) || (this.commitContributionID != null && !this.commitContributionID.equals(other.commitContributionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "_CommitContribution[ commitContributionID=" + commitContributionID + " ]";
    }
    
}
