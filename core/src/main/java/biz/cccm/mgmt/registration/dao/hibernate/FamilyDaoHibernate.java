package biz.cccm.mgmt.registration.dao.hibernate;


import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import biz.cccm.dao.hibernate.GenericDaoHibernate;
import biz.cccm.mgmt.registration.dao.FamilyDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Family;

/**
 * This class interacts with Hibernate session to save/delete and retrieve Family
 * objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 * Extended to implement Acegi UserDetailsService interface by David Carter
 * david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * to work with the new BaseDaoHibernate implementation that uses generics.
 * Modified by jgarcia (updated to hibernate 4)
 */
@Repository("familyDao")
public class FamilyDaoHibernate extends GenericDaoHibernate<Family, Integer> implements FamilyDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public FamilyDaoHibernate() {
        super(Family.class);
    }

    /**
     * Overridden simply to call the saveUser method. This is happening because
     * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
     *
     * @param family
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Family save(Family family) {
        return this.saveFamily(family);
    }

    @Override
    public Family loadFamilyByFamilyID(Integer familyId) throws NonexistentEntityException {
        List familyList = getSession().createCriteria(Family.class).add(Restrictions.eq("familyName", familyId)).list();
        if (familyList == null || familyList.isEmpty()) {
            throw new NonexistentEntityException("Service '" + familyId + "' not found...");
        } else {
            return (Family) familyList.get(0);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Family> getFamily() {
        Query qry = getSession().createQuery("from Family u order by upper(u.familyName)");
        return qry.list();
    }

    @Override
    public Family saveFamily(Family family) {
        if (log.isDebugEnabled()) {
            log.debug("Service's id: " + family.getFamilyID());
        }
        getSession().saveOrUpdate(family);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return family;    }
}
