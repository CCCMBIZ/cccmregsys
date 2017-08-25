package biz.cccm.mgmt.registration.dao;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import biz.cccm.dao.GenericDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Mealtracker;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface MealtrackerDao extends GenericDao<Mealtracker, String> {

    /**
     * Gets users information based on login name.
     * @param registrationId
     * @param mealType
     * @return userDetails populated userDetails object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException thrown when user not
     * found in database
     */
    @Transactional
    List<Mealtracker> loadMealtrackerByRegistrationIDAndMealType(String registrationId, String mealType) throws NonexistentEntityException;

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of families
     */
    List<Mealtracker> getMealtracker();

    /**
     * Saves a mealtracker's information.
     * @param mealtracker
     * @return the persisted User object
     */
    Mealtracker saveMealtracker(Mealtracker mealtracker);


    
}
