package biz.cccm.mgmt.registration.service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.PersonDao;
import biz.cccm.mgmt.registration.model.Person;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.service.GenericManager;

/**
 * Business Person Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface PersonManager extends GenericManager<Person, Integer> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param personDao
     */
    void setPersonDao(PersonDao personDao);


    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param personId
     * @return User
     */
    Person getPerson(Integer personId);

    /**
     * Finds a user by their username.
     * @param personId
     * @return User a populated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *         exception thrown when user not found
     */
    List<Person> getPersonsByFamilyID(final Integer personId) throws NonexistentEntityException;

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Person> getPerson();

    /**
     * Saves a user's information.
     *
     * @param person
     * @return user the updated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     */
    Person savePerson(Person person) throws NonexistentEntityException;

    /**
     * Removes a user from the database
     *
     * @param person
     */
    void removePerson(Person person);

    /**
     * Removes a user from the database by their userId
     *
     * @param personId
     */
    void removePerson(Integer personId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Person> search(String searchTerm);


}
