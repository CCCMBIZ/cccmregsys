package biz.cccm.mgmt.registration.dao;

import java.util.List;
import biz.cccm.dao.GenericDao;
import biz.cccm.mgmt.registration.model.Church;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface ChurchJPADao extends GenericDao<Church, Long> {

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of users
     */

    /**
     * Saves a user's information.
     * @param query
     * @return the persisted User object
     */
    List<Church> findChurchesByQuery(String query);


}
