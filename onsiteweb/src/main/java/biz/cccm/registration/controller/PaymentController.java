/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.cccm.registration.controller;

import biz.cccm.registration.domain.LabelValue;
import biz.cccm.registration.domain.PaymentProvider;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author chehh
 */
@Controller
public class PaymentController {

    @Autowired
    PaymentProvider paymentProvider;

    @RequestMapping("/payment.htm")
    public ModelAndView handleRequest() {

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

//        paymentProvider.setItem_number("TEST");
//
//        p.setCmd("_ext-enter");
//        p.setRedirect_cmd("_xclick");
//        p.setBusiness("Registration@cccm.ws");
//        p.setBusiness("clhoo_1288811245_biz@msn.com");
//        p.setItem_name("CCCC/Grace 2014");
//        paymentProvider.setAmount("10");
//        paymentProvider.setCustom("10");
        String paymentUrl = paymentProvider.getProviderUrl();

        // Return back to payment.jsp
        ModelAndView model = new ModelAndView("payment");
        model.addObject("paymentProvider", paymentProvider);
        model.addObject("paymentUrl", paymentUrl);
        model.addObject("stateList", stateList);

        return model;
    }

}
