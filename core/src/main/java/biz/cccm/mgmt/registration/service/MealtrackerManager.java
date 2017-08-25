package biz.cccm.mgmt.registration.service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.MealtrackerDao;
import biz.cccm.mgmt.registration.model.Mealtracker;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.service.GenericManager;

/**
 * Business Mealtracker Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface MealtrackerManager extends GenericManager<Mealtracker, String> {

    /**
     * Convenience method for testing - allows you to mock the DAO and set it on
     * an interface.
     *
     * @param Dao
     */
    void setMealtrackerDao(MealtrackerDao Dao);

    /**
     * Retrieves a user by userId. An exception is thrown if user not found
     *
     * @param registrationId
     * @return User
     */
    Mealtracker getMealtracker(String registrationId);

    /**
     * Retrieves a list of all users.
     *
     * @return List
     */
    List<Mealtracker> getMealtracker();

    /**
     * Saves a user's information.
     *
     * @param mealtracker
     * @return user the updated user object
     * @throws
     * biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     */
    Mealtracker saveMealtracker(Mealtracker mealtracker) throws NonexistentEntityException;

    /**
     * Removes a user from the database
     *
     * @param mealtracker
     */
    void removeMealtracker(Mealtracker mealtracker);

    /**
     * Removes a user from the database by their userId
     *
     * @param registrationId
     */
    void removeMealtracker(String registrationId);

    /**
     * Search a user for search terms.
     *
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Mealtracker> search(String searchTerm);

    /**
     * Search meal tracking from the database by their registration ID and mealType
     *
     * @param registrationId
     * @param mealType
     * @return 
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     */
    List<Mealtracker> getMealtrackerListByRegistrationIDAndMealType(String registrationId, String mealType) throws NonexistentEntityException;
}
