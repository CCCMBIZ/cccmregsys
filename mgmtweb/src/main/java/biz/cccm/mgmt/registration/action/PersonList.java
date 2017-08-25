package biz.cccm.mgmt.registration.action;

import java.io.Serializable;
import java.util.List;
import biz.cccm.dao.SearchException;
import biz.cccm.mgmt.registration.service.PersonManager;
import biz.cccm.webapp.action.BasePage;

public class PersonList extends BasePage implements Serializable {

    private static final long serialVersionUID = 972359310602744020L;
    protected PersonManager personManager;
    private String query;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
    
    public void setPersonManager(PersonManager personManager) {
        this.personManager = personManager;
    }

    public PersonList() {
        setSortColumn("personID");
    }

    public List getPersons() {
//        return personManager.getPersons() ;
        
        try {
            return sort(personManager.search(query));
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(personManager.search(query));
        }
    }

    public String search() {
        return "success";
    }
}
