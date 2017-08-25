package biz.cccm.mgmt.registration.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import biz.cccm.dao.GenericDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Registrant;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface RegistrantDao extends GenericDao<Registrant, Integer> {

    /**
     * Gets users information based on login name.
     *
     * @param personId
     * @return userDetails populated userDetails object
     * @throws
     * biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws
     * org.springframework.security.core.userdetails.UsernameNotFoundException
     * thrown when user not found in database
     */
    @Transactional
    Registrant loadRegistrantByPersonID(Integer personId) throws NonexistentEntityException;

    @Transactional
    List<Registrant> loadRegistrantByRegistrationID(String registrationId) throws NonexistentEntityException;

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of families
     */
    List<Registrant> getRegistrant();

    /**
     * Saves a registrant's information.
     *
     * @param registrant
     * @return the persisted User object
     */
    Registrant saveRegistrant(Registrant registrant);

}
