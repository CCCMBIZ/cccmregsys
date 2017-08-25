<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="span-2 colborder">
    <br/>
</div>
<div id="embeddedFlow" class="span-18">
    <p class="notice"><b>1. 请输入所屬教會/團契/查經班<br>
            Step 1 - Enter Church, Fellowship or Bible Study Group affiliation information</b></p>
    <li><font color='red'>有 * 号的拦目务必填写 (* indicates required field) <br></font></li>

    <form:form id="step1" action="${flowExecutionUrl}" modelAttribute="form" name="step1">
        <div>
            <form:errors path="*" cssClass="fieldError"/>
            <br/>
            <table border="0" cellspacing="0" cellpadding="0" width="968">

                <tr>
                    <td class="normal_text"><strong>(1) 請先選擇您的州Select your State first:</strong><br/>
                        <form:select id="churchStateId" path="selectedChurchState" style='margin-left:10px;margin-right:10px;' >
                            <form:option value="" label="-- Select State --" />
                            <form:options items="${form.churchStateList}" itemValue="value" itemLabel="label" />
                        </form:select>
                        <script type="text/javascript">
                            Spring.addDecoration(new Spring.AjaxEventDecoration({
                                elementId: "churchStateId",
                                formId: "step1",
                                event: "onchange",
                                params: {
                                    _eventId: "loadchurch",
                                    fragments: "body"
                                }
                            }));
                        </script>
                    </td>
                    <td width="248">報名日期Registered Date:<fmt:formatDate pattern="MM/dd/yyyy" value="${form.registrationDate}" /></td>
                </tr>
                <tr>
                    <td class="normal_text" colspan="2">
                        <strong>(2) 教會/團契/查經班 Church, Fellowship or Bible Study Group: <font color='red'>*</font></strong><br/>
                            <form:select name="churchID" id="churchID" path="churchID" style='margin-left:10px;margin-right:10px;'>
                                <form:option value="0" label="-- Select state first --"/>
                                <form:options items="${form.churchList}" itemValue="value" itemLabel="label" />
                            </form:select>
                    </td>
                </tr>
                <tr> 
                    <td colspan="3"> 
                        <p>如果您的教會不在名單上, 請選擇 Others并在此資料填上您的教會資料.If your church is not in the list above, please select <b>Others</b>, and enter information here</p>
                        <table  width="100%" border="0" cellspacing="2" cellpadding="1" >
                            <tbody>
                                <tr>
                                    <td style="width: 40%;">教會/團契/查經班名稱Church/Org Name：</td>
                                    <td><form:input path="churchName" name="churchName" size="20" maxlength="50"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"> <hr style="width: 100%; height: 2px;"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:errors path="address.homePhone" cssClass="fieldError"/>
                        <form:errors path="address.misc1" cssClass="fieldError"/>
                        <form:errors path="address.misc2" cssClass="fieldError"/>
                    </td>
                </tr>
                <tr>
                    <td align="left" valign="top" width="150" class="normal_text">聯絡電話 Contact Phone Number*</td>
                    <td class="normal_text">
                        <form:input path="address.homePhone" name="homePhone" size="15" maxlength="15"/>
                        &#32;&#32;&#32;&#32;<strong>xxx-xxx-xxxx</strong>
                    </td>
                </tr>
                <tr>
                    <td align="left" width="150" class="normal_text">電郵 Email Address *</td>
                    <td class="normal_text">
                        <form:input id="email" path="address.misc1" name="email" size="25" maxlength="50"/>
                    </td>
                </tr>
                <tr>
                    <td width="250" align="left" class="normal_text">確認電郵 Confirm Email Address *</td>
                    <td class="normal_text">                      
                        <form:input id="confirmEmail" path="address.misc2" name="emailConfirm" size="25" maxlength="50"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"> <hr style="width: 100%; height: 2px;"></td>
                </tr>
            </table>
            <table class="defaultTable" cellpadding="0" cellspacing="0">
                <thead class="defaultTableHeader">
                    <tr>
                        <th rowspan="2">&#32;&#32;</th>
                        <th rowspan="2">中文名 Chinese Name</th>
                        <th rowspan="2">英文名 First Name</th>
                        <th rowspan="2">英文姓 Last Name</th>
                        <th rowspan="2" style="width: 40px;">性別 Gender</th>
                        <th rowspan="2">年齡 Age</th>
                        <th rowspan="2">參加聚會Attend</th>
                        <th rowspan="2">信仰 Faith</th>
                        <th rowspan="2"></th>
                        <th  style="width:100px;">&#32;</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${form.registrants}" varStatus="registrant">
                        <tr>
                            <td colspan="14">
                                <form:errors path="registrants[${registrant.index}].person.firstName" cssClass="fieldError"/>
                                <form:errors path="registrants[${registrant.index}].person.lastName" cssClass="fieldError"/>
                                <form:errors path="registrants[${registrant.index}].person.gender" cssClass="fieldError"/>
                                <form:errors path="registrants[${registrant.index}].person.age" cssClass="fieldError"/>
                                <form:errors path="registrants[${registrant.index}].person.preferredLanguage" cssClass="fieldError"/>
                                <form:errors path="registrants[${registrant.index}].person.acceptedChrist" cssClass="fieldError"/>
                            </td>
                        </tr>
                        <tr>
                            <td><h4>${registrant.index+1} *</h4></td>
                            <td><form:input id="chineseName${registrant.index}" path="registrants[${registrant.index}].person.chineseName" size="10"/></td>
                            <td><form:input id="firstName${registrant.index}" path="registrants[${registrant.index}].person.firstName" size="10"/></td>
                            <td><form:input id="lastName${registrant.index}" path="registrants[${registrant.index}].person.lastName" size="10"/></td>
                            <td style="font-size:10px;width:50em"><form:radiobutton id="gender${registrant.index}" path="registrants[${registrant.index}].person.gender" value="M" label="男M"/>
                                <br/>
                                <form:radiobutton id="gender${registrant.index}" path="registrants[${registrant.index}].person.gender" value="F" label="女F"/>
                            </td>                                 
                            <td><form:select id="age${registrant.index}" path="registrants[${registrant.index}].person.age">
                                    <form:option value="" label="-- 年齡 --" />
                                    <form:options items="${form.ageGroup}" itemValue="value" itemLabel="label" />
                                </form:select></td>
                            <td>
                                <form:select id="language${registrant.index}" path="registrants[${registrant.index}].person.preferredLanguage">
                                    <form:option value="" label="-- 參加 --"/>
                                    <form:option value="M" label="中文大会"/>
                                    <form:option value="E" label="GRACE"/>
                                    <form:option value="C" label="1-5th"/>
                                    <form:option value="K" label="3yrs-K"/>
                                    <form:option value="T" label="1-2yrs"/>
                                </form:select>
                            </td>
                            <td style="font-size:10px;width:5px">
                                <form:radiobutton path="registrants[${registrant.index}].person.acceptedChrist" value="false" label="未Seeker"/>&#160;
                                <form:radiobutton path="registrants[${registrant.index}].person.acceptedChrist" value="true" label="已Believer"/>
                            </td>
                            <td style="width:100px;">
                                <c:if test="${registrant.index != 0}">  
                                    <button id="remove_${registrant.index}" type="submit" name="_eventId_delete" value="${registrant.index}" style="width:53px;" ><font size="2">-删除Delete</font></button>
                                    <script type="text/javascript">
                                        Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'delete_${registrant.index}', event: 'onclick', formId: 'step1', params: {fragments: "body", index: "${registrant.index}"}}));
                                    </script>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="14">
                            <button id="edit_${registrant.index}" type="submit" name="_eventId_add" value="${registrant.index}">+ 添加同行家人資料Add person</button>
                            <script type="text/javascript">
                                Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'add_${registrant.index}', event: 'onclick', formId: 'step1', params: {fragments: "body", index: "${registrant.index}"}}));
                            </script>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="14">
                            <hr style="width: 100%; height: 2px;">現場報名費On site Registration Fee：每天成人Adult per day$20、兒童Chiclren per day$10
                        </td>
                    </tr>
                    <tr>
                        <td colspan="14">
                            <form:errors path="misc1" cssClass="fieldError"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="14">
                            <form:checkbox path="misc1" label="12/28-12/29"/>  <form:checkbox path="misc2" label="12/29-12/30"/>  <form:checkbox path="misc3" label="12/30-12/31"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="14">
                            <hr style="width: 100%; height: 2px;">
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <button id="cancel" type="button" name="_eventId_cancel">Cancel</button>
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'step1', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'step1', params: {fragments: "body"}}));
        </script>
    </form:form>
</div>

