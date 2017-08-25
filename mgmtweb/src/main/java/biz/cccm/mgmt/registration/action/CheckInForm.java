package biz.cccm.mgmt.registration.action;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Profile;
import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.service.ProfileManager;
import biz.cccm.mgmt.registration.service.RegistrantManager;
import biz.cccm.webapp.action.BasePage;

public class CheckInForm extends BasePage implements Serializable {

    private static final long serialVersionUID = 972359310603744041L;
    protected ProfileManager profileManager;
    protected RegistrantManager registrantManager;
    private Registrant registrant;
    private String statusText;
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

    public void setRegistrantManager(RegistrantManager registrantManager) {
        this.registrantManager = registrantManager;
    }

    public CheckInForm() {
    }

    public Registrant getRegistrant() {
        return this.registrant;
    }

    public String enter() {

        statusText = "";

        if (query != null && !query.isEmpty()) {
            Integer personID = 0;

            try {

                personID = Integer.parseInt(query);

                registrant = registrantManager.getRegistrantByPersonID(personID);

                if (registrant != null) {

                    Profile profile;

                    profile = profileManager.getProfile(personID);
                    profile.setCheckIn(true);
                    profile.setCheckInDate(new Date());

                    profileManager.saveProfile(profile);

                    statusText = registrant.getChineseName() + " " + registrant.getFirstName() + " " + registrant.getLastName() + " check in on " + profile.getCheckInDate() ;
     
                }

            } catch (NonexistentEntityException ex) {
                addError("Person ID " + personID + " Not exist in system.");
            } catch (NumberFormatException ex) {
                addError("Not a valid person ID");
            } finally {
                query = "";
            }
        }
        return "success";
    }

    /**
     * @return the profile
     */
    public String getStatusText() {
        return statusText;
    }
}
