package biz.cccm.mgmt.registration.service.impl;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.FamilyDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Family;
import biz.cccm.mgmt.registration.service.FamilyManager;
import biz.cccm.service.impl.GenericManagerImpl;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("familyManager")
public class FamilyManagerImpl extends GenericManagerImpl<Family, Integer> implements FamilyManager, Serializable {

    private FamilyDao familyDao;

//    private MailEngine mailEngine;
//    private SimpleMailMessage message;

    @Override
    @Autowired
    public void setFamilyDao(final FamilyDao familyDao) {
        this.dao = familyDao;
        this.familyDao = familyDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Family getFamily(final Integer familyId) {
        return familyDao.get(familyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Family> getFamily() {
        return familyDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Family saveFamily(final Family family) throws NonexistentEntityException {

        try {
            return familyDao.saveFamily(family);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new NonexistentEntityException("Family '" + family.getFamilyName() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     * @param family
     */
    @Override
    public void removeFamily(final Family family) {
        log.debug("removing family: " + family);
        familyDao.remove(family);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeFamily(final Integer familyId) {
        log.debug("removing family: " + familyId);
        familyDao.remove(familyId);
    }

    /**
     * {@inheritDoc}
     *
     * @return User the populated user object
     * @throws
     * org.springframework.security.core.userdetails.UsernameNotFoundException
     * thrown when username not found
     */
    @Override
    public Family getFamilyByFamilyID(final Integer familyId) throws NonexistentEntityException {
        return familyDao.loadFamilyByFamilyID(familyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Family> search(final String searchTerm) {
        return super.search(searchTerm, Family.class);
    }

}
