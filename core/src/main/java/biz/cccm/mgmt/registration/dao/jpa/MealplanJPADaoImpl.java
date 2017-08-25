/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.dao.jpa;


import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import biz.cccm.mgmt.registration.model.Mealplan;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.PreexistingEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.RollbackFailureException;

/**
 *
 * @author ch1choo1
 */
@Repository("mealplanJpaDao")
public class MealplanJPADaoImpl implements GenericJPADao<Mealplan> {

    private static final Logger logger = Logger.getLogger(MealplanJPADaoImpl.class);

    @PersistenceContext(unitName = "registrationDatabase")
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
    @Override
    public void create(Mealplan mealplan) throws PreexistingEntityException, RollbackFailureException, Exception {
        try {
            entityManager.persist(mealplan);
        } catch (Exception ex) {
            logger.error("AusitTrailJpaDaoImpl ERROR:" + ex.getLocalizedMessage());
            if (find(mealplan.getRegistrationID()) != null) {
                throw new PreexistingEntityException("Payloads " + mealplan + " already exists.", ex);
            }
            throw ex;
        }
    }

    @Transactional
    @Override
    public void edit(Mealplan mealplan) throws NonexistentEntityException, RollbackFailureException, Exception {

        try {
            mealplan = entityManager.merge(mealplan);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mealplan.getRegistrationID();
                if (find(id) == null) {
                    throw new NonexistentEntityException("The payloads with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    @Transactional
    @Override
    public void destroy(Object id) throws NonexistentEntityException, RollbackFailureException, Exception {

        try {
            Mealplan mealplan;
            try {
                mealplan = entityManager.getReference(Mealplan.class, id);
                logger.debug("Delete object id:" + mealplan.getRegistrationID());
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The auditSms with id " + id + " no longer exists.", enfe);
            }
            entityManager.remove(mealplan);

        } catch (NonexistentEntityException ex) {
            throw ex;
        }
    }

    @Override
    public List<Mealplan> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Mealplan> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    private List<Mealplan> findEntities(boolean all, int maxResults, int firstResult) {

        Query q = entityManager.createQuery("select o from Mealplan o");
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();

    }

    @Override
    public int getCount() {

        Query q = entityManager.createQuery("select count(o) from Mealplan as o");
        return ((Long) q.getSingleResult()).intValue();

    }

    @Override
    public Mealplan find(Object id) {
        return entityManager.find(Mealplan.class, (Long) id);
    }

    @Override
    public List<Mealplan> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        
        Query query = entityManager.createNamedQuery(queryName);

        for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
            logger.debug("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
        }

        List<Mealplan> results = query.getResultList();
        
        return results;
    }
}
