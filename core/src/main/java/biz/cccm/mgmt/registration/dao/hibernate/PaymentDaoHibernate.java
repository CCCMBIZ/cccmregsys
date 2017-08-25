package biz.cccm.mgmt.registration.dao.hibernate;

import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import biz.cccm.dao.hibernate.GenericDaoHibernate;
import biz.cccm.mgmt.registration.dao.PaymentDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Payment;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Payment objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 * Extended to implement Acegi UserDetailsService interface by David Carter
 * david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * to work with the new BaseDaoHibernate implementation that uses generics.
 * Modified by jgarcia (updated to hibernate 4)
 */
@Repository("paymentDao")
public class PaymentDaoHibernate extends GenericDaoHibernate<Payment, Long> implements PaymentDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public PaymentDaoHibernate() {
        super(Payment.class);
    }

    /**
     * Overridden simply to call the saveUser method. This is happening because
     * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
     *
     * @param payment
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Payment save(Payment payment) {
        return this.savePayment(payment);
    }

    @Override
    public List<Payment> loadPaymentsByRegistrationID(Long registrationId) throws NonexistentEntityException {
        List paymentList = getSession().createCriteria(Payment.class).add(Restrictions.eq("registrationID", registrationId)).list();
        if (paymentList == null || paymentList.isEmpty()) {
            throw new NonexistentEntityException("Payment with registration ID '" + registrationId + "' not found...");
        } else {
            return paymentList ;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Payment> getPayment() {
        Query qry = getSession().createQuery("from Payment u order by upper(u.paymentName)");
        return qry.list();
    }

    @Override
    public Payment savePayment(Payment payment) {
        if (log.isDebugEnabled()) {
            log.debug("Payment's id: " + payment.getId());
        }
        getSession().saveOrUpdate(payment);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return payment;
    }

}
