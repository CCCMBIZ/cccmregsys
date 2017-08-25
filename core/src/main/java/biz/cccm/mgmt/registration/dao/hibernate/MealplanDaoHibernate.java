package biz.cccm.mgmt.registration.dao.hibernate;

import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import biz.cccm.dao.hibernate.GenericDaoHibernate;
import biz.cccm.mgmt.registration.dao.MealplanDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Mealplan;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Mealplan objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 * Extended to implement Acegi UserDetailsService interface by David Carter
 * david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * to work with the new BaseDaoHibernate implementation that uses generics.
 * Modified by jgarcia (updated to hibernate 4)
 */
@Repository("mealplanDao")
public class MealplanDaoHibernate extends GenericDaoHibernate<Mealplan, String> implements MealplanDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public MealplanDaoHibernate() {
        super(Mealplan.class);
    }

    /**
     * Overridden simply to call the saveUser method. This is happening because
     * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
     *
     * @param mealplan
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Mealplan save(Mealplan mealplan) {
        return this.saveMealplan(mealplan);
    }

    @Override
    public Mealplan loadMealplanByRegistrationID(String registrationId) throws NonexistentEntityException {
        List mealplanList = getSession().createCriteria(Mealplan.class).add(Restrictions.eq("mealplanName", registrationId)).list();
        if (mealplanList == null || mealplanList.isEmpty()) {
            throw new NonexistentEntityException("Mealplan '" + registrationId + "' not found...");
        } else {
            return (Mealplan) mealplanList.get(0);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Mealplan> getMealplan() {
        Query qry = getSession().createQuery("from Mealplan u order by upper(u.mealplanName)");
        return qry.list();
    }

    @Override
    public Mealplan saveMealplan(Mealplan mealplan) {
        if (log.isDebugEnabled()) {
            log.debug("Mealplan's id: " + mealplan.getRegistrationID());
        }
        getSession().saveOrUpdate(mealplan);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return mealplan;
    }
}
