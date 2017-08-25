/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.dao.jpa;

import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.PreexistingEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.RollbackFailureException;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import biz.cccm.mgmt.registration.model.Person;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author CH1CHOO1
 */
@Repository("personJpaDao")
public class PersonJPADaoImpl implements GenericJPADao<Person> {

    private static final Logger logger = Logger.getLogger(PersonJPADaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void create(Person person) throws PreexistingEntityException, RollbackFailureException, Exception {
        try {

            if (person.getPersonID() == null) {
                entityManager.persist(person);
            } else {
                if (!entityManager.contains(person)) {
                    entityManager.merge(person);
                }
            }
        } catch (Exception ex) {
            logger.error("PersonJPADaoImpl ERROR: " + ex.getLocalizedMessage());
            if (find(person.getPersonID()) != null) {
                throw new PreexistingEntityException("Person " + person + " already exists.", ex);
            }
            throw ex;
        }
    }

    @Transactional
    @Override
    public void edit(Person person) throws NonexistentEntityException, RollbackFailureException, Exception {

        try {
            person = entityManager.merge(person);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = person.getPersonID().longValue();
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
            Person person;
            try {
                person = entityManager.getReference(Person.class, id);
                logger.debug("Delete object id:" + person.getPersonID());
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The auditSms with id " + id + " no longer exists.", enfe);
            }
            entityManager.remove(person);

        } catch (NonexistentEntityException ex) {
            throw ex;
        }
    }

    @Override
    public List<Person> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Person> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    private List<Person> findEntities(boolean all, int maxResults, int firstResult) {

        Query q = entityManager.createQuery("select o from Person o");
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();

    }

    @Override
    public int getCount() {

        Query q = entityManager.createQuery("select count(o) from Person as o");
        return ((Long) q.getSingleResult()).intValue();

    }

    @Override
    public Person find(Object id) {
        return entityManager.find(Person.class, (Integer) id);
    }

    @Override
    public List<Person> findByNamedQuery(String queryName, Map<String, Object> queryParams) {

        Query query = entityManager.createNamedQuery(queryName);

        for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
            logger.debug("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
        }

        List<Person> results = query.getResultList();

        return results;
    }
}
