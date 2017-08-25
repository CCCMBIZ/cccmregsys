<%-- 
    Document   : notFound
    Created on : Nov 28, 2010, 3:44:15 AM
    Author     : CH1CHOO1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
    <head>
        <title>Review your registration</title>
        <link rel="stylesheet" type="text/css" media="all" href="/registration/styles/layout.css"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/blueprint/screen.css" />" media="screen, projection" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/blueprint/print.css" />"  media="print" />

        <script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>
    </head>
    <body>
        <div id="page">
            <div id="header">
                <p align="center"><span class="style2">芝加哥2012基督徒大會報名Chicago Chinese Christian Conference 2012</span><br/>
                    12月26日(週三晚)開始，12月29日(週六午)結束  主题：《高舉基督 同得萬民》  <br/>
                    講員：戴繼宗、于慕潔、王美鍾…等牧師 <br/>
                    地點：Radisson Hotel at Star Plaza, Merrillville, Indiana 46410 (離芝加哥車程40 分鐘40min from Chicago Chinatown)<br />
                </p>
            </div>
            <div id="content" align="left">

                <p>Your information is not found, please try again
                <input type="button" style="margin-right: 5px" class="button"
                       onclick="location.href='<c:url value="/lookupById.htm"/>'"
                       value="查尋Lookup"/>
                </p>
            </div>
            <div id="footer" align="center">
                <p>
                    <b><span style='font-size:11.0pt;'>Be sure to visit <a href="javascript:void(0)" onclick="window.open('http://cccm.ws','CCCC2011','height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');">http://cccm.ws</a> for all the latest updates for CCCC 2011.</span></b>
                </p>
            </div>
        </div>
    </body>
</html>


