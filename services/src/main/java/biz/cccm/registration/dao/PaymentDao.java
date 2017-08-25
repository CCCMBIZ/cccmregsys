/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.dao;

import java.util.List;
import biz.cccm.registration.model.Payment;

/**
 *
 * @author ch1choo1
 */
/**
 * @author CH1JMOH2
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public interface PaymentDao {

    public Payment findById(long id);

    public Payment update(Payment obj);

    public void delete(long obj);

    public void save(Payment obj);

    List<Payment> findPaymentByQuery(String query);
}
