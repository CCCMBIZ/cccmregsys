package biz.cccm.mgmt.registration.action;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Family;
import biz.cccm.mgmt.registration.service.FamilyManager;
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
public class FamilyForm extends BasePage implements Serializable {

    private static final long serialVersionUID = -1141119853856863205L;
    private FamilyManager familyManager;
    private String id;
    private Family family = new Family();

    public void setId(String id) {
        this.id = id;
    }

    public void setFamilyManager(FamilyManager familyManager) {
        this.familyManager = familyManager;
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
    
    public Family getFamily() {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//        for (Map.Entry pairs : params.entrySet()) {
//            log.debug(pairs.getKey() + " = " + pairs.getValue());
//        }
        log.debug("getting family, id is: " + id + " | " + family.getFamilyID());
//        if (family == null) {
//            family = familyManager.getFamily(id);
//        }
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String add() {
        family = new Family();
        DateTime now = new DateTime();
        family.setLastModified(now.toDate());
        return "editFamily";
    }

    public String edit() {
        log.debug("getting family, id is: " + id);
        family = familyManager.getFamily(Integer.parseInt(id));
        return "editFamily";
    }

    public String save() throws IOException {

        log.debug("getting family, id is: " + id + " | " + family.getFamilyID());

        try {
            familyManager.saveFamily(family);
            // add success messages
            addMessage("family.saved");
        } catch (NonexistentEntityException e) {
            addError("errors.update.family");
            log.error("NonexistentEntityException: " + e.getMessage());
        }

        log.debug("Exit after saved...");

        return "list";
    }

    public String delete() {

        familyManager.removeFamily(family.getFamilyID());
        addMessage("family.deleted", getFamily().getFamilyID());

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
