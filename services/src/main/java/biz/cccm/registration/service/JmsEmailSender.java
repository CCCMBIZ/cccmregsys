/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.service;

import java.util.Map;

import javax.mail.MessagingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;

//import org.springframework.jms.core.JmsTemplate;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Class for sending e-mail messages based on Velocity templates
 * or with attachments.
 *
 * @author Matt Raible
 */
public class JmsEmailSender {

    private final Log logger = LogFactory.getLog(JmsEmailSender.class);

    private VelocityEngine velocityEngine;
//    private JmsEmailMessageCreator messageCreator;
//    private JmsTemplate emailJmsTemplate = null;

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

//    /**
//     * Send a simple message based on a Velocity template.
//     * @param msg the message to populate
//     * @param templateName the Velocity template to use (relative to classpath)
//     * @param model a map containing key/value pairs
//     */
//    public void sendMessage(SimpleMailMessage msg, String templateName, Map model) {
//        String result = null;
//
//        try {
//            result =
//                    VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
//                    templateName, model);
//        } catch (VelocityException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//        }
//
//        msg.setText(result);
//        send(msg);
//    }



    public void sendMessage(String[] recipients, String templateName, Map model)
            throws MessagingException {

        String result = null;

        try {
            result =
                    VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                    templateName, model);
        } catch (VelocityException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

//        messageCreator.setBody(result);
//        logger.debug("Recipients:" + recipients[0]);
//        messageCreator.setRecipients(recipients);
//
//        emailJmsTemplate.send(messageCreator);

    }

//    /**
//     * @param emailJmsTemplate the emailJmsTemplate to set
//     */
//    public void setEmailJmsTemplate(JmsTemplate emailJmsTemplate) {
//        this.emailJmsTemplate = emailJmsTemplate;
//    }
//
//    /**
//     * @param messageCreator the messageCreator to set
//     */
//    public void setMessageCreator(JmsEmailMessageCreator messageCreator) {
//        this.messageCreator = messageCreator;
//    }
}
