package biz.cccm.mgmt.registration.service.impl;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.MealplanDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Mealplan;
import biz.cccm.mgmt.registration.service.MealplanManager;
import biz.cccm.service.impl.GenericManagerImpl;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("mealplanManager")
public class MealplanManagerImpl extends GenericManagerImpl<Mealplan, String> implements MealplanManager, Serializable {

    private MealplanDao mealplanDao;

//    private MailEngine mailEngine;
//    private SimpleMailMessage message;

    @Override
    @Autowired
    public void setMealplanDao(final MealplanDao mealplanDao) {
        this.dao = mealplanDao;
        this.mealplanDao = mealplanDao;
    }

    /**
     * {@inheritDoc}
     * @param registratioId
     */
    @Override
    public Mealplan getMealplan(final String registratioId) {
        return mealplanDao.get(registratioId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Mealplan> getMealplan() {
        return mealplanDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mealplan saveMealplan(final Mealplan mealplan) throws NonexistentEntityException {

        try {
            return mealplanDao.saveMealplan(mealplan);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new NonexistentEntityException("Mealplan '" + mealplan.getRegistrationID() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     * @param mealplan
     */
    @Override
    public void removeMealplan(final Mealplan mealplan) {
        log.debug("removing mealplan: " + mealplan);
        mealplanDao.remove(mealplan);
    }

    /**
     * {@inheritDoc}
     * @param registratioId
     */
    @Override
     public void removeMealplan(String registratioId) {
        log.debug("removing mealplan: " + registratioId);
        mealplanDao.remove(registratioId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Mealplan> search(final String searchTerm) {
        return super.search(searchTerm, Mealplan.class);
    }

}
