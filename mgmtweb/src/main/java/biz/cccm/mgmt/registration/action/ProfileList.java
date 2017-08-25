package biz.cccm.mgmt.registration.action;

import java.io.Serializable;
import java.util.List;
import biz.cccm.dao.SearchException;
import biz.cccm.mgmt.registration.service.ProfileManager;
import biz.cccm.webapp.action.BasePage;

public class ProfileList extends BasePage implements Serializable {

    private static final long serialVersionUID = 972359310602744020L;
    protected ProfileManager profileManager;
    private String query;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
    
    public void setProfileManager(ProfileManager profileManager) {
        this.profileManager = profileManager;
    }

    public ProfileList() {
        setSortColumn("personID");
    }

    public List getProfiles() {
//        return profileManager.getProfiles() ;
        
        try {
            return sort(profileManager.search(query));
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(profileManager.search(query));
        }
    }

    public String search() {
        return "success";
    }
}
