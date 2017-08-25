package biz.cccm.mgmt.registration.dao.hibernate;

import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import biz.cccm.dao.hibernate.GenericDaoHibernate;
import biz.cccm.mgmt.registration.dao.MealtrackerDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Mealtracker;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Mealtracker objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 * Extended to implement Acegi UserDetailsService interface by David Carter
 * david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * to work with the new BaseDaoHibernate implementation that uses generics.
 * Modified by jgarcia (updated to hibernate 4)
 */
@Repository("mealtrackerDao")
public class MealtrackerDaoHibernate extends GenericDaoHibernate<Mealtracker, String> implements MealtrackerDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public MealtrackerDaoHibernate() {
        super(Mealtracker.class);
    }

    /**
     * Overridden simply to call the saveUser method. This is happening because
     * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
     *
     * @param mealtracker
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Mealtracker save(Mealtracker mealtracker) {
        return this.saveMealtracker(mealtracker);
    }

    @Override
    public List<Mealtracker> loadMealtrackerByRegistrationIDAndMealType(String registrationId, String mealType) throws NonexistentEntityException {
        List mealtrackerList = getSession().createCriteria(Mealtracker.class)
                .add(Restrictions.eq("registrationID", registrationId))
                .add(Restrictions.eq("mealType", mealType))
                .list();
        if (mealtrackerList == null || mealtrackerList.isEmpty()) {
            throw new NonexistentEntityException("Mealtracker '" + registrationId + "' not found...");
        } else {
            return mealtrackerList;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Mealtracker> getMealtracker() {
        Query qry = getSession().createQuery("from Mealtracker u order by upper(u.mealtrackerName)");
        return qry.list();
    }

    @Override
    public Mealtracker saveMealtracker(Mealtracker mealtracker) {
        if (log.isDebugEnabled()) {
            log.debug("Mealtracker's id: " + mealtracker.getRegistrationID());
        }
        getSession().saveOrUpdate(mealtracker);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return mealtracker;
    }
}
