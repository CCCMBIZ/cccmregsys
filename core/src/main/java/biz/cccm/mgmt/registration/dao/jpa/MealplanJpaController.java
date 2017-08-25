/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biz.cccm.mgmt.registration.dao.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import biz.cccm.mgmt.registration.model.Mealplan;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.PreexistingEntityException;

/**
 *
 * @author CH1CHOO1
 */
public class MealplanJpaController implements Serializable {

    public MealplanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mealplan mealplan) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mealplan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMealplan(mealplan.getRegistrationID()) != null) {
                throw new PreexistingEntityException("Mealplan " + mealplan + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mealplan mealplan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mealplan = em.merge(mealplan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mealplan.getRegistrationID();
                if (findMealplan(id) == null) {
                    throw new NonexistentEntityException("The mealplan with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mealplan mealplan;
            try {
                mealplan = em.getReference(Mealplan.class, id);
                mealplan.getRegistrationID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mealplan with id " + id + " no longer exists.", enfe);
            }
            em.remove(mealplan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mealplan> findMealplanEntities() {
        return findMealplanEntities(true, -1, -1);
    }

    public List<Mealplan> findMealplanEntities(int maxResults, int firstResult) {
        return findMealplanEntities(false, maxResults, firstResult);
    }

    private List<Mealplan> findMealplanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Mealplan as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Mealplan findMealplan(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mealplan.class, id);
        } finally {
            em.close();
        }
    }

    public int getMealplanCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Mealplan as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
