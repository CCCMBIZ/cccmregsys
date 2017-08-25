<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow"  class="span-18">
    <p class="notice"><b>3. 请输入个人信息 （第一位输入的人为主报人）<br>Step 3 - Enter all other individual(s) information</b><br></p>

    <li><font color='red'>有 * 号的拦目务必填写 (* indicates required field) <br></font></li>

    <form:form id="step3" action="${flowExecutionUrl}" modelAttribute="form" acceptCharset="UTF-8">

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
                    <th rowspan="2">事奉角色 Status</th>
                    <th rowspan="2">信仰 Faith</th>
                    <th rowspan="2">(信主年數 No.Yrs in faith)</th>
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
                            <form:errors path="registrants[${registrant.index}].person.status" cssClass="fieldError"/>
                            <form:errors path="registrants[${registrant.index}].person.acceptedChrist" cssClass="fieldError"/>
                            <form:errors path="registrants[${registrant.index}].person.misc1" cssClass="fieldError"/>
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
                        <td>
                            <form:select id="status${registrant.index}" path="registrants[${registrant.index}].person.status">
                                <form:option value="" label="-- 服事 (For Chinese Conf --" />
                                <form:options items="${form.statusGroup}" itemValue="value" itemLabel="label" />
                            </form:select>
                        </td> 
                        <td style="font-size:10px;width:5px">
                            <form:radiobutton path="registrants[${registrant.index}].person.acceptedChrist" value="false" label="未Seeker"/>&#160;
                            <form:radiobutton path="registrants[${registrant.index}].person.acceptedChrist" value="true" label="已Believer"/>
                        </td>
                        <td>&#32;<form:input path="registrants[${registrant.index}].person.misc1" size="2" maxlength="2"/>
                        </td>
                        <td style="width:100px;">
                            <c:if test="${registrant.index != 0}">  
                                <button id="remove_${registrant.index}" type="submit" name="_eventId_delete" value="${registrant.index}" style="width:53px;" ><font size="2">-删除Delete</font></button>
                                <script type="text/javascript">
                                    Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'delete_${registrant.index}', event: 'onclick', formId: 'step3', params: {fragments: "body", index: "${registrant.index}"}}));
                                </script>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="14">
                        <button id="edit_${registrant.index}" type="submit" name="_eventId_add" value="${registrant.index}">+ 添加同行家人資料Add person</button>
                        <script type="text/javascript">
                            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'add_${registrant.index}', event: 'onclick', formId: 'step3', params: {fragments: "body", index: "${registrant.index}"}}));
                        </script>
                    </td>
                </tr>
                <tr>
                    <td colspan="14">
                        <form:checkbox path="misc1" label="我願意(有負擔)做義工,參與大会服事Volunteer to serve in conference"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="14">
                        <hr style="width: 100%; height: 2px;">
                    </td>
                </tr>

                <tr>
                    <td colspan="14">
                        <h4><strong>填表說明 </strong><strong>Instructions:</strong></h4>
                        <p><strong>1)</strong>&nbsp;<strong>年齡 </strong><strong>Age:</strong></p>
                        <p style="padding-left: 30px;"><strong>成人請填 </strong><strong>Adults: Please select from:</strong><strong>A2</strong>(18-29),<strong>A3</strong>(30-39),<strong>A4</strong>(40-49),<strong>A5</strong>(50-59),<strong>A6</strong>(60+)</p>
                        <p style="padding-left: 30px;"><strong>兒童 </strong><strong>Children (</strong><strong>3yr-5th</strong><strong>) /</strong><strong>青少年 </strong><strong>Youth (</strong><strong>6th-17yr</strong><strong>):&nbsp;</strong>請填實際年齡Please fill in the actual age.</p>
                        <p><strong>2)</strong>&nbsp;&nbsp;&nbsp;&nbsp; <strong>青少年或孩童 </strong><strong>Children/Youth (</strong><strong>3</strong><strong>-17):</strong></p>
                        <p style="padding-left: 30px;">若未有父母陪同而欲來參加大會，必須繳交permission slip，細則請上<a href="http://www.cccm.ws/" target="_blank">www.cccm.ws</a></p>
                        <p style="padding-left: 30px;">A signed <strong>Permission Slip</strong> will be required during check-in for those attendees without companion of parents. See <a href="http://www.cccm.ws/" target="_blank">www.cccm.ws</a> for details.</p>
                        <p><strong>3)</strong>&nbsp;<strong>參加聚會 </strong><strong>Workshops:</strong></p>
                        <p style="padding-left: 30px;">按每人的年齡與需要勾選將參加的聚會</p>
                        <p style="padding-left: 30px;">Please select the ones best fit your interest, age and need.</p>
                        <p><strong>4) 本教會服事(Home church serving Roles)：</strong></p>
                        <p style="padding-left: 30px;"><strong>F</strong>（全職傳道 &ndash; Full time pastor/missionary）、<strong>P</strong>（教會牧者 &ndash; Church pastor）、<strong>T</strong>（神學生 - Theological seminary student）、<strong>N</strong>（機構同工 &ndash; Christian organization staff）、<strong>C</strong>（校園同工 &ndash; Campus worker）、<strong>E</strong>（教會長執 &ndash; Church leadership team member）、<strong>S</strong>（小組或團契同工 &ndash; Small group/fellowship&nbsp; coworkers）</p>
                        <p><strong>5)&nbsp;信仰 Faith:</strong></p>
                        <p style="padding-left: 30px;">已信主者請在第二格打勾（&uuml;），並填上（信主年數）。</p>
                        <p style="padding-left: 30px;">For believers, please check the second box with （&uuml;）, and fill in the number of years as a disciple.</p>
                        <p style="padding-left: 30px;">未信者請在第一格打勾（&uuml;）。</p>
                        <p style="padding-left: 30px;">Non-believers or seekers please check the first box（&uuml;）.</p>
                        <p><strong>6)&nbsp;大會招募義工 Volunteers needed for the conference: </strong></p>
                        <p style="padding-left: 30px;">1（飯食 &ndash; Meal service）、2（招待 &ndash;&nbsp;Usher &amp; reception desk）、3（兒童- Childcare）、4（禱告 &ndash; Prayer group）、5（粵語翻譯 &ndash; Cantonese interpreter）、6（英語翻譯 &ndash; English interpreter）。</p>
                        <p>&nbsp;</p>
                    </td>
                </tr>
                <tr>
                    <td colspan="14">
                        <hr style="width: 100%; height: 2px;">
                    </td>
                </tr>

            </tbody>
        </table>
        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'step3', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'previous', event: 'onclick', formId: 'step3', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'step3', popup: true, params: {fragments: "body"}}));
        </script>
    </form:form>
</div>

