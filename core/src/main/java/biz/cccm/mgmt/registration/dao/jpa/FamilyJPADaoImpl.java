/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.dao.jpa;

import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.PreexistingEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.RollbackFailureException;
import biz.cccm.mgmt.registration.model.Family;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ephesus
 */
@Repository("familyJpaDao")
public class FamilyJPADaoImpl implements GenericJPADao<Family> {

    private static final Logger logger = Logger.getLogger(FamilyJPADaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
    @Override
    public void create(Family family) throws PreexistingEntityException, RollbackFailureException, Exception {
        try {
            entityManager.persist(family);
        } catch (Exception ex) {
            logger.error("FamilyJPADaoImpl ERROR:" + ex.getLocalizedMessage());
            if (find(family.getFamilyID()) != null) {
                throw new PreexistingEntityException(" " + family.getFamilyID() + " already exists.", ex);
            }
            throw ex;
        }
    }

    @Transactional
    @Override
    public void edit(Family family) throws NonexistentEntityException, RollbackFailureException, Exception {

        try {
            family = entityManager.merge(family);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
               Integer id = family.getFamilyID();
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
            Family family;
            try {
                family = entityManager.getReference(Family.class, id);
                logger.debug("Delete object id:" + family.getFamilyID());
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The auditSms with id " + id + " no longer exists.", enfe);
            }
            entityManager.remove(family);

        } catch (NonexistentEntityException ex) {
            throw ex;
        }
    }

    @Override
    public List<Family> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Family> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    private List<Family> findEntities(boolean all, int maxResults, int firstResult) {

        Query q = entityManager.createQuery("select o from Family o");
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();

    }

    @Override
    public int getCount() {

        Query q = entityManager.createQuery("select count(o) from Family as o");
        return ((Long) q.getSingleResult()).intValue();

    }

    @Override
    public Family find(Object id) {
        return entityManager.find(Family.class, (Long) id);
    }

    @Override
    public List<Family> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        
        Query query = entityManager.createNamedQuery(queryName);

        for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
            logger.debug("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
        }

        List<Family> results = query.getResultList();
        
        return results;
    }
}
