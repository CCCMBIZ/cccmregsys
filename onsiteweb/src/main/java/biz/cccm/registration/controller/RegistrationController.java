/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.controller;

import biz.cccm.registration.domain.Expense;
import biz.cccm.registration.domain.Fee;
import biz.cccm.registration.domain.LabelValue;
import biz.cccm.registration.domain.PaymentMethod;
import biz.cccm.registration.domain.PaymentProvider;
import biz.cccm.registration.domain.Registrant;
import biz.cccm.registration.domain.RegistrationForm;
import biz.cccm.registration.domain.Seminar;
import biz.cccm.registration.model.Church;
import biz.cccm.registration.model.Event;
import biz.cccm.registration.model.Mealplan;
import biz.cccm.registration.model.Person;
import biz.cccm.registration.service.RegistrationService;
import biz.cccm.registration.util.DateUtil;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.execution.RequestContext;

/**
 *
 * @author Ephesus
 */
@Component
public class RegistrationController {

    private static final Logger logger = Logger.getLogger(RegistrationController.class);

    @Autowired
    @Resource(name = "feeMap")
    private Map<String, String> feeMap;

    @Autowired
    private RegistrationService registrationService;
    @Resource(name = "paymentProviderMap")
    private Map<String, PaymentProvider> paymentProviderMap;

    public RegistrationForm initializeForm() {

        logger.info("initialize Form  entering");

        RegistrationForm registrationForm = new RegistrationForm();

        Event event = new Event();
        event.setName("Chicago Chinese Christian Conference & GRACE Conference 2016");
        event.setContactEmail("registration@cccm.ws");
        registrationForm.setEvent(event);

        Date today = new Date();
        // Setup Form ID (Registration ID)
        String generatedId = DateUtil.getDateTime("MMddHHmmss", today);
        logger.debug("Generated Form ID  =" + generatedId);
        registrationForm.setFormID(Long.valueOf(generatedId));

        List<LabelValue> ageGroup;
        ageGroup = new ArrayList<LabelValue>();

        ageGroup.add(new LabelValue("60+", "A6"));
        ageGroup.add(new LabelValue("50-59", "A5"));
        ageGroup.add(new LabelValue("40-49", "A4"));
        ageGroup.add(new LabelValue("30-39", "A3"));
        ageGroup.add(new LabelValue("18-29", "A2"));

        ageGroup.add(new LabelValue("17", "17"));
        ageGroup.add(new LabelValue("16", "16"));
        ageGroup.add(new LabelValue("15", "15"));
        ageGroup.add(new LabelValue("14", "14"));
        ageGroup.add(new LabelValue("13", "13"));
        ageGroup.add(new LabelValue("12", "12"));
        ageGroup.add(new LabelValue("11", "11"));
        ageGroup.add(new LabelValue("10", "10"));
        ageGroup.add(new LabelValue("9", "9"));
        ageGroup.add(new LabelValue("8", "8"));
        ageGroup.add(new LabelValue("7", "7"));
        ageGroup.add(new LabelValue("6", "6"));
        ageGroup.add(new LabelValue("5", "5"));
        ageGroup.add(new LabelValue("4", "4"));
        ageGroup.add(new LabelValue("3", "3"));
        ageGroup.add(new LabelValue("2", "2"));
        ageGroup.add(new LabelValue("1", "1"));
        ageGroup.add(new LabelValue("0", "0"));

        registrationForm.setAgeGroup(ageGroup);

        List<LabelValue> months;
        months = new ArrayList<LabelValue>();

        months.add(new LabelValue("January", "01"));
        months.add(new LabelValue("February", "02"));
        months.add(new LabelValue("March", "03"));
        months.add(new LabelValue("April", "04"));
        months.add(new LabelValue("May", "05"));
        months.add(new LabelValue("June", "06"));
        months.add(new LabelValue("July", "07"));
        months.add(new LabelValue("August", "08"));
        months.add(new LabelValue("September", "09"));
        months.add(new LabelValue("October", "10"));
        months.add(new LabelValue("November", "11"));
        months.add(new LabelValue("December", "12"));

//        registrationForm.setMonths(months);
        List<LabelValue> days;
        days = new ArrayList<LabelValue>();
        days.add(new LabelValue("1", "01"));
        days.add(new LabelValue("2", "02"));
        days.add(new LabelValue("3", "03"));
        days.add(new LabelValue("4", "04"));
        days.add(new LabelValue("5", "05"));
        days.add(new LabelValue("6", "06"));
        days.add(new LabelValue("7", "07"));
        days.add(new LabelValue("8", "08"));
        days.add(new LabelValue("9", "09"));
        days.add(new LabelValue("10", "10"));
        days.add(new LabelValue("11", "11"));
        days.add(new LabelValue("12", "12"));
        days.add(new LabelValue("13", "13"));
        days.add(new LabelValue("14", "14"));
        days.add(new LabelValue("15", "15"));
        days.add(new LabelValue("16", "16"));
        days.add(new LabelValue("17", "17"));
        days.add(new LabelValue("18", "18"));
        days.add(new LabelValue("19", "19"));
        days.add(new LabelValue("20", "20"));
        days.add(new LabelValue("21", "21"));
        days.add(new LabelValue("22", "22"));
        days.add(new LabelValue("23", "23"));
        days.add(new LabelValue("24", "24"));
        days.add(new LabelValue("25", "25"));
        days.add(new LabelValue("26", "26"));
        days.add(new LabelValue("27", "27"));
        days.add(new LabelValue("28", "28"));
        days.add(new LabelValue("29", "29"));
        days.add(new LabelValue("30", "30"));
        days.add(new LabelValue("31", "31"));

//        f.setDayOfMonth(days);
        List<LabelValue> relationshipGroup;
        relationshipGroup = new ArrayList<LabelValue>();

        relationshipGroup.add(new LabelValue("H(\u592B)", "H")); // H(?)
        relationshipGroup.add(new LabelValue("W(\u59BB)", "W")); // W(?)
        relationshipGroup.add(new LabelValue("S(\u5B50)", "S")); // S(?)
        relationshipGroup.add(new LabelValue("D(\u5973)", "D")); // D(?) 
        relationshipGroup.add(new LabelValue("F(\u7236)", "F")); // F(?)
        relationshipGroup.add(new LabelValue("M(\u6BCD)", "M")); // M(?)
        relationshipGroup.add(new LabelValue("B(\u5144\u5F1F)", "B")); // B(??)
        relationshipGroup.add(new LabelValue("T(\u59CA\u59B9)", "T")); // T(??)
        relationshipGroup.add(new LabelValue("C(\u540C\u5B66)", "C")); // C(??)
        relationshipGroup.add(new LabelValue("O(\u540C\u4E8B)", "O")); // O(??)

        registrationForm.setRelationshipGroup(relationshipGroup);

        List<LabelValue> statusGroup;
        statusGroup = new ArrayList<LabelValue>();

        statusGroup.add(new LabelValue("F(\u5168\u8077\u50B3\u9053)", "F"));
        statusGroup.add(new LabelValue("P(\u6559\u6703\u7267\u8005)", "P"));
        statusGroup.add(new LabelValue("T(\u795E\u5B78\u751F)", "T"));
        statusGroup.add(new LabelValue("N(\u6A5F\u69CB\u540C\u5DE5)", "N"));
        statusGroup.add(new LabelValue("C(\u6821\u5712\u540C\u5DE5)", "C"));
        statusGroup.add(new LabelValue("E(\u6559\u6703\u9577\u57F7)", "E"));
        statusGroup.add(new LabelValue("S(\u5C0F\u7D44\u6216\u5718\u5951\u540C\u5DE5)", "S"));
        statusGroup.add(new LabelValue("O(\u5176\u4ED6)", "O"));
        statusGroup.add(new LabelValue("-- Status(English Conf) --", ""));
        statusGroup.add(new LabelValue("Married", "M"));
        statusGroup.add(new LabelValue("Engaged", "EN"));
        statusGroup.add(new LabelValue("Single", "SG"));
        statusGroup.add(new LabelValue("Graduate School", "GS"));
        statusGroup.add(new LabelValue("Undergrad - Sr", "C4"));
        statusGroup.add(new LabelValue("Undergrad - Jr", "C3"));
        statusGroup.add(new LabelValue("Undergrad - So", "C2"));
        statusGroup.add(new LabelValue("Undergrad - Fr", "C1"));
        statusGroup.add(new LabelValue("Senior High - Sr", "12th"));
        statusGroup.add(new LabelValue("Senior High - Jr", "11th"));
        statusGroup.add(new LabelValue("Senior High - So", "10th"));
        statusGroup.add(new LabelValue("Senior High - Fr", "9th"));
        statusGroup.add(new LabelValue("Junior High - 8th grade", "8th"));
        statusGroup.add(new LabelValue("Junior High - 7th grade", "7th"));
        statusGroup.add(new LabelValue("Junior High - 6th grade", "6th"));
        statusGroup.add(new LabelValue("5th grade", "5th"));
        statusGroup.add(new LabelValue("4th grade", "4th"));
        statusGroup.add(new LabelValue("3rd grade", "3rd"));
        statusGroup.add(new LabelValue("2nd grade", "2nd"));
        statusGroup.add(new LabelValue("1st grade", "1st"));
        statusGroup.add(new LabelValue("Kindergarden", "K"));
        statusGroup.add(new LabelValue("Preschool 4yrs", "P4"));
        statusGroup.add(new LabelValue("Preschool 3yrs", "P3"));
        statusGroup.add(new LabelValue("Toddlers (age 1-2)", "TO"));
        statusGroup.add(new LabelValue("Baby < 1", "B"));
        statusGroup.add(new LabelValue("Other", "O"));
        registrationForm.setStatusGroup(statusGroup);

        List<LabelValue> statusGroup2;
        statusGroup2 = new ArrayList<LabelValue>();

        statusGroup2.add(new LabelValue("Married", "M"));
        statusGroup2.add(new LabelValue("Engaged", "EN"));
        statusGroup2.add(new LabelValue("Single", "SG"));
        statusGroup2.add(new LabelValue("Graduate School", "GS"));
        statusGroup2.add(new LabelValue("Undergrad - Sr", "C4"));
        statusGroup2.add(new LabelValue("Undergrad - Jr", "C3"));
        statusGroup2.add(new LabelValue("Undergrad - So", "C2"));
        statusGroup2.add(new LabelValue("Undergrad - Fr", "C1"));
        statusGroup2.add(new LabelValue("Senior High - Sr", "12th"));
        statusGroup2.add(new LabelValue("Senior High - Jr", "11th"));
        statusGroup2.add(new LabelValue("Senior High - So", "10th"));
        statusGroup2.add(new LabelValue("Senior High - Fr", "9th"));
        statusGroup2.add(new LabelValue("Junior High - 8th grade", "8th"));
        statusGroup2.add(new LabelValue("Junior High - 7th grade", "7th"));
        statusGroup2.add(new LabelValue("Junior High - 6th grade", "6th"));
        statusGroup2.add(new LabelValue("5th grade", "5th"));
        statusGroup2.add(new LabelValue("4th grade", "4th"));
        statusGroup2.add(new LabelValue("3rd grade", "3rd"));
        statusGroup2.add(new LabelValue("2nd grade", "2nd"));
        statusGroup2.add(new LabelValue("1st grade", "1st"));
        statusGroup2.add(new LabelValue("Kindergarden", "K"));
        statusGroup2.add(new LabelValue("Preschool 4yrs", "P4"));
        statusGroup2.add(new LabelValue("Preschool 3yrs", "P3"));
        statusGroup2.add(new LabelValue("Toddlers (age 1-2)", "TO"));
        statusGroup2.add(new LabelValue("Baby < 1", "B"));
        statusGroup2.add(new LabelValue("Other", "O"));

//        statusGroup2.add(new LabelValue("Married", "M"));
//        statusGroup2.add(new LabelValue("Engaged", "EN"));
//        statusGroup2.add(new LabelValue("Single", "S"));
//        statusGroup2.add(new LabelValue("Graduate School", "G"));
//        statusGroup2.add(new LabelValue("Undergrad   - Sr", "CS"));
//        statusGroup2.add(new LabelValue("Undergrad   - Jr", "CJ"));
//        statusGroup2.add(new LabelValue("Undergrad   - So", "CO"));
//        statusGroup2.add(new LabelValue("Undergrad   - Fr", "CF"));
//        statusGroup2.add(new LabelValue("Senior High - Sr", "SS"));
//        statusGroup2.add(new LabelValue("Senior High - Jr", "SJ"));
//        statusGroup2.add(new LabelValue("Senior High - So", "SO"));
//        statusGroup2.add(new LabelValue("Senior High - Fr", "SF"));
//        statusGroup2.add(new LabelValue("Junior High - 6th grade", "J6"));
//        statusGroup2.add(new LabelValue("Junior High - 7th grade", "J7"));
//        statusGroup2.add(new LabelValue("Junior High - 8th grade", "J8"));
//        statusGroup2.add(new LabelValue("Toddlers (age 0-3)", "TO"));
//        statusGroup2.add(new LabelValue("Elementary (K-5)", "EL"));
//        statusGroup2.add(new LabelValue("Other", "O"));
        registrationForm.setStatusGroup2(statusGroup2);

        List<LabelValue> stateList;
        stateList = new ArrayList<LabelValue>();

        stateList.add(new LabelValue("Illinois", "IL"));
        stateList.add(new LabelValue("Indiana", "IN"));
        stateList.add(new LabelValue("Wisconsin", "WI"));
        stateList.add(new LabelValue("Other", "OT"));
        stateList.add(new LabelValue("--------------", "ZZ"));
        stateList.add(new LabelValue("Alabama", "AL"));
        stateList.add(new LabelValue("Alaska", "AK"));
        stateList.add(new LabelValue("Alberta", "AB"));
        stateList.add(new LabelValue("American Samoa", "AS"));
        stateList.add(new LabelValue("Arizona", "AZ"));
        stateList.add(new LabelValue("Arkansas", "AR"));
//        stateList.add(new LabelValue("Armed Forces (AE)", "AE"));
//        stateList.add(new LabelValue("Armed Forces Americas", "AA"));
//        stateList.add(new LabelValue("Armed Forces Pacific", "AP"));
        stateList.add(new LabelValue("British Columbia", "BC"));
        stateList.add(new LabelValue("California", "CA"));
        stateList.add(new LabelValue("Colorado", "CO"));
        stateList.add(new LabelValue("Connecticut", "CT"));
        stateList.add(new LabelValue("Delaware", "DE"));
        stateList.add(new LabelValue("District Of Columbia", "DC"));
        stateList.add(new LabelValue("Florida", "FL"));
        stateList.add(new LabelValue("Georgia", "GA"));
        stateList.add(new LabelValue("Guam", "GU"));
        stateList.add(new LabelValue("Hawaii", "HI"));
        stateList.add(new LabelValue("Idaho", "ID"));
        stateList.add(new LabelValue("Illinois", "IL"));
        stateList.add(new LabelValue("Indiana", "IN"));
        stateList.add(new LabelValue("Iowa", "IA"));
        stateList.add(new LabelValue("Kansas", "KS"));
        stateList.add(new LabelValue("Kentucky", "KY"));
        stateList.add(new LabelValue("Louisiana", "LA"));
        stateList.add(new LabelValue("Maine", "ME"));
        stateList.add(new LabelValue("Manitoba", "MB"));
        stateList.add(new LabelValue("Maryland", "MD"));
        stateList.add(new LabelValue("Massachusetts", "MA"));
        stateList.add(new LabelValue("Michigan", "MI"));
        stateList.add(new LabelValue("Minnesota", "MN"));
        stateList.add(new LabelValue("Mississippi", "MS"));
        stateList.add(new LabelValue("Missouri", "MO"));
        stateList.add(new LabelValue("Montana", "MT"));
        stateList.add(new LabelValue("Nebraska", "NE"));
        stateList.add(new LabelValue("Nevada", "NV"));
        stateList.add(new LabelValue("New Brunswick", "NB"));
        stateList.add(new LabelValue("New Hampshire", "NH"));
        stateList.add(new LabelValue("New Jersey", "NJ"));
        stateList.add(new LabelValue("New Mexico", "NM"));
        stateList.add(new LabelValue("New York", "NY"));
//        stateList.add(new LabelValue("Newfoundland", "NF"));
        stateList.add(new LabelValue("North Carolina", "NC"));
        stateList.add(new LabelValue("North Dakota", "ND"));
//        stateList.add(new LabelValue("Northwest Territories", "NT"));
//        stateList.add(new LabelValue("Nova Scotia", "NS"));
//        stateList.add(new LabelValue("Nunavut", "NU"));
        stateList.add(new LabelValue("Ohio", "OH"));
        stateList.add(new LabelValue("Oklahoma", "OK"));
        stateList.add(new LabelValue("Ontario", "ON"));
        stateList.add(new LabelValue("Oregon", "OR"));
        stateList.add(new LabelValue("Pennsylvania", "PA"));
//        stateList.add(new LabelValue("Prince Edward Island", "PE"));
//        stateList.add(new LabelValue("Puerto Rico", "PR"));
//        stateList.add(new LabelValue("Quebec", "PQ"));
        stateList.add(new LabelValue("Rhode Island", "RI"));
//        stateList.add(new LabelValue("Saskatchewan", "SK"));
        stateList.add(new LabelValue("South Carolina", "SC"));
        stateList.add(new LabelValue("South Dakota", "SD"));
        stateList.add(new LabelValue("Tennessee", "TN"));
        stateList.add(new LabelValue("Texas", "TX"));
        stateList.add(new LabelValue("Utah", "UT"));
        stateList.add(new LabelValue("Vermont", "VT"));
        stateList.add(new LabelValue("Virgin Islands", "VI"));
        stateList.add(new LabelValue("Virginia", "VA"));
        stateList.add(new LabelValue("Washington", "WA"));
        stateList.add(new LabelValue("West Virginia", "WV"));
        stateList.add(new LabelValue("Wisconsin", "WI"));
        stateList.add(new LabelValue("Wyoming", "WY"));
//        stateList.add(new LabelValue("Yukon Territory", "YT"));

        registrationForm.setStateList(stateList);

        List<LabelValue> churchStateList;
        churchStateList = new ArrayList<LabelValue>();
        churchStateList.add(new LabelValue("Illinois", "IL"));
        churchStateList.add(new LabelValue("Indiana", "IN"));
        churchStateList.add(new LabelValue("Wisconsin", "WI"));
        churchStateList.add(new LabelValue("Other", "OT"));
        churchStateList.add(new LabelValue("--------------", "ZZ"));
        churchStateList.add(new LabelValue("California", "CA"));
        churchStateList.add(new LabelValue("Iowa", "IA"));
        churchStateList.add(new LabelValue("Kentucky", "KY"));
        churchStateList.add(new LabelValue("Michigan", "MI"));
        churchStateList.add(new LabelValue("Missouri", "MS"));
        churchStateList.add(new LabelValue("Minnesota", "MN"));
        churchStateList.add(new LabelValue("Pennsylvania", "PA"));
        churchStateList.add(new LabelValue("Tennessee", "TN"));
        churchStateList.add(new LabelValue("Texas", "TX"));
        churchStateList.add(new LabelValue("Ohio", "OH"));
        churchStateList.add(new LabelValue("North Carolina", "NC"));

        registrationForm.setChurchStateList(churchStateList);

        try {
            Date d = DateUtil.getToday().getTime();
            registrationForm.setRegistrationDate(d);
        } catch (ParseException ex) {
            logger.error("Error generating Registration ID");
        }
        /**
         * End of code for issue5.
         */
        List<Fee> fees;
        fees = new ArrayList<Fee>();

        for (Map.Entry<String, String> entry : feeMap.entrySet()) {
            logger.debug("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
            StringTokenizer st = new StringTokenizer(entry.getValue(), ",");
            int count = 0;
            Fee fee = new Fee();
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            while (st.hasMoreTokens()) {

                count++;

                switch (count) {
                    case 1:
                        fee.setEventID(st.nextToken());
                        logger.debug("event id:" + fee.getEventID());
                        break;
                    case 2:
                        DateTime dt = new DateTime(formatter.parseDateTime(st.nextToken()));
                        fee.setEffectiveDate(dt);
                        logger.debug("effective date:" + fee.getEffectiveDate());
                        break;
                    case 3:
                        DateTime dt0 = new DateTime(formatter.parseDateTime(st.nextToken()));
                        fee.setExpirationDate(dt0);
                        logger.debug("expiration date:" + fee.getExpirationDate());
                        break;
                    case 4:
                        fee.setAgeLevel(Integer.parseInt(st.nextToken()));
                        logger.debug("age level:" + fee.getAgeLevel());
                        break;
                    case 5:
                        fee.setPriority(Integer.parseInt(st.nextToken()));
                        logger.debug("priority:" + fee.getPriority());
                        break;
                    case 6:
                        fee.setCodeName(st.nextToken());
                        logger.debug("code name:" + fee.getCodeName());
                        break;
                    case 7:
                        fee.setDescription(st.nextToken());
                        logger.debug("description:" + fee.getDescription());
                        break;
                    case 8:
                        fee.setCurrency(st.nextToken());
                        logger.debug("currency:" + fee.getCurrency());
                        break;
                    case 9:
                        fee.setAmount(Double.valueOf(st.nextToken()));
                        logger.debug("amount:" + fee.getAmount());
                        break;
                }

            }
            fees.add(fee);
        }
        registrationForm.setFees(fees);
        registrationForm.setRegistrationDate(today);
        registrationForm.setPaymentMethod(PaymentMethod.WAIVED);

        // Add first registrant
        if (registrationForm.getRegistrants() != null) {

            Registrant registrant = new Registrant();
            Person person = new Person();
            registrant.setPerson(person);
            Seminar seminar = new Seminar();
            registrant.setSeminar(seminar);
            Mealplan mealPlan = new Mealplan();
            registrant.setMealplan(mealPlan);

            registrationForm.getRegistrants().add(registrant);
        }

        logger.info("initialize Form exiting");

        return registrationForm;
    }

    public Registrant createNewPerson(RegistrationForm form) {

        if (form.getRegistrants() == null) {
            ArrayList<Registrant> rlist = new ArrayList<Registrant>();
            form.setRegistrants(rlist);
        }

        Registrant registrant = new Registrant();
        Person person = new Person();
        //person.setFirstName("New");
        if (form.getRegistrants().isEmpty()) {
            person.setChineseName(form.getPrimaryChineseName());
            person.setFirstName(form.getPrimaryFirstName());
            person.setLastName(form.getPrimaryLastName());
            person.setPhone(form.getAddress().getHomePhone());
            person.setEmail(form.getAddress().getMisc1());
            person.setRelationship("A");
        }
        registrant.setPerson(person);
        Seminar seminar = new Seminar();
        registrant.setSeminar(seminar);
        Mealplan mealPlan = new Mealplan();
        registrant.setMealplan(mealPlan);

        form.getRegistrants().add(registrant);

        return registrant;
    }

    public Registrant removeNewPerson(RegistrationForm form) {
        return form.getRegistrants().remove((form.getRegistrants().size() - 1));
    }

    public Registrant editPerson(RegistrationForm form, LocalAttributeMap currentEvent) {

        logger.debug("Value:" + currentEvent);
        //Debug
        Map<String, String> map = currentEvent.asMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            logger.debug(entry.getKey() + "/" + entry.getValue());
        }

        String index = null;
        if (map.get("index") != null && isInteger(map.get("index"))) {
            index = map.get("index");
        } else if (map.get("_eventId_remove") != null && isInteger(map.get("_eventId_remove"))) {
            index = map.get("_eventId_remove");
        }

        if (index != null) {
            return form.getRegistrants().get(Integer.parseInt(index));
        }

        return null;
    }

    public Registrant deletePerson(RegistrationForm form, LocalAttributeMap currentEvent) {

        logger.debug("Value:" + currentEvent);
        //Debug
        Map<String, String> map = currentEvent.asMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            logger.debug(entry.getKey() + "/" + entry.getValue());
        }

        String index = null;
        if (map.get("index") != null && isInteger(map.get("index"))) {
            index = map.get("index");
        } else if (map.get("_eventId_delete") != null && isInteger(map.get("_eventId_delete"))) {
            index = map.get("_eventId_delete");
        }

        if (index != null) {
            return form.getRegistrants().remove(Integer.parseInt(index));
        }

        return null;
    }

    public RegistrationForm populateChurchList(RegistrationForm form, String state) {

        logger.debug("loadChurch:" + state);

        if (state != null && !state.isEmpty()) {

            if (form.getChurchList() == null) {
                form.setChurchList(new ArrayList<>());
            }
            if (!form.getChurchList().isEmpty()) {
                form.getChurchList().clear();
            }
            List<Church> clist = registrationService.getChurchByState(state);
            if (clist != null && !clist.isEmpty()) {
                clist.stream().map((church) -> new LabelValue(church.getAcronym() + " " + church.getChurchNameChn() + " " + church.getChurchNameEng(), church.getChurchID().toString())).forEach((lv) -> {
                    form.getChurchList().add((LabelValue) lv);
                });
                Collections.sort(form.getChurchList());
            } else {
                form.getChurchList().add(new LabelValue("Other", "888"));
            }
        }

        return form;
    }

    public String getPaymentProviderUrl(RegistrationForm form) {

        logger.info("getPaymentProviderUrl entering");

        PaymentProvider provider = paymentProviderMap.get(form.getPaymentCurrency());

        logger.debug("ServiceProvider:" + provider.getBusiness());

        form.setPaymentProvider(provider);

        return provider.getProviderUrl();
    }

    public PaymentProvider createPaymentRequest(RegistrationForm form, RequestContext context) {

        logger.info("createPaypalRequest entering");

        this.submit(form);

        // Get http request  
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getNativeRequest();
        // Generate Spring Webflow return URL
        String url = request.getRequestURL()
                + ";jsessionid=" + request.getSession().getId() + "?"
                + request.getQueryString();

        String paypalCancelUrl = url + "&_eventId=cancel";
        String paypalSuccessUrl = url + "&_eventId=success";
        logger.debug("Approved URL:" + paypalSuccessUrl);
        logger.debug("Cancel URL:" + paypalCancelUrl);

        form.getPaymentProvider().setItem_number(String.valueOf(form.getFormID().longValue()));

//        p.setCmd("_ext-enter");
//        p.setRedirect_cmd("_xclick");
//        p.setBusiness("Registration@cccm.ws");
//        p.setBusiness("clhoo_1288811245_biz@msn.com");
//        p.setItem_name("CCCC/Grace 2014");
        double total = form.getExpense().getTotalRegistrationFee() + form.getExpense().getTotalMealsFee();
        form.getPaymentProvider().setAmount(String.valueOf(total));
        form.getPaymentProvider().setCustom(String.valueOf(total));
//        p.setNo_shipping("0");
//        p.setNo_note("1");
//        p.setCurrency_code("USD");
//        p.setLc("US");
//        p.setBn("PP-BuyNowBF");
//        p.setReturn("http://localhost:9090/Registration/confirm.htm");
//        form.getPaymentProvider().setReturn(paypalSuccessUrl);
//        p.setNotify_url("http://cccm.biz:8084/registration/instantPaymentNotification.htm");
//        p.setRm("2");
        form.getPaymentProvider().setEmail(form.getAddress().getMisc1());
        form.getPaymentProvider().setFirst_name(form.getPrimaryFirstName());
        form.getPaymentProvider().setLast_name(form.getPrimaryLastName());
        form.getPaymentProvider().setAddress1(form.getAddress().getHomeAddress());
        form.getPaymentProvider().setAddress2(form.getAddress().getHomeAddress2());
        form.getPaymentProvider().setCity(form.getAddress().getHomeCity());
        form.getPaymentProvider().setState(form.getAddress().getHomeState());
        form.getPaymentProvider().setZip(form.getAddress().getHomeZip());
        form.getPaymentProvider().setReturn(paypalSuccessUrl);

        logger.debug("Business:" + form.getPaymentProvider().getBusiness());
        logger.debug("Currency:" + form.getPaymentProvider().getCurrency_code());
        logger.debug("Lc:" + form.getPaymentProvider().getLc());
        logger.info("createPaypalRequest exiting");

        return form.getPaymentProvider();
    }

    public void submit(RegistrationForm form) {
        try {
            registrationService.submit(form);
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            String stacktrace = sw.toString();
            logger.fatal("Submit registration form Fatal: [" + ex + "] " + stacktrace);
        }
    }

    public void sendMail(RegistrationForm form) {
        try {

            if (form.getPaymentMethod() == PaymentMethod.PERSONAL_CHECK) {
                String template = "CCCC_2016_Registration_Acknowledgement.html";
//                if (form.getPaymentCurrency().equalsIgnoreCase("USD")) {
//                    template = "CCLIFE_2015_Registration_Recieved_US.html";
//                }

//                Map<String, String> relationshipMap = new HashMap<String, String>();
//
//                relationshipMap.put("H", "\u4e08\u592b");
//                relationshipMap.put("W", "\u59bb\u5b50");
//                relationshipMap.put("S", "\u5152\u5b50");
//                relationshipMap.put("D", "\u5973\u5152");
//                relationshipMap.put("F", "\u7236\u89aa");
//                relationshipMap.put("M", "\u6bcd\u89aa");
//                relationshipMap.put("B", "\u5144\u5F1F");
//                relationshipMap.put("T", "\u59CA\u59B9");
//                relationshipMap.put("C", "\u540C\u5B66");
//                relationshipMap.put("O", "\u540C\u4E8B");
//                relationshipMap.put("P", "\u4E3B\u62A5\u4EBA");
                String names = "";
                for (Registrant registrant : form.getRegistrants()) {
                    if (!names.isEmpty()) {
                        names += "<br/>";
                    }
//                    String rel = relationshipMap.get(registrant.getPerson().getRelationship());
//                    names += rel;
                    names += registrant.getPerson().getFirstName();
                    names += " ";
                    names += registrant.getPerson().getLastName();
                    names += " ";
                    names += registrant.getPerson().getChineseName();
                }

                Map<String, Object> params = new HashMap<String, Object>();
                params.put("names", names);
                params.put("currency", form.getPaymentCurrency());
                params.put("registrationId", form.getFormID());
                params.put("amountPaid", form.getExpense().getTotalMealsFee() + form.getExpense().getTotalRegistrationFee());
                params.put("registrationFee", form.getExpense().getTotalRegistrationFee());
                params.put("mealFee", form.getExpense().getTotalMealsFee());
                params.put("headCount", String.valueOf(form.getRegistrants().size()));
                Mealplan mp = form.getRegistrants().get(0).getMealplan();
                params.put("mealCount", form.getExpense().getBreakfastCount() + form.getExpense().getLunchCount() + form.getExpense().getDinnerCount());

                params.put("adulttotal", form.getExpense().getAdultHeadcount());
                params.put("nonadulttotal", form.getExpense().getNonAdultHeadcount());
                params.put("nonxadulttotal", form.getExpense().getNonAdultXHeadcount());
                params.put("breakfastTotal", form.getExpense().getBreakfastCount());
                params.put("breakfastFee", form.getExpense().getTotalBreakfastFee());
                params.put("lunchTotal", form.getExpense().getLunchCount());
                params.put("lunchFee", form.getExpense().getTotalLunchFee());
                params.put("dinnerTotal", form.getExpense().getDinnerCount());
                params.put("dinnerFee", form.getExpense().getTotalDinnerFee());
                params.put("grandTotalFee", form.getExpense().getTotalRegistrationFee() + form.getExpense().getTotalMealsFee());

                registrationService.sendEmail(form, params, template);
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, "Submit registration form", ex);
        }
    }

    public void generateReview(RegistrationForm form) {

        if (form.getRegistrants().size() > 0 && form.getRegistrants().get(0).getPerson() != null) {
            form.getRegistrants().get(0).getPerson().setEmail(form.getAddress().getMisc1());
        }
        if ((form.getChurchName() == null || form.getChurchName().isEmpty()) && form.getChurchID() != null) {
            Church ch = registrationService.getChurchByID(form.getChurchID());

            form.setChurchName(ch.getChurchNameChn() + " " + ch.getChurchNameEng());
            form.setChurchCity(ch.getCity());
            form.setChurchState(ch.getState());

        }
        calculateFee(form);
    }

    public void calculateFee(RegistrationForm form) {

        String currency;
//        if (form.getAddress().getCountry().equalsIgnoreCase("CA")) {
//            currency = "CAD";
//
//        } else {
        currency = "USD";
//        }
        logger.debug("Registrant Size:" + form.getRegistrants().size());
        form.setPaymentCurrency(currency);

        Expense expense = createExpenseByCurrency(form, currency);

        form.setExpense(expense);

    }

    private Expense createExpenseByCurrency(RegistrationForm form, String currency) {

        List<Registrant> registrants = form.getRegistrants();
        List<Fee> fees = form.getFees();

        Expense totalExpense = new Expense();

        Integer days = 0;
        if (form.getMisc1()) {
            days++;
        }
        if (form.getMisc2()) {
            days++;
        }
        if (form.getMisc3()) {
            days++;
        }

        double grpTotalRegistrationFee = 0;
        double grpTotalMealFee = 0;

        Double lunchFee = 0.0;
        Double dinnerFee = 0.0;
        Double breakfastFee = 0.0;
        Double adultRegistrationFee = (20.0 * days);
        Double nonAdultRegistrationFee = (10.0 * days);
        Double nonxAdultRegistrationFee = 0.0;


        DateTime now = new DateTime();

        for (Fee fee : fees) {
            Interval interval = new Interval(fee.getEffectiveDate(), fee.getExpirationDate());
//            if (fee.getCurrency().equalsIgnoreCase(currency) && interval.contains(now)) {
//                if (fee.getCodeName().startsWith("ADULTREGISTRATION")) {
//                    adultRegistrationFee = fee.getAmount();
//                } else if (fee.getCodeName().startsWith("NONADULTREGISTRATION")) {
//                    nonAdultRegistrationFee = fee.getAmount();
//                }
//            }
            if (fee.getCodeName().contains("BREAKFAST") && fee.getCurrency().equalsIgnoreCase(currency)) {
                breakfastFee = fee.getAmount();
            }
            if (fee.getCodeName().contains("LUNCH") && fee.getCurrency().equalsIgnoreCase(currency)) {
                lunchFee = fee.getAmount();
            }
            if (fee.getCodeName().contains("DINNER") && fee.getCurrency().equalsIgnoreCase(currency)) {
                dinnerFee = fee.getAmount();
            }
        }

        for (Registrant regt : registrants) {

            if (regt.getExpense() == null) {
                Expense exp = new Expense();
                regt.setExpense(exp);
            }
            // >>>>>>>>>>>>>>>>>>>>> Registration fee >>>>>>>>>>>>>>>>>>>>> 

            if (regt.getPerson().getPreferredLanguage().equalsIgnoreCase("M") || regt.getPerson().getPreferredLanguage().equalsIgnoreCase("E")) {
                regt.getExpense().setTotalRegistrationFee(adultRegistrationFee);
                regt.getExpense().setAdultHeadcount(1);
                totalExpense.setAdultHeadcount(totalExpense.getAdultHeadcount() + 1);
            } else if (regt.getPerson().getPreferredLanguage().equalsIgnoreCase("C") || regt.getPerson().getPreferredLanguage().equalsIgnoreCase("K")) {
                regt.getExpense().setTotalRegistrationFee(nonAdultRegistrationFee);
                regt.getExpense().setAdultHeadcount(1);
                totalExpense.setNonAdultHeadcount(totalExpense.getNonAdultHeadcount() + 1);
            } else if (regt.getPerson().getPreferredLanguage().equalsIgnoreCase("T")) {
                regt.getExpense().setTotalRegistrationFee(nonxAdultRegistrationFee);
                regt.getExpense().setNonAdultHeadcount(1);
                totalExpense.setNonAdultXHeadcount(totalExpense.getNonAdultXHeadcount() + 1);
            }
//            if (regt.getPerson().getAge().startsWith("A")) {
//                regt.getExpense().setTotalRegistrationFee(adultRegistrationFee);
//                regt.getExpense().setAdultHeadcount(1);
//                totalExpense.setAdultHeadcount(totalExpense.getAdultHeadcount() + 1);
//            } else if (Integer.parseInt(regt.getPerson().getAge()) >= 4) {
//                regt.getExpense().setTotalRegistrationFee(nonAdultRegistrationFee);
//                regt.getExpense().setAdultHeadcount(1);
//                totalExpense.setNonAdultHeadcount(totalExpense.getNonAdultHeadcount() + 1);
//            } else if (Integer.parseInt(regt.getPerson().getAge()) < 4) {
//                regt.getExpense().setTotalRegistrationFee(nonxAdultRegistrationFee);
//                regt.getExpense().setNonAdultHeadcount(1);
//                totalExpense.setNonAdultXHeadcount(totalExpense.getNonAdultXHeadcount() + 1);
//            }
            // >>>>>>>>>>>>>>>>>>>>> Meal fee >>>>>>>>>>>>>>>>>>>>>            
            Mealplan mp = regt.getMealplan();

            Integer breakfastCount = (mp.getBreakfast1() != null ? mp.getBreakfast1() : 0)
                    + (mp.getBreakfast2() != null ? mp.getBreakfast2() : 0)
                    + (mp.getBreakfast3() != null ? mp.getBreakfast3() : 0)
                    + (mp.getBreakfast4() != null ? mp.getBreakfast4() : 0)
                    + (mp.getBreakfast5() != null ? mp.getBreakfast5() : 0);
            regt.getExpense().setBreakfastCount(breakfastCount);
            regt.getExpense().setTotalBreakfastFee(breakfastCount * breakfastFee);

            totalExpense.setBreakfastCount(totalExpense.getBreakfastCount() + breakfastCount);
            totalExpense.setTotalBreakfastFee(totalExpense.getTotalBreakfastFee() + regt.getExpense().getTotalBreakfastFee());

            Integer lunchCount = (mp.getLunch1() != null ? mp.getLunch1() : 0)
                    + (mp.getLunch2() != null ? mp.getLunch2() : 0)
                    + (mp.getLunch3() != null ? mp.getLunch3() : 0)
                    + (mp.getLunch4() != null ? mp.getLunch4() : 0)
                    + (mp.getLunch5() != null ? mp.getLunch5() : 0);
            regt.getExpense().setLunchCount(lunchCount);
            regt.getExpense().setTotalLunchFee(lunchCount * lunchFee);

            totalExpense.setLunchCount(totalExpense.getLunchCount() + lunchCount);
            totalExpense.setTotalLunchFee(totalExpense.getTotalLunchFee() + regt.getExpense().getTotalLunchFee());

            Integer dinnerCount = (mp.getDinner1() != null ? mp.getDinner1() : 0)
                    + (mp.getDinner2() != null ? mp.getDinner2() : 0)
                    + (mp.getDinner3() != null ? mp.getDinner3() : 0)
                    + (mp.getDinner4() != null ? mp.getDinner4() : 0)
                    + (mp.getDinner5() != null ? mp.getDinner5() : 0);
            regt.getExpense().setDinnerCount(dinnerCount);
            regt.getExpense().setTotalDinnerFee(dinnerCount * dinnerFee);

            totalExpense.setDinnerCount(totalExpense.getDinnerCount() + dinnerCount);
            totalExpense.setTotalDinnerFee(totalExpense.getTotalDinnerFee() + regt.getExpense().getTotalDinnerFee());

            regt.getExpense().setTotalMealsFee(regt.getExpense().getTotalBreakfastFee() + regt.getExpense().getTotalLunchFee() + regt.getExpense().getTotalDinnerFee());
            // Grand total
            grpTotalRegistrationFee += regt.getExpense().getTotalRegistrationFee();
            grpTotalMealFee += regt.getExpense().getTotalMealsFee();
        }

        totalExpense.setTotalRegistrationFee(grpTotalRegistrationFee);
        totalExpense.setTotalMealsFee(grpTotalMealFee);

        return totalExpense;
    }

    public boolean isSeminarSignup(List<Registrant> registrants) {

        boolean showSeminar = false;

        for (Registrant regt : registrants) {
            if (regt.getPerson().getPreferredLanguage().contentEquals("M")) {
                showSeminar = true;
            }
        }

        return showSeminar;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
