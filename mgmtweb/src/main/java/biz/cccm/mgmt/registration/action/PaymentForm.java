package biz.cccm.mgmt.registration.action;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import biz.cccm.mgmt.registration.dao.exceptions.NonexistentEntityException;
import biz.cccm.mgmt.registration.model.Payment;
import biz.cccm.mgmt.registration.service.PaymentManager;
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
public class PaymentForm extends BasePage implements Serializable {

    private static final long serialVersionUID = -1141119853856863205L;
    private PaymentManager paymentManager;
    private String id;
    private Payment payment = new Payment();

    public void setId(String id) {
        this.id = id;
    }

    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
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
    
    public Payment getPayment() {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//        for (Map.Entry pairs : params.entrySet()) {
//            log.debug(pairs.getKey() + " = " + pairs.getValue());
//        }
        log.debug("getting payment, id is: " + id + " | " + payment.getId());
//        if (payment == null) {
//            payment = paymentManager.getPayment(id);
//        }
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String add() {
        payment = new Payment();
        DateTime now = new DateTime();
        payment.setPaymentDate(now.toDate());
        return "editPayment";
    }

    public String edit() {
        log.debug("getting payment, id is: " + id);
        payment = paymentManager.getPayment(Long.parseLong(id));
        return "editPayment";
    }

    public String save() throws IOException {

        log.debug("getting payment, id is: " + id + " | " + payment.getId());

        try {
            paymentManager.savePayment(payment);
            // add success messages
            addMessage("payment.saved");
        } catch (NonexistentEntityException e) {
            addError("errors.update.payment");
            log.error("NonexistentEntityException: " + e.getMessage());
        }

        log.debug("Exit after saved...");

        return "list";
    }

    public String delete() {

        paymentManager.removePayment(payment.getId());
        addMessage("payment.deleted", getPayment().getRegistrationID());

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
