/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.dao;

import biz.cccm.registration.dao.exceptions.NonexistentEntityException;
//import biz.cccm.registration.domain.BaseObject;
import biz.cccm.registration.model.Family;
import java.util.List;

/**
 *
 * @author CHEH
 */
public interface FamilyDao {

    public void create(Family family);

    public void edit(Family family) throws NonexistentEntityException, Exception;

    public void destroy(Integer id) throws NonexistentEntityException;

    public List<Family> findFamilyEntities();

    public List<Family> findFamilyEntities(int maxResults, int firstResult);

    public Family findFamily(Integer id);

    public int getFamilyCount();

}
