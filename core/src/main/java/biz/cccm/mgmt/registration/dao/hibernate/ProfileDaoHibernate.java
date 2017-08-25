package biz.cccm.mgmt.registration.dao.hibernate;

import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import biz.cccm.dao.hibernate.GenericDaoHibernate;
import biz.cccm.mgmt.registration.dao.ProfileDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Profile;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Profile objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 * Extended to implement Acegi UserDetailsService interface by David Carter
 * david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * to work with the new BaseDaoHibernate implementation that uses generics.
 * Modified by jgarcia (updated to hibernate 4)
 */
@Repository("profileDao")
public class ProfileDaoHibernate extends GenericDaoHibernate<Profile, Integer> implements ProfileDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public ProfileDaoHibernate() {
        super(Profile.class);
    }

    /**
     * Overridden simply to call the saveUser method. This is happening because
     * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
     *
     * @param profile
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Profile save(Profile profile) {
        return this.saveProfile(profile);
    }

    @Override
    public List<Profile> loadProfileByFamilyID(Integer familyId) throws NonexistentEntityException {
        List profileList = getSession().createCriteria(Profile.class).add(Restrictions.eq("familyID", familyId)).list();
        if (profileList == null || profileList.isEmpty()) {
            throw new NonexistentEntityException("Profile with family ID '" + familyId + "' not found...");
        } else {
            return profileList;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Profile> getProfile() {
        Query qry = getSession().createQuery("from Profile u order by upper(u.profileName)");
        return qry.list();
    }

    @Override
    public Profile saveProfile(Profile profile) {
        if (log.isDebugEnabled()) {
            log.debug("Service's id: " + profile.getPersonID());
        }
        getSession().saveOrUpdate(profile);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return profile;
    }

}
