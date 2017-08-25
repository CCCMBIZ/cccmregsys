package biz.cccm.mgmt.registration.dao.hibernate;

import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import biz.cccm.dao.hibernate.GenericDaoHibernate;
import biz.cccm.mgmt.registration.dao.RegistrantDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Registrant;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Registrant objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 * Extended to implement Acegi UserDetailsService interface by David Carter
 * david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * to work with the new BaseDaoHibernate implementation that uses generics.
 * Modified by jgarcia (updated to hibernate 4)
 */
@Repository("registrantDao")
public class RegistrantDaoHibernate extends GenericDaoHibernate<Registrant, Integer> implements RegistrantDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public RegistrantDaoHibernate() {
        super(Registrant.class);
    }

    /**
     * Overridden simply to call the saveUser method. This is happening because
     * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
     *
     * @param registrant
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Registrant save(Registrant registrant) {
        return this.saveRegistrant(registrant);
    }

    @Override
    public Registrant loadRegistrantByPersonID(Integer personId) throws NonexistentEntityException {
        List registrantList = getSession().createCriteria(Registrant.class).add(Restrictions.eq("personID", personId)).list();
        if (registrantList == null || registrantList.isEmpty()) {
            throw new NonexistentEntityException("Registrant person ID'" + personId + "' not found...");
        } else {
            return (Registrant) registrantList.get(0);
        }
    }

    @Override
    public List<Registrant> loadRegistrantByRegistrationID(String registrationId) throws NonexistentEntityException {
        List registrantList = getSession().createCriteria(Registrant.class).add(Restrictions.eq("registrationID", registrationId)).list();
        if (registrantList == null || registrantList.isEmpty()) {
            throw new NonexistentEntityException("Registrant registration ID '" + registrationId + "' not found...");
        } else {
            return registrantList;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Registrant> getRegistrant() {
        Query qry = getSession().createQuery("from Registrant u order by upper(u.registrantName)");
        return qry.list();
    }

    @Override
    public Registrant saveRegistrant(Registrant registrant) {
        if (log.isDebugEnabled()) {
            log.debug("Service's id: " + registrant.getPersonID());
        }
        getSession().saveOrUpdate(registrant);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return registrant;
    }

}
