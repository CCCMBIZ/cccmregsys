<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18"> 
    <p class="notice"><b>3b. 徵求義工服事<br/>Step 3b – Volunteer Interest</b></p>
            <form:form id="volunteer" action="${flowExecutionUrl}" modelAttribute="form" acceptCharset="UTF-8">
        <table style="text-align: left; width: 1072px; height: 32px;" border="0"
               cellpadding="2" cellspacing="2">

            <tbody>
                <tr>
                    <td colspan="3">
                        請勾選願意服事的岡位<br/>
                        Please check which area(s) you are interested in serving as a volunteer<br/> 
                        <hr style="width: 700px; height: 2px;">
                    </td>
                </tr>
                <c:forEach items="${form.registrants}" varStatus="registrant">
                    <tr>
                        <td style="vertical-align: top; width: 50px;">
                            ${form.registrants[registrant.index].person.firstName} &#160; ${form.registrants[registrant.index].person.lastName} &#160; ${form.registrants[registrant.index].person.chineseName}
                        </td>
                        <td style="vertical-align: top; width: 100px;">
                            <p>飯食 – Meal service&nbsp;<form:checkbox path="registrants[${registrant.index}].volunteerJobs" value="FOOD_SERVICE"/></p>
                            <p>招待 – Usher & reception desk&nbsp;<form:checkbox path="registrants[${registrant.index}].volunteerJobs" value="USHERS"/></p>
                            <p>兒童 - Childcare&nbsp;<form:checkbox path="registrants[${registrant.index}].volunteerJobs" value="NURSERY_HELPER"/></p>
                        </td>
                        <td style="vertical-align: top; width: 200px;">
                            <p>禱告 – Prayer group&nbsp;<form:checkbox path="registrants[${registrant.index}].volunteerJobs" value="PRAYER_TEAM"/></p>
                            <p>粵語翻譯 – Cantonese interpreter&nbsp;<form:checkbox path="registrants[${registrant.index}].volunteerJobs" value="CANTONESE_INTERPRETER"/></p>
                            <p>英語翻譯 – English interpreter&nbsp;<form:checkbox path="registrants[${registrant.index}].volunteerJobs" value="ENGLISH_INTERPRETER"/></p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <hr style="width: 700px; height: 2px;">
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'volunteer', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'previous', event: 'onclick', formId: 'volunteer', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'volunteer', popup: true, params: {fragments: "body"}}));
        </script>

    </form:form>
</div>


