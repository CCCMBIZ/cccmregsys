package biz.cccm.mgmt.registration.dao.hibernate;

import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import biz.cccm.dao.hibernate.GenericDaoHibernate;
import biz.cccm.mgmt.registration.dao.ChurchDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Church;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Church objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 * Extended to implement Acegi UserDetailsService interface by David Carter
 * david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * to work with the new BaseDaoHibernate implementation that uses generics.
 * Modified by jgarcia (updated to hibernate 4)
 */
@Repository("churchDao")
public class ChurchDaoHibernate extends GenericDaoHibernate<Church, Integer> implements ChurchDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public ChurchDaoHibernate() {
        super(Church.class);
    }

    /**
     * Overridden simply to call the saveUser method. This is happening because
     * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
     *
     * @param church
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Church save(Church church) {
        return this.saveChurch(church);
    }

    @Override
    public Church loadChurchByAcronym(String acronym) throws NonexistentEntityException {
        List churchList = getSession().createCriteria(Church.class).add(Restrictions.eq("acronym", acronym)).list();
        if (churchList == null || churchList.isEmpty()) {
            throw new NonexistentEntityException("Church '" + acronym + "' not found...");
        } else {
            return (Church) churchList.get(0);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Church> getChurch() {
        Query qry = getSession().createQuery("from Church u order by upper(u.churchName)");
        return qry.list();
    }

    @Override
    public Church saveChurch(Church church) {
        if (log.isDebugEnabled()) {
            log.debug("Service's id: " + church.getChurchID());
        }
        getSession().saveOrUpdate(church);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return church;
    }
}
