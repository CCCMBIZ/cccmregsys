<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    function otherCountry($val) {
        if ($val == 'OT') {
            document.getElementById("otherCountryDiv").style.display = "block";
        } else {
            document.getElementById("otherCountryDiv").style.display = "none";
        }
    }
</script>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18"> 
    <p class="notice"><b>2. 请输入主报人的姓名和家庭地址<br>Step 2 - Enter individual information</b><br></p>

    <li><font color='red'>有 * 号的拦目务必填写 (* indicates required field) <br></font></li>

    <form:form id="step2" action="${flowExecutionUrl}" modelAttribute="form" acceptCharset="UTF-8">

        <table width="100%" border="0" cellspacing="2" cellpadding="1" >
            <tr>
                <td align="left" valign="top" width="150" class="normal_text" colspan="2">
                    家長或聯絡人資料(以下資料務必填寫，以便聯絡)<br/>
                    Please enter primary registrant information below.  Additional people can be added to this registration in Step 3.<br/> 
                    <hr style="width: 100%; height: 2px;"/> 
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center" >
                    <form:errors path="primaryChineseName" cssClass="fieldError"/></td>
            </tr>
            <tr>
                <td style="width: 40%;">主报人中文姓名<br>Primary Chinese Name: </td>
                <td><form:input id="primaryChineseName" path="registrants[0].person.chineseName" size="10"/></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center" >
                    <form:errors path="primaryFirstName" cssClass="fieldError"/></td>
            </tr>
            <tr>
                <td style="width: 40%;">主报人英文名<br>Primary First Name: <font color="red"> &nbsp;* &nbsp;</font></td>
                <td><form:input name="primaryFirstName" path="registrants[0].person.firstName" size="15" maxlength="15"/></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center" >
                    <form:errors path="primaryLastName" cssClass="fieldError"/></td>
            </tr>
            <tr>
                <td style="width: 40%;">主报人英文姓<br>Primary Last Name: <font color="red"> &nbsp;* &nbsp;</font></td>
                <td><form:input name="primaryLastName" path="registrants[0].person.lastName" size="15" maxlength="15"/></td>
            </tr>
            <tr>
                <td colspan="2"><br/><hr style="width: 100%; height: 2px;"></td>
            </tr>
            <tr>
                <td align="left" valign="top" width="150" class="normal_text">住址 Street Address *</td>
                <td class="normal_text">
                    <form:errors path="address.homeAddress" cssClass="fieldError"/><br/>
                    <form:input path="address.homeAddress" name="homeAddress" size="30" maxlength="60"/>
                </td>
            </tr>
            <tr>
                <td align="left" valign="top" width="150" class="normal_text">住址 Street Address2: </td>
                <td><form:input path="address.homeAddress2" name="homeAddress2" size="30" maxlength="60"/> </td>
            </tr>
            <tr>
                <td align="left" valign="top" width="150" class="normal_text">城市 City *</td>
                <td class="normal_text">
                    <form:errors path="address.homeCity" cssClass="fieldError"/><br/>
                    <form:input path="address.homeCity" name="homeCity"  size="30" maxlength="30"/>
                </td>
            </tr>
            <tr>
                <td align="left" width="150" class="normal_text">州 State *</td>
                <td class="normal_text">
                    <form:errors path="address.homeState" cssClass="fieldError"/>
                    <br/>
                    <form:select id="stateId" path="address.homeState" onchange="otherCountry(value);">
                        <form:option value="" label="-- Select State --" />
                        <form:options items="${form.stateList}" itemValue="value" itemLabel="label" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="otherCountryDiv" style="display:none;">

                        <table>
                            <tr>
                            <hr style="width: 80%; height: 2px;">
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align:left">若非美国,请填写如下信息,：If other than United States
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align:center" >
                                    <form:errors path="address.otherCountry" cssClass="fieldError"/>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 40%;">国家 Country: </td>
                                <td style="width: 40%;"> 
                                    <form:input path="address.otherCountry"  id="otherCountry"  size="30" maxlength="50" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align:center" >
                                    <form:errors path="address.otherState" cssClass="fieldError"/>
                                </td>
                            </tr>
                            <tr>
                                <td>州/省 State/Province: </td>
                                <td> 
                                    <form:input path="address.otherState" id="otherState"  size="10" maxlength="20"  />
                                </td>
                            </tr>

                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td width="150" align="left" valign="top" class="normal_text">郵遞區號 Zip Code *</td>
                <td class="normal_text">
                    <form:errors path="address.homeZip" cssClass="fieldError"/><br/>
                    <form:input path="address.homeZip" name="homeZip" size="10" maxlength="15"/>
                </td>
            </tr>
            <tr>
                <td align="left" valign="top" width="150" class="normal_text">聯絡電話 Contact Phone Number*</td>
                <td class="normal_text">
                    <form:errors path="address.homePhone" cssClass="fieldError"/>
                    <br/>
                    <form:input path="address.homePhone" name="homePhone" size="15" maxlength="15"/>
                    &#32;&#32;&#32;&#32;<strong>xxx-xxx-xxxx</strong>
                </td>
            </tr>
            <tr>
                <td colspan="2"><br/></td>
            </tr>
            <tr>
                <td align="left" width="150" class="normal_text">電郵 Email Address *</td>
                <td class="normal_text">
                    <form:errors path="address.misc1" cssClass="fieldError"/><br/>
                    <form:input id="email" path="address.misc1" name="email" size="25" maxlength="50"/>
                </td>
            </tr>
            <tr>
                <td width="250" align="left" class="normal_text">確認電郵 Confirm Email Address *</td>
                <td class="normal_text">
                    <form:errors path="address.misc2" cssClass="fieldError"/><br/>
                    <form:input id="confirmEmail" path="address.misc2" name="emailConfirm" size="25" maxlength="50"/>
                </td>
            </tr>

        </table>
        <hr style="width: 80%; height: 2px;">
        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'step2', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'previous', event: 'onclick', formId: 'step2', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'step2', popup: true, params: {fragments: "body"}}));
        </script>

        <c:set var="ucStateValue" value="${form.getAddress().getHomeState()}" />
        <script type="text/javascript">
            otherCountry("${ucStateValue}");
        </script>

    </form:form>
</div>


