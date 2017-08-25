package biz.cccm.mgmt.registration.service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.ProfileDao;
import biz.cccm.mgmt.registration.model.Profile;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.service.GenericManager;

/**
 * Business Profile Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface ProfileManager extends GenericManager<Profile, Integer> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param profileDao
     */
    void setProfileDao(ProfileDao profileDao);


    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param profileId
     * @return User
     */
    Profile getProfile(Integer profileId);

    /**
     * Finds a user by their username.
     * @param familyId
     * @return User a populated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *         exception thrown when user not found
     */
    public List<Profile> getProfileByFamilyID(final Integer familyId) throws NonexistentEntityException ;

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Profile> getProfile();

    /**
     * Saves a user's information.
     *
     * @param profile
     * @return user the updated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     */
    Profile saveProfile(Profile profile) throws NonexistentEntityException;

    /**
     * Removes a user from the database
     *
     * @param profile
     */
    void removeProfile(Profile profile);

    /**
     * Removes a user from the database by their userId
     *
     * @param profileId
     */
    void removeProfile(Integer profileId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Profile> search(String searchTerm);


}