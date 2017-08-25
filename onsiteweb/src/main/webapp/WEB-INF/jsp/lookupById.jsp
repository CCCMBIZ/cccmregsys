<%-- 
    Document   : review
    Created on : Nov 23, 2010, 12:53:15 AM
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
                <p align="center"><span class="style2">芝加哥 2014 基督徒大會報名表 Chicago Chinese Christian Conference 2014</span><br/>
                    主題:《覺醒--預備迎見你的神》 講員:饒孝楫、劉傳章、劉志雄...等牧師<br/>
                    時間: 12月27日(週六晚)開始,12月30日(週二午)結束 地點:Pheasant Run Resort (4051 East Main St., St. Charles, IL 60174)<br />
                </p>
            </div>
            <div id="content" align="left">


                <br/>
                <form:form commandName="criteria" action="review.htm" method="post">

                    <fieldset>
                        <legend>Please enter your registration number</legend>
                        <p>
                            <label for="registrationId">注册号码 Registration Number:</label>
                            <br />
                            <input type="text" name="registrationId" id="registrationId" />
                        </p>
                        <script type="text/javascript">
                            Spring.addDecoration(new Spring.ElementDecoration({
                                elementId: "registrationId",
                                widgetType: "dijit.form.ValidationTextBox",
                                widgetAttrs: {required: true}}));
                        </script>
                        <p>
                            <button id="submit" type="submit">Lookup</button>
                            <script type="text/javascript">
                                Spring.addDecoration(new Spring.ValidateAllDecoration({event: 'onclick', elementId: 'submit'}));
                            </script>
                        </p>
                    </fieldset>
                </form:form>
                <p>If you do not have your registration number, please use home phone and zip code to search 如果您沒有注册号碼，請用家庭电话和邮政编码查寻
                    <input type="button" style="margin-right: 5px" class="button"
                           onclick="location.href = '<c:url value="/lookup.htm"/>'"
                           value="用电话查尋Lookup by phone/zip"/>
                </p>
            </div>
            <div id="footer" align="center">
                <p>
                    <b><span style='font-size:11.0pt;'>Be sure to visit <a href="javascript:void(0)" onclick="window.open('http://www.cccm.ws/CCCM/cccmcccc.html', 'CCCC', 'height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');">http://www.cccm.ws/CCCM/cccmcccc.html</a> for all the latest updates for CCCC 2014.</span></b>
                </p>
            </div>
        </div>
    </body>
</html>

