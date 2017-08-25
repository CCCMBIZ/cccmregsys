package biz.cccm.mgmt.registration.service.impl;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import biz.cccm.mgmt.registration.dao.PersonDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Person;
import biz.cccm.mgmt.registration.service.PersonManager;
import biz.cccm.service.impl.GenericManagerImpl;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("personManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Integer> implements PersonManager, Serializable {

    private PersonDao personDao;

//    private MailEngine mailEngine;
//    private SimpleMailMessage message;

    @Override
    @Autowired
    public void setPersonDao(final PersonDao personDao) {
        this.dao = personDao;
        this.personDao = personDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getPerson(final Integer personId) {
        return personDao.get(personId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> getPerson() {
        return personDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person savePerson(final Person person) throws NonexistentEntityException {

        try {
            return personDao.savePerson(person);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new NonexistentEntityException("Person '" + person.getPersonID()+ "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     * @param person
     */
    @Override
    public void removePerson(final Person person) {
        log.debug("removing person: " + person);
        personDao.remove(person);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePerson(final Integer personId) {
        log.debug("removing person: " + personId);
        personDao.remove(personId);
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
    public List<Person> getPersonsByFamilyID(final Integer personId) throws NonexistentEntityException {
        return personDao.loadPersonsByFamilyID(personId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> search(final String searchTerm) {
        return super.search(searchTerm, Person.class);
    }

}
