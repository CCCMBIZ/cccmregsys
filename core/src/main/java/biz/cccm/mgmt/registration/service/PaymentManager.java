package biz.cccm.mgmt.registration.service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.PaymentDao;
import biz.cccm.mgmt.registration.model.Payment;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.service.GenericManager;

/**
 * Business Payment Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface PaymentManager extends GenericManager<Payment, Long> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param paymentDao
     */
    void setPaymentDao(PaymentDao paymentDao);


    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param paymentId
     * @return User
     */
    Payment getPayment(Long paymentId);

    /**
     * Finds a user by their username.
     * @param registrationId
     * @param personId
     * @return User a populated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *         exception thrown when user not found
     */
    List<Payment> getPaymentsByRegistrationID(Long registrationId) throws NonexistentEntityException;

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Payment> getPayment();

    /**
     * Saves a user's information.
     *
     * @param payment
     * @return user the updated user object
     * @throws biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     */
    Payment savePayment(Payment payment) throws NonexistentEntityException;

    /**
     * Removes a user from the database
     *
     * @param payment
     */
    void removePayment(Payment payment);

    /**
     * Removes a user from the database by their userId
     *
     * @param paymentId
     */
    void removePayment(Long paymentId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Payment> search(String searchTerm);


}