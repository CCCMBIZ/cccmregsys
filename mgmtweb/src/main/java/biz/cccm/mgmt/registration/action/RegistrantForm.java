package biz.cccm.mgmt.registration.action;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Payment;
import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.service.PaymentManager;
import biz.cccm.mgmt.registration.service.RegistrantManager;
import biz.cccm.webapp.action.BasePage;

/**
 * JSF Page class to handle editing a user with a form.
 *
 * @author mraible
 */
public class RegistrantForm extends BasePage implements Serializable {

    private static final long serialVersionUID = -1141119853856863205L;
    private RegistrantManager registrantManager;
    private PaymentManager paymentManager;
    private String id;
    private Registrant registrant = new Registrant();
    private Payment[] payments;
//    private String[] keyPaths;

    public void setId(String id) {
        this.id = id;
    }

    public void setRegistrantManager(RegistrantManager registrantManager) {
        this.registrantManager = registrantManager;
    }

    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public Registrant getRegistrant() {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//        for (Map.Entry pairs : params.entrySet()) {
//            log.debug(pairs.getKey() + " = " + pairs.getValue());
//        }
//        log.debug("getting registrant, id is: " + id + " | " + registrant.getPersonID());
//        if (registrant == null) {
//            registrant = registrantManager.getRegistrant(id);
//        }
        return registrant;
    }

    public void setRegistrant(Registrant registrant) {
        this.registrant = registrant;
    }

    public String add() {
        registrant = new Registrant();
        DateTime now = new DateTime();
        registrant.setLastModified(now.toDate());
        return "editRegistrant";
    }

    public String edit() {
        log.debug("getting registrant, id is: " + id);
        registrant = registrantManager.getRegistrant(Integer.parseInt(id));

        return "editRegistrant";
    }

    public String save() throws IOException {

        log.debug("getting registrant, id is: " + id + " | " + registrant.getPersonID());
        log.debug("First Name:" + registrant.getFirstName());

//        try {
        for (Payment payment : payments) {
            log.debug("[id:" + payment.getId() + "] [amount:" + payment.getAmount() + "]");
        }
            // add success messages
            addMessage("registrant.saved");
//        } catch (NonexistentEntityException e) {
//            addError("errors.update.registrant");
//            log.error("NonexistentEntityException: " + e.getMessage());
//        }

        log.debug("Exit after saved...");

        return "list";
    }

    public String delete() {

//        registrantManager.removeRegistrant(registrant.getPersonID());
        addMessage("registrant.deleted", getRegistrant().getFirstName() + " " + getRegistrant().getChineseName());

        return "home";
    }

    public String cancel() {
//        if (log.isDebugEnabled()) {
//            log.debug("Entering 'cancel' method");
//        }
//
//        if (!"list".equals(getParameter("from"))) {
//            return "home";
//        } else {
            return "list";
//        }
    }

    public Payment[] getPayments() {

        List<Payment> paymentList = new ArrayList();

        try {
            if (this.registrant != null && !this.registrant.getRegistrationID().isEmpty()) {
                paymentList = paymentManager.getPaymentsByRegistrationID(Long.valueOf(this.registrant.getFamilyID()));

                payments = new Payment[paymentList.size()];

                int i = 0;

                if (payments.length > 0) {
                    for (Payment payment : paymentList) {
                        payments[i] = payment;
                        i++;
                    }
                }
            }
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(RegistrantForm.class.getName()).log(Level.SEVERE, null, ex);
            log.error("NonexistentEntityException:" + ex.getMessage());
        } catch (NullPointerException ex) {
            log.error("NullPointerException:" + ex.getMessage());
        }

        return payments;
    }
//    public String getPayloadXml() {
//        
//        if (payload == null) {
//            return "";
//            
//        }
//        try {
//            return new String(payload.getPayload(),"UTF-8");
//        } catch (UnsupportedEncodingException ex) {
//            log.error(ex);
//            return new String(payload.getPayload());
//        }
//    }
//    
//    public String getPayloads() {
//
//        List<AuditPayloads> list;
//        list = null;
//
//        if (messageId != null) {
//            log.debug("displaying payload, id is: " + messageId);
//            // lookup the payload using that message id
//            list = payloadManager.getAuditPayload(messageId);
//
//            if (!list.isEmpty()) {
//                payload = list.get(0);
////                AuditPayloads audit = list.get(0);
////                payload = new String(audit.getPayload());
////                log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + payload + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//            } else {
////                payload = "No payload avalable";
//                payload = null;
//            }
//        }
//
//        FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//        for (Map.Entry pairs : params.entrySet()) {
//            log.debug(pairs.getKey() + " = " + pairs.getValue());
//        }
//        return "payloads";
////    }
//
//    /**
//     * @return the keys
//     */
//    public OperationKeyPath[] getOperationKeyPath() {
//
//        if (registrant != null) {
//            operationKeyPath = new OperationKeyPath[registrant.getKeysCollection().size()];
//        } else {
//            operationKeyPath = new OperationKeyPath[0];
//        }
//
//        int i = 0;
//
//        if (operationKeyPath.length > 0) {
//            for (Keys key : registrant.getKeysCollection()) {
//                operationKeyPath[i] = new OperationKeyPath();
//                operationKeyPath[i].setKeyId(key.getKeyId());
//                operationKeyPath[i].setKeyName(key.getKeyName());
//                operationKeyPath[i].setKeyPath(key.getKeyXpath());
//                operationKeyPath[i].setOperationId(key.getOperationId().getOperationId());
//                operationKeyPath[i].setOperationName(key.getOperationId().getOperationName());
//                i++;
//            }
//        }
//
//        return operationKeyPath;
//    }
//
//    /**
//     * @param operationKeyPath
//     */
//    public void setOperatonKeyPath(OperationKeyPath[] operationKeyPath) {
//        this.operationKeyPath = operationKeyPath;
//    }
//
//    /**
//     * @return the keyPaths
//     */
//    public String[] getKeyPaths() {
//
//        keyPaths = new String[registrant.getKeysCollection().size()];
//
//        int i = 0;
//
//        if (keyPaths.length > 0) {
//            for (Keys key : registrant.getKeysCollection()) {
//                keyPaths[i] = key.getKeyXpath();
//                i++;
//            }
//        }
//
//        log.debug("keypath size: " + keyPaths.length + " | keyCollection size: " + registrant.getKeysCollection().size());
//
//        return keyPaths;
//    }
//
//    /**
//     * @param keyPaths the keyPaths to set
//     */
//    public void setKeyPaths(String[] keyPaths) {
//        this.keyPaths = keyPaths;
//    }
}
