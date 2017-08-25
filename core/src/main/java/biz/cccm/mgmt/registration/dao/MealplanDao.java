package biz.cccm.mgmt.registration.dao;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import biz.cccm.dao.GenericDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Mealplan;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface MealplanDao extends GenericDao<Mealplan, String> {

    /**
     * Gets users information based on login name.
     * @param registrationId
     * @return userDetails populated userDetails object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException thrown when user not
     * found in database
     */
    @Transactional
    Mealplan loadMealplanByRegistrationID(String registrationId) throws NonexistentEntityException;

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of families
     */
    List<Mealplan> getMealplan();

    /**
     * Saves a mealplan's information.
     * @param mealplan
     * @return the persisted User object
     */
    Mealplan saveMealplan(Mealplan mealplan);


    
}
