package biz.cccm.mgmt.registration.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import biz.cccm.dao.GenericDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Church;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface ChurchDao extends GenericDao<Church, Integer> {

    /**
     * Gets users information based on login name.
     *
     * @param acronym
     * @return userDetails populated userDetails object
     * @throws
     * biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException
     * @throws
     * org.springframework.security.core.userdetails.UsernameNotFoundException
     * thrown when user not found in database
     */
    @Transactional
    public Church loadChurchByAcronym(String acronym) throws NonexistentEntityException;

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     *
     * @return List populated list of families
     */
    List<Church> getChurch();

    /**
     * Saves a church's information.
     *
     * @param church
     * @return the persisted User object
     */
    Church saveChurch(Church church);

}
