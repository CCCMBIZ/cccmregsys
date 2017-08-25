package biz.cccm.mgmt.registration.service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.RegistrantDao;
import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.service.GenericManager;

/**
 * Business Registrant Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface RegistrantManager extends GenericManager<Registrant, Integer> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param registrantDao
     */
    void setRegistrantDao(RegistrantDao registrantDao);


    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param personId
     * @return User
     */
    Registrant getRegistrant(Integer personId);

    List<Registrant> getRegistrantByRegistrationID(final String registrantId) throws NonexistentEntityException ;
    /**
     * Finds a user by their username.
     * @param personId
     * @return User a populated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *         exception thrown when user not found
     */
    Registrant getRegistrantByPersonID(Integer personId) throws NonexistentEntityException;

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Registrant> getRegistrant();

    /**
     * Saves a user's information.
     *
     * @param registrant
     * @return user the updated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     */
    Registrant saveRegistrant(Registrant registrant) throws NonexistentEntityException;

    /**
     * Removes a user from the database
     *
     * @param registrant
     */
    void removeRegistrant(Registrant registrant);

    /**
     * Removes a user from the database by their userId
     *
     * @param registrantId
     */
    void removeRegistrant(Integer registrantId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Registrant> search(String searchTerm);


}
