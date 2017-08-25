package biz.cccm.mgmt.registration.service.impl;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.PaymentDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Payment;
import biz.cccm.mgmt.registration.service.PaymentManager;
import biz.cccm.service.impl.GenericManagerImpl;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("paymentManager")
public class PaymentManagerImpl extends GenericManagerImpl<Payment, Long> implements PaymentManager, Serializable {

    private PaymentDao paymentDao;

//    private MailEngine mailEngine;
//    private SimpleMailMessage message;

    @Override
    @Autowired
    public void setPaymentDao(final PaymentDao paymentDao) {
        this.dao = paymentDao;
        this.paymentDao = paymentDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Payment getPayment(final Long paymentId) {
        return paymentDao.get(paymentId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Payment> getPayment() {
        return paymentDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Payment savePayment(final Payment payment) throws NonexistentEntityException {

        try {
            return paymentDao.savePayment(payment);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new NonexistentEntityException("Payment '" + payment.getId() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     * @param payment
     */
    @Override
    public void removePayment(final Payment payment) {
        log.debug("removing payment: " + payment);
        paymentDao.remove(payment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
     public void removePayment(Long paymentId) {
        log.debug("removing payment: " + paymentId);
        paymentDao.remove(paymentId);
    }

    /**
     * {@inheritDoc}
     *
     * @param registrationId
     * @return User the populated user object
     * @throws
     * org.springframework.security.core.userdetails.UsernameNotFoundException
     * thrown when username not found
     */
    @Override
    public List<Payment> getPaymentsByRegistrationID(Long registrationId) throws NonexistentEntityException {
        return paymentDao.loadPaymentsByRegistrationID(registrationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Payment> search(final String searchTerm) {
        return super.search(searchTerm, Payment.class);
    }


}
