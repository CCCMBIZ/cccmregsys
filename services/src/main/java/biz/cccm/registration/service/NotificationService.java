/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biz.cccm.registration.service;

import java.util.HashMap;

/**
 *
 * @author CH1CHOO1
 */
public interface NotificationService {
//    public boolean sendPaymentConfirmationWithEmail(Object payment, String template);
    public boolean sendConfirmationEmail(String familyId, String templateName, HashMap<String, String> params);
//    public boolean sendConsentFormWithEmail(Object consent, String template);
}
