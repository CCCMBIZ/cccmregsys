package biz.cccm.mgmt.registration.action;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Profile;
import biz.cccm.mgmt.registration.service.ProfileManager;
import biz.cccm.webapp.action.BasePage;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 * JSF Page class to handle editing a user with a form.
 *
 * @author chehhoo
 */
public class ProfileForm extends BasePage implements Serializable {

    private static final long serialVersionUID = -1141119853856863205L;
    private ProfileManager profileManager;
    private String id;
    private Profile profile = new Profile();

    public void setId(String id) {
        this.id = id;
    }

    public void setProfileManager(ProfileManager profileManager) {
        this.profileManager = profileManager;
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    public Profile getProfile() {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//        for (Map.Entry pairs : params.entrySet()) {
//            log.debug(pairs.getKey() + " = " + pairs.getValue());
//        }
        log.debug("getting profile, id is: " + id + " | " + profile.getPersonID());
//        if (profile == null) {
//            profile = profileManager.getProfile(id);
//        }
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String add() {
        profile = new Profile();
        DateTime now = new DateTime();
        profile.setLastModified(now.toDate());
        return "editProfile";
    }

    public String edit() {
        log.debug("getting profile, id is: " + id);
        profile = profileManager.getProfile(Integer.parseInt(id));
        return "editProfile";
    }

    public String save() throws IOException {

        log.debug("getting profile, id is: " + id + " | " + profile.getPersonID());

        try {
            profileManager.saveProfile(profile);
            // add success messages
            addMessage("profile.saved");
        } catch (NonexistentEntityException e) {
            addError("errors.update.profile");
            log.error("NonexistentEntityException: " + e.getMessage());
        }

        log.debug("Exit after saved...");

        return "list";
    }

    public String delete() {

        profileManager.removeProfile(profile.getPersonID());
        addMessage("profile.deleted", getProfile().getPersonID());

        return "list";
    }

    public String cancel() {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'cancel' method");
        }

        if (!"list".equals(getParameter("from"))) {
            return "home";
        } else {
            return "list";
        }
    }

}
