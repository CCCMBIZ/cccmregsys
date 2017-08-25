/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.dao;


import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import biz.cccm.registration.model.Consent;
import biz.cccm.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.registration.dao.exceptions.PreexistingEntityException;
import biz.cccm.registration.dao.exceptions.RollbackFailureException;

/**
 *
 * @author ch1choo1
 */
@Repository("consentDao")
public class ConsentJPADaoImpl implements GenericJPADao<Consent> {

    private static final Logger logger = Logger.getLogger(ConsentJPADaoImpl.class);

    @PersistenceContext(unitName = "registrationDatabase")
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
    @Override
    public void create(Consent consent) throws PreexistingEntityException, RollbackFailureException, Exception {
        try {
            entityManager.persist(consent);
        } catch (Exception ex) {
            logger.error("ConsentJPADaoImpl ERROR:" + ex.getLocalizedMessage());
            if (find(consent.getConsentID()) != null) {
                throw new PreexistingEntityException("Consent " + consent + " already exists.", ex);
            }
            throw ex;
        }
    }

    @Transactional
    @Override
    public void edit(Consent consent) throws NonexistentEntityException, RollbackFailureException, Exception {

        try {
            consent = entityManager.merge(consent);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = consent.getConsentID();
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
            Consent consent;
            try {
                consent = entityManager.getReference(Consent.class, id);
                logger.debug("Delete object id:" + consent.getConsentID());
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The auditSms with id " + id + " no longer exists.", enfe);
            }
            entityManager.remove(consent);

        } catch (NonexistentEntityException ex) {
            throw ex;
        }
    }

    @Override
    public List<Consent> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Consent> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    private List<Consent> findEntities(boolean all, int maxResults, int firstResult) {

        Query q = entityManager.createQuery("select o from Consent o");
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();

    }

    @Override
    public int getCount() {

        Query q = entityManager.createQuery("select count(o) from Consent as o");
        return ((Long) q.getSingleResult()).intValue();

    }

    @Override
    public Consent find(Object id) {
        return entityManager.find(Consent.class, (Long) id);
    }

    @Override
    public List<Consent> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        
        Query query = entityManager.createNamedQuery(queryName);

        for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
            logger.debug("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
        }

        List<Consent> results = query.getResultList();
        
        return results;
    }
}
