package biz.cccm.mgmt.registration.action;

import java.io.Serializable;
import java.util.List;
import biz.cccm.dao.SearchException;
import biz.cccm.mgmt.registration.service.FamilyManager;
import biz.cccm.webapp.action.BasePage;

public class FamilyList extends BasePage implements Serializable {

    private static final long serialVersionUID = 972359310602744020L;
    protected FamilyManager familyManager;
    private String query;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
    
    public void setFamilyManager(FamilyManager familyManager) {
        this.familyManager = familyManager;
    }

    public FamilyList() {
        setSortColumn("familyID");
    }

    public List getFamilys() {
//        return familyManager.getFamilys() ;
        
        try {
            return sort(familyManager.search(query));
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(familyManager.search(query));
        }
    }

    public String search() {
        return "success";
    }
}
