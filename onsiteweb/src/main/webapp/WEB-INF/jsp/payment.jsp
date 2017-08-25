<%-- 
    Document   : confirm
    Created on : Oct 25, 2010, 5:16:33 PM
    Author     : CH1CHOO1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

        <title>Online Payment</title>
    </head>
    <body>
        <div id="page">
            <div id="content" align="left">
                <b>点击下方图标付款. Please click button below to make payment ${paymentUrl}</b>
                <br/>
                <br/>
                <form:form method="post" modelAttribute="paymentProvider" action="${paymentUrl}">
                    <form:hidden path="cmd"/>
                    <form:hidden path="redirect_cmd"/>
                    <form:hidden path="business"/>
                    <form:hidden path="item_name"/>
                    <!--
                    <form:hidden path="item_number"/>
                    <form:hidden path="amount"/>
                    -->
                    <form:hidden path="custom"/>
                    <form:hidden path="no_shipping"/>
                    <form:hidden path="no_note"/>
                    <form:hidden path="currency_code"/>
                    <form:hidden path="lc"/>
                    <form:hidden path="bn"/>
                    <form:hidden path="return"/>
                    <form:hidden path="rm"/>
                    <form:hidden path="email"/>
                    <form:hidden path="first_name"/>
                    <form:hidden path="last_name"/>
                    <form:hidden path="address1"/>
                    <form:hidden path="address2"/>
                    <form:hidden path="city"/>
                    <form:hidden path="state"/>
                    <form:hidden path="zip"/>
                    <form:hidden path="notify_url"/>
                    <form:hidden path="undefined_quantity"/>

                    <table width="100%" border="0" cellspacing="2" cellpadding="1" >
                        <tr>
                            <td style="width: 40%;">Registration Number: <font color="red"> &nbsp;* &nbsp;</font></td>
                            <td><form:input name="registrationNumber" path="item_number" size="15" maxlength="15"/></td>
                        </tr>
                        <tr>
                            <td style="width: 40%;">Payment Amount <font color="red"> &nbsp;* &nbsp;</font></td>
                            <td><form:input name="amount" path="amount" size="5" maxlength="5"/></td>
                        </tr>

                        <tr>
                            <td colspan="2"><br/><hr style="width: 100%; height: 2px;"></td>
                        </tr>
                        <tr>
                            <td style="width: 40%;">主报人英文名<br>Primary First Name: <font color="red"> &nbsp;* &nbsp;</font></td>
                            <td><form:input name="primaryFirstName" path="first_name" size="15" maxlength="15"/></td>
                        </tr>
                        <tr>
                            <td style="width: 40%;">主报人英文姓<br>Primary Last Name: <font color="red"> &nbsp;* &nbsp;</font></td>
                            <td><form:input name="primaryLastName" path="last_name" size="15" maxlength="15"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><br/><hr style="width: 100%; height: 2px;"></td>
                        </tr>
                        <tr>
                            <td align="left" valign="top" width="150" class="normal_text">住址 Street Address *</td>
                            <td class="normal_text">
                                <form:input path="address1" name="homeAddress" size="30" maxlength="60"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="left" valign="top" width="150" class="normal_text">住址 Street Address2: </td>
                            <td><form:input path="address2" name="homeAddress2" size="30" maxlength="60"/> </td>
                        </tr>
                        <tr>
                            <td align="left" valign="top" width="150" class="normal_text">城市 City *</td>
                            <td class="normal_text">
                                <form:input path="city" name="homeCity"  size="30" maxlength="30"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="left" width="150" class="normal_text">州 State *</td>
                            <td class="normal_text">
                                <br/>
                                <form:select id="stateId" path="state">
                                    <form:option value="" label="-- Select State --" />
                                    <form:options items="${stateList}" itemValue="value" itemLabel="label" />
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td width="150" align="left" valign="top" class="normal_text">郵遞區號 Zip Code *</td>
                            <td class="normal_text">
                                <form:input path="zip" name="homeZip" size="10" maxlength="15"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><br/></td>
                        </tr>
                        <tr>
                            <td align="left" width="150" class="normal_text">電郵 Email Address *</td>
                            <td class="normal_text">
                                <form:input id="email" path="email" name="email" size="25" maxlength="50"/>
                            </td>
                        </tr>

                    </table>
                    <p>
                        <input type="image" src="http://www.paypal.com/en_US/i/btn/x-click-but06.gif" cssClass="button" key="button.pay" theme="simple"/>
                    </p>
                </form:form>
            </div>
        </div>
    </body>
</html>
