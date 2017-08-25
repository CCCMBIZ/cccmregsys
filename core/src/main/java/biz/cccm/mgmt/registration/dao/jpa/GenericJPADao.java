/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.dao.jpa;

import java.util.List;
import java.util.Map;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.PreexistingEntityException;
import biz.cccm.mgmt.registration.dao.exceptions.RollbackFailureException;

/**
 *
 * @author ch1choo1
 * @param <T>
 */

public interface GenericJPADao<T> {

    public void create(T obj) throws PreexistingEntityException, RollbackFailureException, Exception;

    public void edit(T obj) throws NonexistentEntityException, RollbackFailureException, Exception;

    public void destroy(Object id) throws NonexistentEntityException, RollbackFailureException, Exception;

    public int getCount();

    public List<T> findEntities();

    public List<T> findEntities(int maxResults, int firstResult);

    public T find(Object id);
    
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams);
    
}
