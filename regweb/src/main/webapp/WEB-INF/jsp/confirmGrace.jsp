<%-- 
    Document   : confirm
    Created on : Oct 25, 2010, 5:16:33 PM
    Author     : CH1CHOO1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" media="all" href="/registration/styles/layout.css"/>
        <style type="text/css">
            @import "${pageContext.request.contextPath}/resources/dijit/themes/tundra/tundra.css";
            @import "${pageContext.request.contextPath}/resources/dojo/resources/dojo.css";

            .style2 {
                font-size:16px;
                font-weight:bold;
            }
        </style>

        <title>Thank you for your payment</title>
    </head>
    <body>
        <div id="page">
            <div id="header">
                <p align="center"><span class="style2">Grace Conference 2014: True Identity</span><br/>
                    <strong>GRACE Conference</strong> is the English Speaking Ministry of Chicago Chinese Christian Conference (CCCC).<br/>
                    <b>GRACE</b> is specifically designed for Married and Engaged Couples, Singles, College, Senior High School and Junior High School age groups.<br />
                    <strong>December 27 (Saturday evening) to December 30 (Tuesday after lunch)</strong><br />
                    Location:<strong>Pheasant Run Resort - 4051 East Main St., St. Charles, IL 60174</strong> </p>
            </div>
            <div id="content" align="left">
                <h1>Thank you for your payment. Your registration is completed. Please save your record.</h1>
                <p>
                    Thank you for registration. We received your payment. The total amount paid is $<c:out value="${amountPaid}" />. Please print this review page for your record.
                </p>
                <p>Your Confirmation Number is <c:out value="${registrationId}" /></p>
                <p>
                    You will need to reserve your own hotel room directly with Pheasant Run Resort. Click here for <a href="https://bookings.ihotelier.com/Pheasant-Run-Resort/bookings.jsp?groupID=1134840&amp;hotelID=2932">Pheasant Run Resort Hotel Reservation</a></p>
                <br/>
                <p>
                    If you wish to volunteer, we would welcome your help!  
                </p>
                <h3><span class="Heading3Char">Please check out the following links: </span>:</h3>
                <p>
                <ul style="list-style-type:square">
                    <li>
                        <a href="https://docs.google.com/forms/d/1m19iJtJW2DerAmKB2_QPlU_3j7-LvwnKVebglG4EAbM/viewform" target="_blank">G14 Small Group Leader's Reference Form</a>
                    </li>
                    <li><a href="https://docs.google.com/forms/d/13eqJb54zAIPFfOz98KzRVpmFnZKSFnVmCIDH-zAUDy4/viewform" target="_blank">G14 Hospitality Volunteer's Form</a></li>
                    <li><a href="https://docs.google.com/forms/d/1kKQPfLsJGf4YpIK450PoYg51Toinz92vlD4hXgZUN-E/viewform" target="_blank">G14 A/V Volunteer's Form</a></li>
                    <li><a href="http://graceconference.org/" target="_blank">Grace Conference</a></li>
                    <li><a href="http://graceconference.org/coc.html" target="_blank">Grace Conference Community Values and Expectations</a></li>
                    <li><a href="https://docs.google.com/document/d/1ADgfxSEdwUXY5FD-7OujNk6mRl9iq3n7K8YaqFNheh0/edit" target="_blank">Grace Conference 2014 Permission Slip</a></li>
                </ul>
                </p>
                <h3>Donation</h3>
                <p>
                    Registration fee covers only 25% of the conference expenses and operational costs which depend largely on your generous donations. You can make your tax deductible contribution to CCCC 2014
                    and/or GRACE 2014 by making a separate check out to the same payee and mail to the same address listed above.  However, please do not put anything on the memo line.
                </p>
                <p>Please make checks payable to CCCM and mail to:</p>
                <p>
                    CCCM (Chicago Chinese Christian Missions)<br/>
                    631 Illinois Route 83<br/>
                    Suite 204 <br/>
                    Bensenville, IL 60106
                </p>
                <p>Thank you for your generous heart!</p>
                <p>CCCC 2014 &#38; GRACE 2014 Coordinators</p>
                <br/>
            </div>
            <div id="footer" align="center">
                <p align="center">
                    <b><span style='font-size:11.0pt;'>Be sure to visit <a href="javascript:void(0)" onclick="window.open('http://graceconference.org', 'Grace2014', 'height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');">http://graceconference.org</a> for all the latest updates for GRACE 2014.</span></b>
                </p>
            </div>
        </div>
    </body>
</html>
