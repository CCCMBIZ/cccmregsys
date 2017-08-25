/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import biz.cccm.mgmt.registration.model.Payment;
import biz.cccm.mgmt.registration.dao.PaymentJPADao;

/**
 *
 * @author CH1CHOO1
 */
@Repository("paymentJpaDao")
public class PaymentJPADaoImpl implements PaymentJPADao {

    private static final Logger logger = Logger.getLogger(PaymentJPADaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
//    @Autowired
//    public JpaPaymentDaoImpl(EntityManagerFactory entityManagerFactory) {
//        super.setEntityManagerFactory(entityManagerFactory);
//    }

//    private static final Logger logger = Logger.getLogger(JpaPaymentDaoImpl.class);
    @SuppressWarnings("unchecked")
    @Override
    public Payment findById(long id) {
        return entityManager.find(Payment.class, id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Payment update(Payment obj) {

        Payment p = (Payment) obj;
        return entityManager.merge(p);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void delete(long id) {

        Payment p = (Payment) findById(id);

        if (p != null) {
            entityManager.remove(p);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void save(Payment obj) {

        logger.info("entering JpaPaymentDaoImpl:save... ");
        Payment payment = (Payment) obj;
        try {

            if (payment.getId() == null) {
                entityManager.persist(payment);
            } else {
                payment = entityManager.merge(payment);
            }

        } catch (DataAccessException e) {
            logger.error("save:" + e.getMessage());
        }
    }

    @Override
    public List<Payment> findPaymentByQuery(String query) {
        return entityManager.createQuery(query).getResultList();
    }
}
