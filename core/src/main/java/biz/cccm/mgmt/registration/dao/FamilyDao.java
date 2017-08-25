package biz.cccm.mgmt.registration.dao;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import biz.cccm.dao.GenericDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Family;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface FamilyDao extends GenericDao<Family, Integer> {

    /**
     * Gets users information based on login name.
     * @param familyId
     * @return userDetails populated userDetails object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException thrown when user not
     * found in database
     */
    @Transactional
    Family loadFamilyByFamilyID(Integer familyId) throws NonexistentEntityException;

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of families
     */
    List<Family> getFamily();

    /**
     * Saves a family's information.
     * @param family
     * @return the persisted User object
     */
    Family saveFamily(Family family);


    
}
