package biz.cccm.mgmt.registration.dao.hibernate;


import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import biz.cccm.dao.hibernate.GenericDaoHibernate;
import biz.cccm.mgmt.registration.dao.PersonDao;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Person;

/**
 * This class interacts with Hibernate session to save/delete and retrieve Person
 * objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 * Extended to implement Acegi UserDetailsService interface by David Carter
 * david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * to work with the new BaseDaoHibernate implementation that uses generics.
 * Modified by jgarcia (updated to hibernate 4)
 */
@Repository("personDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Integer> implements PersonDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public PersonDaoHibernate() {
        super(Person.class);
    }

    /**
     * Overridden simply to call the saveUser method. This is happening because
     * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
     *
     * @param person
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Person save(Person person) {
        return this.savePerson(person);
    }

    @Override
    public List<Person> loadPersonsByFamilyID(Integer familyId) throws NonexistentEntityException {
        List personList = getSession().createCriteria(Person.class).add(Restrictions.eq("familyID", familyId)).list();
        if (personList == null || personList.isEmpty()) {
            throw new NonexistentEntityException("Person with '" + familyId + "' not found...");
        } else {
            return personList;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> getPerson() {
        Query qry = getSession().createQuery("from Person u order by upper(u.personName)");
        return qry.list();
    }

    @Override
    public Person savePerson(Person person) {
        if (log.isDebugEnabled()) {
            log.debug("Service's id: " + person.getPersonID());
        }
        getSession().saveOrUpdate(person);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return person;    }
}
