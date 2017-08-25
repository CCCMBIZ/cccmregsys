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
                    <p align="center">
                        <span class="style2">2015芝加哥華人領袖高峰會</span><br/>
                        <span class="style2">Chinese Global Leadership Summit in Chicago</span><br/>
                        <strong>時間: Saturday, April 18, 2015 9:00am to 6:00pm </strong><br/>
                        <strong>合辦單位Sponsors: 芝華宣道(CCCM);柳溪協会(Willow Creek Association)</strong><br/>
                    </p>

                    <strong>報名費Registration fee (lunch included包括午餐):</strong>
                    <ul>
                        <li>個人Individual - 2/18日前: $40; 3/18日前: $50; 4/11日前: $60</li>
                        <li>團體 Group 5+ (5人以上) - 2/18日前: $30; 3/18日前: $40; 4/11日前: $50</li>
                    </ul>
            </div>
            <div id="content" align="left">
                <h1>Thank you for your payment. Your registration is completed. Please save your record.</h1>
                <p>
                    Thank you for registration. We received your payment. The total amount paid is $<c:out value="${amountPaid}" />. Please print this review page for your record.
                </p>
                <p>Your Confirmation Number is <c:out value="${registrationId}" /></p>
            </div>
            <div id="footer" align="center">
                <p>
                    <b><span style='font-size:11.0pt;'>Be sure to visit <a href="javascript:void(0)" onclick="window.open('http://www.cccm.ws/CCCM/cccmcccc.html', 'CCCC', 'height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');">http://www.cccm.ws/CCCM/cccmcccc.html</a> for all the latest updates for CCCC 2014.</span></b>
                </p>
            </div>
        </div>
    </body>
</html>
