<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/webflow-registration/resources/styles/blueprint/screen.css" type="text/css" media="screen, projection" />
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18">
    <p class="notice">5. 请先核对您已经输入的信息。Step 5 - Please double check the information you entered.</p>
    <form:form id="review" action="${flowExecutionUrl}" modelAttribute="form">
        <div>
            <table align="center">
                <caption> <b>地址信息 Address information</b></caption> 
                <tbody>
                    <tr>
                        <td width="40%">住址 Street Address1: </td>
                        <td>${form.address.homeAddress} </td>
                    </tr>
                    <tr>
                        <td>住址 Street Address2: </td>
                        <td>${form.address.homeAddress2}</td>
                    </tr>
                    <tr>
                        <td>城市 City: </td>
                        <td>${form.address.homeCity}</td>
                    </tr> 
                    <tr>
                        <td>州/省 State/Province: </td>
                        <td>${form.address.homeState}</td>
                    </tr>
                    <tr>
                        <td>邮政编码 Zip code/Postal code:</td>
                        <td>${form.address.homeZip}</td>
                    </tr>
                    <tr>
                        <td>国家 Country:</td>
                        <td>${form.address.country}</td>
                    </tr>
                    <tr>
                        <td>联络电话 Primary Contact Phone#:</td>
                        <td>${form.address.homePhone}</td>
                    </tr>
                    <tr>
                        <td>电邮 Email: </td>
                        <td>${form.address.misc1}</td>
                    </tr>
                    <tr>
                        <td>所属教会/机构<br>
                            Church or Organization </td>
                        <td>${form.churchName} </td>
                    </tr>
                </tbody>
            </table>
            <hr style="width: 80%; height: 2px;">
            <c:forEach items="${form.registrants}" var="registrant" varStatus="count">
                <table style="text-align: left; margin-left: auto; margin-right: auto; border:2; width: 100%" >
                    <tbody>
                        <tr>
                            <td align="left" colspan="4"> 
                                <b>
                                    <c:set var="c" value="${count.count}"/>
                                    <c:if test="${count.index == 0}">  
                                        第 1 个人 (主报人) 的信息   Information of Primary Person 
                                    </c:if>     
                                    <c:if test="${count.index != 0}">  
                                        <hr style="width: 80%; height: 2px;">
                                        第 ${count.count} 个人的资料   Information of Person No. ${count.count} 
                                    </c:if>
                                </b>
                            </td>

                        </tr>
                        <tr>
                            <td width="25%">中文姓名 Chinese Name:</td>
                            <td width="25%">${registrant.person.chineseName}</td>
                            <td width="25%">性別 Gender:</td>
                            <td width="25%">
                                <c:set var="vgender" value="${registrant.person.gender}" />
                                <c:if test= "${vgender == 'M' }" > <c:set var="vgender" value="男Male" /></c:if>
                                <c:if test="${vgender == 'F' }"> <c:set var="vgender" value="女Female" /></c:if>
                                ${vgender}
                            </td>
                        </tr>
                        <tr>
                            <td>English Last Name:</td>
                            <td>${registrant.person.lastName}</td>
                            <td>English First Name:</td>
                            <td>${registrant.person.firstName}</td>
                        </tr>
                        <tr>
                            <td>年龄/年龄段 Age/Age Group:</td>
                            <td>
                                <c:set var="vage" value="${registrant.person.age}" />
                                <c:if test= "${vage == 'A2' }" > <c:set var="vage" value="18-29" /></c:if>
                                <c:if test= "${vage == 'A3' }" > <c:set var="vage" value="30-39" /></c:if>
                                <c:if test= "${vage == 'A4' }" > <c:set var="vage" value="40-49" /></c:if>
                                <c:if test= "${vage == 'A5' }" > <c:set var="vage" value="50-59" /></c:if>
                                <c:if test= "${vage == 'A6' }" > <c:set var="vage" value="60+" /></c:if>
                                <c:if test= "${vage == '17' }" > <c:set var="vage" value="17" /></c:if>
                                <c:if test= "${vage == '16' }" > <c:set var="vage" value="16" /></c:if>
                                <c:if test= "${vage == '15' }" > <c:set var="vage" value="15" /></c:if>
                                <c:if test= "${vage == '14' }" > <c:set var="vage" value="14" /></c:if>
                                <c:if test= "${vage == '13' }" > <c:set var="vage" value="13" /></c:if>
                                <c:if test= "${vage == '12' }" > <c:set var="vage" value="12" /></c:if>
                                <c:if test= "${vage == '11' }" > <c:set var="vage" value="11" /></c:if>
                                <c:if test= "${vage == '10' }" > <c:set var="vage" value="10" /></c:if>
                                <c:if test= "${vage == '9' }" > <c:set var="vage" value="9" /></c:if>
                                <c:if test= "${vage == '8' }" > <c:set var="vage" value="8" /></c:if>
                                <c:if test= "${vage == '7' }" > <c:set var="vage" value="7" /></c:if>
                                <c:if test= "${vage == '6' }" > <c:set var="vage" value="6" /></c:if>
                                <c:if test= "${vage == '5' }" > <c:set var="vage" value="5" /></c:if>
                                <c:if test= "${vage == '4' }" > <c:set var="vage" value="4" /></c:if>
                                <c:if test= "${vage == '3' }" > <c:set var="vage" value="3" /></c:if>
                                <c:if test= "${vage == '2' }" > <c:set var="vage" value="2" /></c:if>
                                <c:if test= "${vage == '1' }" > <c:set var="vage" value="1" /></c:if>
                                <c:if test= "${vage == '0' }" > <c:set var="vage" value="0" /></c:if>
                                ${vage}
                            </td>
                            <td>年级 Grade:</td>
                            <td>
                                <c:set var="vgrade" value="${registrant.person.status}" />
                                <c:choose> 
                                    <c:when test= "${vgrade == 'M' }" > <c:set var="vgrade" value="Married" /></c:when>
                                    <c:when test= "${vgrade == 'EN' }" > <c:set var="vgrade" value="Engaged" /></c:when>
                                    <c:when test= "${vgrade == 'S' }" > <c:set var="vgrade" value="Single" /></c:when>
                                    <c:when test= "${vgrade == 'GS' }" > <c:set var="vgrade" value="Graduate School" /></c:when>
                                    <c:when test= "${vgrade == 'C4' }" > <c:set var="vgrade" value="Undergrad - Sr" /></c:when>
                                    <c:when test= "${vgrade == 'C3' }" > <c:set var="vgrade" value="Undergrad - Jr" /></c:when>
                                    <c:when test= "${vgrade == 'C2' }" > <c:set var="vgrade" value="Undergrad - So" /></c:when>
                                    <c:when test= "${vgrade == 'C1' }" > <c:set var="vgrade" value="Undergrad - Fr" /></c:when>
                                    <c:when test= "${vgrade == '12th' }" > <c:set var="vgrade" value="十二年级12th Senior High - Sr" /></c:when>
                                    <c:when test= "${vgrade == '11th' }" > <c:set var="vgrade" value="十一年级11th Senior High - Jr" /></c:when>
                                    <c:when test= "${vgrade == '10th' }" > <c:set var="vgrade" value="十年级10th Senior High - So" /></c:when>
                                    <c:when test= "${vgrade == '9th' }" > <c:set var="vgrade" value="九年级9th Senior High - Fr" /></c:when>
                                    <c:when test= "${vgrade == '8th' }" > <c:set var="vgrade" value="八年级8th Junior High" /></c:when>
                                    <c:when test= "${vgrade == '7th' }" > <c:set var="vgrade" value="七年级7th Junior High" /></c:when>
                                    <c:when test= "${vgrade == '6th' }" > <c:set var="vgrade" value="六年级6th Junior High" /></c:when>
                                    <c:when test= "${vgrade == '5th' }" > <c:set var="vgrade" value="五年级5th grade" /></c:when>
                                    <c:when test= "${vgrade == '4th' }" > <c:set var="vgrade" value="四年级4th grade" /></c:when>
                                    <c:when test= "${vgrade == '3rd' }" > <c:set var="vgrade" value="三年级3rd grade" /></c:when>
                                    <c:when test= "${vgrade == '2nd' }" > <c:set var="vgrade" value="二年级2nd grade" /></c:when>
                                    <c:when test= "${vgrade == '1st' }" > <c:set var="vgrade" value="一年级1st grade" /></c:when>
                                    <c:when test= "${vgrade == 'K' }" > <c:set var="vgrade" value="Kindergarden" /></c:when>
                                    <c:when test= "${vgrade == 'P4' }" > <c:set var="vgrade" value="Preschool 4yrs" /></c:when>
                                    <c:when test= "${vgrade == 'P3' }" > <c:set var="vgrade" value="Preschool 3yrs" /></c:when>
                                    <c:when test= "${vgrade == 'TO' }" > <c:set var="vgrade" value="Toddlers (age 1-2)" /></c:when>
                                    <c:when test= "${vgrade == 'B' }" > <c:set var="vgrade" value="Baby < 1" /></c:when>
                                    <c:when test= "${vgrade == 'O' }" > <c:set var="vgrade" value="其他Other" /></c:when>
                                    <c:otherwise> <c:set var="vgrade" value="" /></c:otherwise>
                                </c:choose> 
                                ${vgrade}
                            </td>
                        </tr>
                        <tr>
                            <td>信主 Christian:</td>
                            <td>
                                <c:set var="vchristian" value="${registrant.person.acceptedChrist}" />
                                <c:if test= "${vchristian == 'true' }" > <c:set var="vchristian" value="是Yes" /></c:if>
                                <c:if test= "${vchristian == 'false' }" > <c:set var="vchristian" value="否No" /></c:if>
                                ${vchristian}
                            </td>
                        </tr>
                        <tr>
                            <td>參加聚會 Attend Event:</td>
                            <td>
                                <c:set var="vlanguage" value="${registrant.person.preferredLanguage}" />
                                <c:if test= "${vlanguage == 'M' }" > <c:set var="vlanguage" value="中文大会Chinese Conference" /></c:if>
                                <c:if test= "${vlanguage == 'E' }" > <c:set var="vlanguage" value="GRACE Confeence" /></c:if>
                                <c:if test= "${vlanguage == 'C' }" > <c:set var="vlanguage" value="1-5th" /></c:if>
                                <c:if test= "${vlanguage == 'K' }" > <c:set var="vlanguage" value="3yrs-K" /></c:if>
                                <c:if test= "${vlanguage == 'T' }" > <c:set var="vlanguage" value="1-2yrs"/></c:if>
                                ${vlanguage}
                            </td>
                        </tr>
                        <tr>
                            <td>事奉角色 Status:</td>
                            <td colspan="3">
                                <c:set var="vservingRole" value="${registrant.person.status}" />
                                <c:choose> 
                                    <c:when test= "${vservingRole == 'F' }" > <c:set var="vservingRole" value="F(全職傳道)" /></c:when>
                                    <c:when test= "${vservingRole == 'P' }" > <c:set var="vservingRole" value="P(教會牧者)" /></c:when>
                                    <c:when test= "${vservingRole == 'T' }" > <c:set var="vservingRole" value="T(神學生)" /></c:when>
                                    <c:when test= "${vservingRole == 'N' }" > <c:set var="vservingRole" value="N(機構同工)" /></c:when>
                                    <c:when test= "${vservingRole == 'C' }" > <c:set var="vservingRole" value="C(校園同工)" /></c:when>
                                    <c:when test= "${vservingRole == 'E' }" > <c:set var="vservingRole" value="E(教會長執)" /></c:when>
                                    <c:when test= "${vservingRole == 'S' }" > <c:set var="vservingRole" value="S(小組或團契同工)" /></c:when>
                                    <c:when test= "${vservingRole == 'O' }" > <c:set var="vservingRole" value="O(其他)" /></c:when>
                                    <c:otherwise> <c:set var="vservingRole" value="" /></c:otherwise>
                                </c:choose> 
                                ${vservingRole}
                            </td>
                        </tr>
                        <tr>
                            <td>电邮 &nbsp;Email:</td>
                            <td colspan="3">${registrant.person.email}</td>
                        </tr>
                    </tbody>
                </table>
            </c:forEach>
            <hr style="width: 80%; height: 2px;">
            <table align="center">
                <tbody>
                    <tr>
                        <td>总报名人数 Number of persons:</td>
                        <td>${form.registrants.size()}</td>
                    </tr>
                    <tr>
                        <td>总报名费 Total Registration Fee:</td>
                        <td>${form.paymentCurrency} $${form.expense.totalRegistrationFee}</td>
                    </tr>
                    <tr>
                        <td>总餐费 Total Meal Fee:</td>
                        <td>${form.paymentCurrency} $${form.expense.totalMealsFee}</td>
                    </tr>
                    <tr>
                        <td>总费用 Total:</td>
                        <td>${form.paymentCurrency} $${form.expense.totalMealsFee + form.expense.totalRegistrationFee}</td>
                    </tr>
                </tbody>
            </table>
            <hr style="width: 80%; height: 2px;" />

            <table align="center">
                <tbody>
                    <!-- the following code is commented out for issue83.
                    <tr>
                        <td>
                    <form:errors path="chkPmt" cssClass="fieldError"/>
                </td>
            </tr>
            <tr>
                <td> <form:checkbox path="chkPmt"/>
                    <span style="font-weight: bolder; font-size: 14px;">
                        I authorize CC Life to collect ${form.expense.totalMealsFee + form.expense.totalRegistrationFee}
                        from my account.</span><br />
                </td>
            </tr>  
                    -->
                    <tr>
                        <td>
                            <form:errors path="paymentMethod" cssClass="fieldError"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Payment methods 付款方式  <form:radiobutton id="creditcard" path="paymentMethod" value="CREDIT_CARD"/>Debit/Credit
                            Card&nbsp;&nbsp; <form:radiobutton id="check" path="paymentMethod" value="PERSONAL_CHECK"/>check </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <hr style="width: 80%; height: 2px;">

        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
        <button id="payment" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'payment', event: 'onclick', formId: 'review', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'previous', event: 'onclick', formId: 'review', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'review', params: {fragments: "body"}}));
        </script>
    </form:form>    

    <script type="text/javascript">
        function toggleDiv(area) {
            var toggleDivision = document.getElementById(area);
            if (!toggleDivision)
                return true;
            if (toggleDivision.style.display == "none") {
                toggleDivision.style.display = "block";
            } else {
                toggleDivision.style.display = "none";
            }
            return true;
        }

    </script>

</div>

