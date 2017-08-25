package biz.cccm.registration.validator;

import biz.cccm.registration.domain.PaymentMethod;
import biz.cccm.registration.domain.RegistrationForm;
import biz.cccm.registration.domain.LabelValue;
import biz.cccm.registration.domain.Registrant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class FormValidator {

    private static final Logger logger = Logger.getLogger(FormValidator.class);

    public void validateReview(RegistrationForm form, ValidationContext context) {

        MessageContext messages = context.getMessageContext();

        /**
         * the following code is commented out for issue83 if
         * (!form.getChkPmt()) { messages.addMessage(new
         * MessageBuilder().error().source("chkPmt").
         * code("paymentAuth").build()); }
         */
        if (form.getPaymentMethod() != PaymentMethod.CREDIT_CARD && form.getPaymentMethod() != PaymentMethod.PERSONAL_CHECK) {
            messages.addMessage(new MessageBuilder().error().source("paymentMethod").
                    code("paymentOption").build());
        }

        logger.debug("Validate review1 state..[" + form.getPaymentMethod() + "]");

    }

    public void validateStep1(RegistrationForm form, ValidationContext context) {
        logger.debug("Validate start state...");

        MessageContext messages = context.getMessageContext();
        if (form.getChurchID() <= 0L) {
            messages.addMessage(new MessageBuilder().error().source("churchID").
                    code("churchID").build());
        }
//        if (((form.getChurchName() != null && form.getChurchName().isEmpty())
//                || (form.getCoordinator() != null && form.getCoordinator().isEmpty()))) {
//            messages.addMessage(new MessageBuilder().error().source("churchName").
//                    defaultText("Please enter coordinator email address").build());
//        } else if ((form.getChurchName().trim().compareTo(form.getCoordinator().trim()) != 0)) {
//            messages.addMessage(new MessageBuilder().error().source("coordinator").
//                    defaultText("Coordinator email addresses does not match").build());
//        }

        logger.debug("Exit start state...[" + form.getChurchName() + "|" + form.getCoordinator() + "]");
    }

    public void validateStep2(RegistrationForm form, ValidationContext context) {

        MessageContext messages = context.getMessageContext();

        if (form.getAddress().getHomeAddress().trim().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().source("address.homeAddress").
                    code("homeAddress").build());
        }

        if (form.getAddress().getHomeCity().trim().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().source("address.homeCity").
                    code("homeCity").build());
        }

//        if (form.getAddress().getUcCountry().trim().isEmpty()) {
//            messages.addMessage(new MessageBuilder().error().source("address.ucCountry").
//                    code("homeCountry").build());
//        } else {
//            String countrySelected = form.getAddress().getUcCountry().trim();
//            if (!countrySelected.equals("OC")) {  //US or Canada
//                if (form.getAddress().getUcState().trim().isEmpty()) {
//                    messages.addMessage(new MessageBuilder().error().source("address.ucState").
//                            code("homeState").build());
//                } else {
//
//                    form.getAddress().setCountry(countrySelected);
//                    form.getAddress().setHomeState(form.getAddress().getUcState().trim());
//                }
//                if (countrySelected.equals("CA")) {  //if CA, then initialize the select drop down list
//                    List<LabelValue> stateList = new ArrayList<LabelValue>();
//
//                    stateList.add(new LabelValue("Alberta", "AB"));
//                    stateList.add(new LabelValue("British Columbia", "BC"));
//                    stateList.add(new LabelValue("Manitoba", "MB"));
//                    stateList.add(new LabelValue("New Brunswick", "NB"));
//
//                    stateList.add(new LabelValue("Newfoundland and Labrador", "NL"));
//                    stateList.add(new LabelValue("Nova Scotia", "NS"));
//                    stateList.add(new LabelValue("Northwest Territories", "NT"));
//                    stateList.add(new LabelValue("Nunavut", "NU"));
//
//                    stateList.add(new LabelValue("Ontario", "ON"));
//                    stateList.add(new LabelValue("rince Edward Island", "PE"));
//                    stateList.add(new LabelValue("Quebec", "QC"));
//                    stateList.add(new LabelValue("Saskatchewan", "SK"));
//
//                    stateList.add(new LabelValue("Yukon", "YT"));
//
//                    form.setStateList(stateList);
//                } else if (countrySelected.equals("US")) {
//                    List<LabelValue> stateList = new ArrayList<LabelValue>();
//
//                    stateList.add(new LabelValue("Alabama", "AL"));
//                    stateList.add(new LabelValue("Alaska", "AK"));
//                    stateList.add(new LabelValue("Arizona", "AZ"));
//                    stateList.add(new LabelValue("Arkansas", "AR"));
//
//                    stateList.add(new LabelValue("California", "CA"));
//                    stateList.add(new LabelValue("Colorado", "CO"));
//                    stateList.add(new LabelValue("Connecticut", "CT"));
//
//                    stateList.add(new LabelValue("Delaware", "DE"));
//                    stateList.add(new LabelValue("Florida", "FL"));
//                    stateList.add(new LabelValue("Georgia", "GA"));
//                    stateList.add(new LabelValue("Hawaii", "HI"));
//
//                    stateList.add(new LabelValue("Idaho", "ID"));
//                    stateList.add(new LabelValue("Illinois", "IL"));
//                    stateList.add(new LabelValue("Indiana", "IN"));
//                    stateList.add(new LabelValue("Iowa", "IA"));
//
//                    stateList.add(new LabelValue("Kansas", "KS"));
//                    stateList.add(new LabelValue("Kentucky", "KY"));
//                    stateList.add(new LabelValue("Louisiana", "LA"));
//
//                    stateList.add(new LabelValue("Maine", "ME"));
//                    stateList.add(new LabelValue("Maryland", "MD"));
//                    stateList.add(new LabelValue("Massachusetts", "MA"));
//                    stateList.add(new LabelValue("Michigan", "MI"));
//                    stateList.add(new LabelValue("Minnesota", "MN"));
//                    stateList.add(new LabelValue("Mississippi", "MS"));
//                    stateList.add(new LabelValue("Missouri", "MO"));
//                    stateList.add(new LabelValue("Montana", "MT"));
//
//                    stateList.add(new LabelValue("Nebraska", "NE"));
//                    stateList.add(new LabelValue("Nevada", "NV"));
//                    stateList.add(new LabelValue("New Hampshire", "NH"));
//                    stateList.add(new LabelValue("New Jersey", "NJ"));
//                    stateList.add(new LabelValue("New Mexico", "NM"));
//                    stateList.add(new LabelValue("New York", "NY"));
//                    stateList.add(new LabelValue("North Carolina", "NC"));
//                    stateList.add(new LabelValue("North Dakota", "ND"));
//
//                    stateList.add(new LabelValue("Ohio", "OH"));
//                    stateList.add(new LabelValue("Oklahoma", "OK"));
//                    stateList.add(new LabelValue("Oregon", "OR"));
//
//                    stateList.add(new LabelValue("Pennsylvania", "PA"));
//                    stateList.add(new LabelValue("Rhode Island", "RI"));
//                    stateList.add(new LabelValue("South Carolina", "SC"));
//                    stateList.add(new LabelValue("South Dakota", "SD"));
//                    stateList.add(new LabelValue("Tennessee", "TN"));
//                    stateList.add(new LabelValue("Texas", "TX"));
//
//                    stateList.add(new LabelValue("Utah", "UT"));
//                    stateList.add(new LabelValue("Vermont", "VT"));
//                    stateList.add(new LabelValue("Virginia", "VA"));
//                    stateList.add(new LabelValue("Washington", "WA"));
//                    stateList.add(new LabelValue("West Virginia", "WV"));
//                    stateList.add(new LabelValue("Wisconsin", "WI"));
//                    stateList.add(new LabelValue("Wyoming", "WY"));
//
//                    form.setStateList(stateList);
//
//                }
//            } else { //other country
//                if (form.getAddress().getOtherCountry().trim().isEmpty()) {
//                    messages.addMessage(new MessageBuilder().error().source("address.otherCountry").
//                            code("homeCountry").build());
//                }
//
//                if (form.getAddress().getOtherState().trim().isEmpty()) {
//                    messages.addMessage(new MessageBuilder().error().source("address.otherState").
//                            code("homeState").build());
//                } else {
//                    form.getAddress().setCountry(form.getAddress().getOtherCountry().trim());
//                    form.getAddress().setHomeState(form.getAddress().getOtherState().trim());
//                }
//            }
//        }
        if (form.getAddress().getHomeState().trim().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().source("address.homeState").
                    code("homeState").build());
        }

        if (form.getAddress().getHomeZip().trim().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().source("address.homeZip").
                    code("homeZipCode").build());
//        } else {
//            if (!form.getAddress().getUcCountry().trim().isEmpty()) {
//
//                if (form.getAddress().getUcCountry().trim().equals("CA")) {
//                    // validate zipcode for CA,  which should be length of 6 or 7
//                    String caZip = form.getAddress().getHomeZip().trim();
//
//                    if (caZip.length() != 6 && caZip.length() != 7) {
//                        messages.addMessage(new MessageBuilder().error().source("address.homeZip").
//                                code("validZipCode").build());
//                    }
//                } else if (form.getAddress().getUcCountry().trim().equals("US")) {
//                    // zipcode for US should be numeric.
//                    String zip = form.getAddress().getHomeZip().trim();
//                    zip = zip.replaceAll("[\\-]", "");
//                    if (!zip.matches("[0-9]+")) {
//                        messages.addMessage(new MessageBuilder().error().source("address.homeZip").
//                                code("validZipCode").build());
//                    }
//                }
//            }
        }
//
        if (form.getRegistrants().get(0).getPerson().getFirstName().trim().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().source("primaryFirstName").
                    code("primaryFirstName").build());
        }

        if (form.getRegistrants().get(0).getPerson().getLastName().trim().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().source("primaryLastName").
                    code("primaryLastName").build());
        }

        if (form.getAddress().getHomePhone().trim().isEmpty()) {
            messages.addMessage(new MessageBuilder().error().source("address.homePhone").
                    code("homePhone").build());
        } else {
            String phone = form.getAddress().getHomePhone().trim();
            phone = phone.replaceAll("[\\-]", "");
            if (!phone.matches("[0-9]+")) {
                messages.addMessage(new MessageBuilder().error().source("address.homePhone").
                        code("validHomePhone").build());
            }
        }

        String email1 = form.getAddress().getMisc1().trim();
        String email2 = form.getAddress().getMisc2().trim();
        if (email1.isEmpty() || !email1.contains("@")) {
            messages.addMessage(new MessageBuilder().error().source("address.misc1").
                    code("validEmail").build());
        } else {
            if (email2.isEmpty() || !email2.contains("@")) {
                messages.addMessage(new MessageBuilder().error().source("address.misc2").
                        code("validConfirmEmail").build());
            } else {
                if (!email1.equalsIgnoreCase(email2)) {
                    messages.addMessage(new MessageBuilder().error().source("address.misc1").
                            code("identicalEmail").build());

                }
            }
        }

        logger.debug("Validate step1 state..[" + form.getAddress() + "]");

    }

    public void validateStep3(RegistrationForm form, ValidationContext context) {

        MessageContext messages = context.getMessageContext();

        int count = 0;
        for (Registrant registrant : form.getRegistrants()) {

            if (registrant.getPerson().getFirstName() == null || registrant.getPerson().getFirstName().isEmpty()) {
                messages.addMessage(new MessageBuilder().error().source("registrants[" + count + "].person.firstName").
                        code("personFirstName").build());
            }
            if (registrant.getPerson().getLastName() == null || registrant.getPerson().getLastName().isEmpty()) {
                messages.addMessage(new MessageBuilder().error().source("registrants[" + count + "].person.lastName").
                        code("personLastName").build());
            }
            if (registrant.getPerson().getGender() == null || registrant.getPerson().getGender().isEmpty()) {
                messages.addMessage(new MessageBuilder().error().source("registrants[" + count + "].person.gender").
                        code("personGender").build());
            }
            if (registrant.getPerson().getAge() == null || registrant.getPerson().getAge().isEmpty()) {
                messages.addMessage(new MessageBuilder().error().source("registrants[" + count + "].person.age").
                        code("personAge").build());
            }
            if (registrant.getPerson().getPreferredLanguage() == null || registrant.getPerson().getPreferredLanguage().isEmpty()) {
                messages.addMessage(new MessageBuilder().error().source("registrants[" + count + "].person.preferredLanguage").
                        code("personPreferredLanguage").build());
            }
            if (registrant.getPerson().getStatus() == null || registrant.getPerson().getStatus().isEmpty()) {
                messages.addMessage(new MessageBuilder().error().source("registrants[" + count + "].person.status").
                        code("personStatus").build());
            }
            if (registrant.getPerson().getAcceptedChrist() == null) {
                messages.addMessage(new MessageBuilder().error().source("registrants[" + count + "].person.acceptedChrist").
                        code("personFaith").build());
            } else if (registrant.getPerson().getAcceptedChrist() != null && registrant.getPerson().getAcceptedChrist() == true) {
                if (registrant.getPerson().getMisc1() == null) {
                    messages.addMessage(new MessageBuilder().error().source("registrants[" + count + "].person.misc1").
                            code("personFaithYear").build());
                } else if (!isNumeric(registrant.getPerson().getMisc1())) {
                    messages.addMessage(new MessageBuilder().error().source("registrants[" + count + "].person.misc1").
                            code("personFaithYearNumber").build());
                }
            }
            count++;
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
