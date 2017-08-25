package biz.cccm.mgmt.registration.action;

import java.io.Serializable;
import java.util.List;
import biz.cccm.dao.SearchException;
import biz.cccm.mgmt.registration.service.PaymentManager;
import biz.cccm.webapp.action.BasePage;

public class PaymentList extends BasePage implements Serializable {

    private static final long serialVersionUID = 972359310602744030L;
    protected PaymentManager paymentManager;
    private String query;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
    
    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public PaymentList() {
        setSortColumn("id");
    }

    public List getPayments() {
       
        try {
            return sort(paymentManager.search(query));
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(paymentManager.search(query));
        }
    }

    public String search() {
        return "success";
    }
}
