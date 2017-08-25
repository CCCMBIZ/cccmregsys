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
                <p align="center"><span class="style2">中国福音大会 2015 报名表 </span><br/>
                    时间: 2015年12月28日至12月30日 &nbsp;大会地点: &nbsp;The Prayer Palace Church 1111 Arrow Road, Toronto, ON M9M 3B3 Canada<br />
                </p>
            </div>
            <div id="content" align="left">
                <h1>Thank you for your payment. Your registration is completed. Please save your record.</h1>
                <p>
                    Thank you for registration. We received your payment. The total amount paid is $<c:out value="${amountPaid}" />. Please print this review page for your record.
                </p>
                <p>Your Confirmation Number is <c:out value="${registrationId}" /></p>
                <h3><span class="Heading3Char">网上查询注册資料Check Your registration Online</span>:</h3>

            </div>
            <div id="footer" align="center">
                <p>
                    <b><span style='font-size:11.0pt;'>Be sure to visit <a href="javascript:void(0)" onclick="window.open('https://www.cclifefl.org', 'CCLIFE', 'height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');">https://www.cclifefl.org</a> for all the latest updates for GFCC 2015.</span></b>
                </p>
            </div>
        </div>
    </body>
</html>
