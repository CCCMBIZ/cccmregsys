/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.mgmt.registration.dao;


import java.util.List;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Family;

/**
 *
 * @author CHEH
 */
public interface FamilyJPADao {

    public void create(Family family);

    public void edit(Family family) throws NonexistentEntityException, Exception;

    public void destroy(Integer id) throws NonexistentEntityException;

    public List<Family> findFamilyEntities();

    public List<Family> findFamilyEntities(int maxResults, int firstResult);

    public Family findFamily(Integer id);

    public int getFamilyCount();

}
