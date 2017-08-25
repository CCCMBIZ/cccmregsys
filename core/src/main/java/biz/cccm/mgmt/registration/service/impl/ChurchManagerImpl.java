package biz.cccm.mgmt.registration.service.impl;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.ChurchDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Church;
import biz.cccm.mgmt.registration.service.ChurchManager;
import biz.cccm.service.impl.GenericManagerImpl;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("churchManager")
public class ChurchManagerImpl extends GenericManagerImpl<Church, Integer> implements ChurchManager, Serializable {

    private ChurchDao churchDao;

//    private MailEngine mailEngine;
//    private SimpleMailMessage message;

    @Override
    @Autowired
    public void setChurchDao(final ChurchDao churchDao) {
        this.dao = churchDao;
        this.churchDao = churchDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Church getChurch(final Integer churchId) {
        return churchDao.get(churchId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Church> getChurch() {
        return churchDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Church saveChurch(final Church church) throws NonexistentEntityException {

        try {
            return churchDao.saveChurch(church);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new NonexistentEntityException("Church '" + church.getAcronym() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     * @param church
     */
    @Override
    public void removeChurch(final Church church) {
        log.debug("removing church: " + church);
        churchDao.remove(church);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeChurch(final Integer churchId) {
        log.debug("removing church: " + churchId);
        churchDao.remove(churchId);
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
    public Church getChurchByAcronym(String acronym) throws NonexistentEntityException {
        return churchDao.loadChurchByAcronym(acronym) ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Church> search(final String searchTerm) {
        return super.search(searchTerm, Church.class);
    }



}
