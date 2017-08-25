package biz.cccm.mgmt.registration.service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.ChurchDao;
import biz.cccm.mgmt.registration.model.Church;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.service.GenericManager;

/**
 * Business Church Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface ChurchManager extends GenericManager<Church, Integer> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param churchDao
     */
    void setChurchDao(ChurchDao churchDao);


    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param churchId
     * @return User
     */
    Church getChurch(Integer churchId);

    /**
     * Finds a user by their username.
     * @param acronym
     * @return User a populated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *         exception thrown when user not found
     */
    Church getChurchByAcronym(String acronym) throws NonexistentEntityException;

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Church> getChurch();

    /**
     * Saves a user's information.
     *
     * @param church
     * @return user the updated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     */
    Church saveChurch(Church church) throws NonexistentEntityException;

    /**
     * Removes a user from the database
     *
     * @param church
     */
    void removeChurch(Church church);

    /**
     * Removes a user from the database by their userId
     *
     * @param churchId
     */
    void removeChurch(Integer churchId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Church> search(String searchTerm);


}
