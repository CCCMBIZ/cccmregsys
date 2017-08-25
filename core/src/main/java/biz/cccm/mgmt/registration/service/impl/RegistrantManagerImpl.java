package biz.cccm.mgmt.registration.service.impl;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.RegistrantDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.service.RegistrantManager;
import biz.cccm.service.impl.GenericManagerImpl;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("registrantManager")
public class RegistrantManagerImpl extends GenericManagerImpl<Registrant, Integer> implements RegistrantManager, Serializable {

    private RegistrantDao registrantDao;

//    private MailEngine mailEngine;
//    private SimpleMailMessage message;

    @Override
    @Autowired
    public void setRegistrantDao(final RegistrantDao registrantDao) {
        this.dao = registrantDao;
        this.registrantDao = registrantDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Registrant> getRegistrantByRegistrationID(final String registrantId) throws NonexistentEntityException {
        return registrantDao.loadRegistrantByRegistrationID(registrantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Registrant> getRegistrant() {
        return registrantDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Registrant saveRegistrant(final Registrant registrant) throws NonexistentEntityException {

        try {
            return registrantDao.saveRegistrant(registrant);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new NonexistentEntityException("Registrant '" + registrant.getPersonID()+ "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     * @param registrant
     */
    @Override
    public void removeRegistrant(final Registrant registrant) {
        log.debug("removing registrant: " + registrant);
        registrantDao.remove(registrant);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeRegistrant(final Integer registrantId) {
        log.debug("removing registrant: " + registrantId);
        registrantDao.remove(registrantId);
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
    public Registrant getRegistrantByPersonID(Integer personId) throws NonexistentEntityException {
        return registrantDao.loadRegistrantByPersonID(personId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Registrant> search(final String searchTerm) {
        return super.search(searchTerm, Registrant.class);
    }

    @Override
    public Registrant getRegistrant(Integer personId)  {
        return registrantDao.get(personId);
    }

}
