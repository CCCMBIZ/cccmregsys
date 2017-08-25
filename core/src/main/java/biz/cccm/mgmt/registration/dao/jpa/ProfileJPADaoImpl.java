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
import biz.cccm.mgmt.registration.model.Profile;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.PreexistingEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.RollbackFailureException;

/**
 *
 * @author ch1choo1
 */
@Repository("profileJpaDao")
public class ProfileJPADaoImpl implements GenericJPADao<Profile> {

    private static final Logger logger = Logger.getLogger(ProfileJPADaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
    @Override
    public void create(Profile profile) throws PreexistingEntityException, RollbackFailureException, Exception {
        try {
            entityManager.persist(profile);
        } catch (Exception ex) {
            logger.error("ProfileJPADaoImpl ERROR:" + ex.getLocalizedMessage());
            if (find(profile.getPersonID()) != null) {
                throw new PreexistingEntityException("Profile " + profile.getPersonID() + " already exists.", ex);
            }
            throw ex;
        }
    }

    @Transactional
    @Override
    public void edit(Profile profile) throws NonexistentEntityException, RollbackFailureException, Exception {

        try {
            profile = entityManager.merge(profile);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
               Integer id = profile.getPersonID();
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
            Profile profile;
            try {
                profile = entityManager.getReference(Profile.class, id);
                logger.debug("Delete object id:" + profile.getPersonID());
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The auditSms with id " + id + " no longer exists.", enfe);
            }
            entityManager.remove(profile);

        } catch (NonexistentEntityException ex) {
            throw ex;
        }
    }

    @Override
    public List<Profile> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Profile> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    private List<Profile> findEntities(boolean all, int maxResults, int firstResult) {

        Query q = entityManager.createQuery("select o from Profile o");
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();

    }

    @Override
    public int getCount() {

        Query q = entityManager.createQuery("select count(o) from Profile as o");
        return ((Long) q.getSingleResult()).intValue();

    }

    @Override
    public Profile find(Object id) {
        return entityManager.find(Profile.class, (Long) id);
    }

    @Override
    public List<Profile> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        
        Query query = entityManager.createNamedQuery(queryName);

        for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
            logger.debug("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
        }

        List<Profile> results = query.getResultList();
        
        return results;
    }
}
