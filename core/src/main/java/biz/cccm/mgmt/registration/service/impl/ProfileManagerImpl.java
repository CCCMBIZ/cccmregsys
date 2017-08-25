package biz.cccm.mgmt.registration.service.impl;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.ProfileDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Profile;
import biz.cccm.mgmt.registration.service.ProfileManager;
import biz.cccm.service.impl.GenericManagerImpl;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("profileManager")
public class ProfileManagerImpl extends GenericManagerImpl<Profile, Integer> implements ProfileManager, Serializable {

    private ProfileDao profileDao;

//    private MailEngine mailEngine;
//    private SimpleMailMessage message;

    @Override
    @Autowired
    public void setProfileDao(final ProfileDao profileDao) {
        this.dao = profileDao;
        this.profileDao = profileDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Profile getProfile(final Integer profileId) {
        return profileDao.get(profileId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Profile> getProfile() {
        return profileDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Profile saveProfile(final Profile profile) throws NonexistentEntityException {

        try {
            return profileDao.saveProfile(profile);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new NonexistentEntityException("Profile '" + profile.getPersonID()+ "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     * @param profile
     */
    @Override
    public void removeProfile(final Profile profile) {
        log.debug("removing profile: " + profile);
        profileDao.remove(profile);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeProfile(final Integer profileId) {
        log.debug("removing profile: " + profileId);
        profileDao.remove(profileId);
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
    public List<Profile> getProfileByFamilyID(final Integer familyId) throws NonexistentEntityException {
        return profileDao.loadProfileByFamilyID(familyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Profile> search(final String searchTerm) {
        return super.search(searchTerm, Profile.class);
    }

}
