package biz.cccm.mgmt.registration.service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.MealplanDao;
import biz.cccm.mgmt.registration.model.Mealplan;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.service.GenericManager;

/**
 * Business Mealplan Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface MealplanManager extends GenericManager<Mealplan, String> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param mealplanDao
     */
    void setMealplanDao(MealplanDao mealplanDao);

    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param registrationId
     * @return User
     */
    Mealplan getMealplan(String registrationId);

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Mealplan> getMealplan();

    /**
     * Saves a user's information.
     *
     * @param mealplan
     * @return user the updated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     */
    Mealplan saveMealplan(Mealplan mealplan) throws NonexistentEntityException;

    /**
     * Removes a user from the database
     *
     * @param mealplan
     */
    void removeMealplan(Mealplan mealplan);

    /**
     * Removes a user from the database by their userId
     *
     * @param mealplanId
     */
    void removeMealplan(String registrationId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Mealplan> search(String searchTerm);


}