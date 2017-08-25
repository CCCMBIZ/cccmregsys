/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.dao.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import biz.cccm.mgmt.registration.model.Church;
import org.apache.log4j.Logger;
import biz.cccm.dao.SearchException;
import biz.cccm.mgmt.registration.dao.ChurchJPADao;

/**
 *
 * @author CH1CHOO1
 */
@Repository("churchJpaDao")
public class ChurchJPADaoImpl implements ChurchJPADao {

    private static final Logger logger = Logger.getLogger(ChurchJPADaoImpl.class);
    
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Church> getAll() {
        return entityManager.createQuery(
                "SELECT c FROM Church c").getResultList();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Church save(Church church) {

        logger.info("entering ChurchDaoImpl:save... ");
        try {
            entityManager.persist(church);

        } catch (DataAccessException e) {
            logger.error("save:" + e.getMessage());
        }
        return entityManager.find(Church.class, church);
    }

    @Transactional(readOnly = true)
    @Override
    public Church get(Long id) {

        Church c = entityManager.find(Church.class, id);

        if (c == null) {
            logger.warn("Uh oh, '" + this.getClass() + "' object with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(this.getClass(), id);
        }

        return c;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean exists(Long id) {

        return entityManager.contains(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void remove(Long id) {
        entityManager.remove(this.get(id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Church> getAllDistinct() {
        Collection result = new LinkedHashSet(getAll());
        return new ArrayList(result);
    }
    
    @Override
    public List<Church> findChurchesByQuery(String query) {
        return entityManager.createQuery(query).getResultList();
    }

// helpers


    @Override
    public List<Church> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Church> search(String searchTerm) throws SearchException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Church object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reindex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reindexAll(boolean async) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
