package biz.cccm.mgmt.registration.service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.FamilyDao;
import biz.cccm.mgmt.registration.model.Family;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.service.GenericManager;

/**
 * Business Family Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface FamilyManager extends GenericManager<Family, Integer> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param familyDao
     */
    void setFamilyDao(FamilyDao familyDao);


    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param familyId
     * @return User
     */
    Family getFamily(Integer familyId);

    /**
     * Finds a user by their username.
     * @param familyId
     * @return User a populated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *         exception thrown when user not found
     */
    Family getFamilyByFamilyID(Integer familyId) throws NonexistentEntityException;

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Family> getFamily();

    /**
     * Saves a user's information.
     *
     * @param family
     * @return user the updated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     */
    Family saveFamily(Family family) throws NonexistentEntityException;

    /**
     * Removes a user from the database
     *
     * @param family
     */
    void removeFamily(Family family);

    /**
     * Removes a user from the database by their userId
     *
     * @param familyId
     */
    void removeFamily(Integer familyId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Family> search(String searchTerm);


}
