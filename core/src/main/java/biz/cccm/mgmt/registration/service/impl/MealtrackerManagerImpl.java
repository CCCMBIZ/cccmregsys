package biz.cccm.mgmt.registration.service.impl;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.MealtrackerDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Mealtracker;
import biz.cccm.mgmt.registration.service.MealtrackerManager;
import biz.cccm.service.impl.GenericManagerImpl;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("mealtrackerManager")
public class MealtrackerManagerImpl extends GenericManagerImpl<Mealtracker, String> implements MealtrackerManager, Serializable {

    private MealtrackerDao mealtrackerDao;

//    private MailEngine mailEngine;
//    private SimpleMailMessage message;

    @Override
    @Autowired
    public void setMealtrackerDao(final MealtrackerDao mealtrackerDao) {
        this.dao = mealtrackerDao;
        this.mealtrackerDao = mealtrackerDao;
    }

    /**
     * {@inheritDoc}
     * @param registratioId
     */
    @Override
    public Mealtracker getMealtracker(final String registratioId) {
        return mealtrackerDao.get(registratioId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Mealtracker> getMealtracker() {
        return mealtrackerDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mealtracker saveMealtracker(final Mealtracker mealtracker) throws NonexistentEntityException {

        try {
            return mealtrackerDao.saveMealtracker(mealtracker);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new NonexistentEntityException("Mealtracker '" + mealtracker.getRegistrationID() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     * @param mealtracker
     */
    @Override
    public void removeMealtracker(final Mealtracker mealtracker) {
        log.debug("removing mealtracker: " + mealtracker);
        mealtrackerDao.remove(mealtracker);
    }

    /**
     * {@inheritDoc}
     * @param registratioId
     */
    @Override
     public void removeMealtracker(String registratioId) {
        log.debug("removing mealtracker: " + registratioId);
        mealtrackerDao.remove(registratioId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Mealtracker> search(final String searchTerm) {
        return super.search(searchTerm, Mealtracker.class);
    }
    
    public List<Mealtracker> getMealtrackerListByRegistrationIDAndMealType(String registrationId, String mealType)  throws NonexistentEntityException {
        return mealtrackerDao.loadMealtrackerByRegistrationIDAndMealType(registrationId, mealType) ;
    }

}
