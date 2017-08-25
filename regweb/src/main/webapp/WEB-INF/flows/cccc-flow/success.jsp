<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18">
    <p class="success">网上注册成功!</p>

    <div id="content" >
        <p>亲爱的弟兄姊妹 Dear brother/sister</p>
        <br/>
        <p>
            谢谢您报名参加芝加哥華人基督徒大會2016！您在网上报名的大会为：${form.formID}。您注册的详细资料如下：Thank you for registering for Chicago Chinese Christian Conference!
        </p>
        <br/>
        <br/>
        <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
            <c:forEach items="${form.registrants}" var="registrant" varStatus="count">
                <span lang="ZH-CN" style="font-size: 11pt; font-family: SimHei; color: blue;">
                    ${registrant.person.chineseName} ${registrant.person.firstName} ${registrant.person.lastName}<br/>
                </span>
            </c:forEach>
        </p>
        <br/>
        <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
            <span lang="ZH-CN" style="font-size: 11pt; font-family: SimHei; color: blue;">
                用餐：${form.registrants.size()}人${form.expense.breakfastCount + form.expense.lunchCount + form.expense.dinnerCount}餐：
            </span>
        </p>
        <br/>
        <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
            <span lang="ZH-CN" style="font-size: 12pt; font-family: SimHei; color: blue;">
                您已经在网上支付大会费用：${form.paymentCurrency} $${form.expense.totalMealsFee + form.expense.totalRegistrationFee}，其中报名费：${form.paymentCurrency} $${form.expense.totalRegistrationFee}，餐费：${form.paymentCurrency} $${form.expense.totalMealsFee}。
            </span>
        </p>
        <br/>
        <h3><span class="Heading3Char">住宿 Lodging Reservation</span>:</h3>
        <p>大會不負責房間登記。請在12/18前直接向The Westin Lombard Yorktown Center旅館訂房與繳費，每房（可住1~4人）每晚&nbsp;$69(稅後)，先訂先得。訂房時，請電<a href="tel:630-719-8000">630-719-8000</a>指名參加Chicago Chinese Christian Conference以享受大會優惠，或上網&nbsp;<a href="http://www.cccm.ws/" target="_blank">www.cccm.ws</a>&nbsp;連線至旅館。若有問題請電<a href="tel:847-868-2226">847-868-2226</a>&nbsp;(葉麗玲)。</p>
        <p>To book hotel rooms, please contact and pay directly to <strong>The Westin Lombard Yorktown Center</strong> before 12/18/2016, at the discount room rate of $69.00 (tax included, 1~4 people per room per night). You may either&nbsp;call <a href="tel:630-719-8000">630-719-8000</a> and claim as attendees of the <strong>Chicago Chinese Christian Conference</strong> to take this conference discount rate, or book online by connecting to the <a href="https://www.starwoodmeeting.com/events/start.action?id=1608308454&key=D06659F" target="_blank">hotel website</a>. For any questions please call <a href="tel:847-868-2226">847-868-2226</a>&nbsp;(<strong>Ms. Lillian</strong>).</p>
        <h3><span class="Heading3Char">申請補助Financial Support</span>:</h3>
        <p>
            申請補助金者，請直接與葛甦姊妹聯繫(su6yliu@gmail.com)
        </p>
        <h3><span class="Heading3Char">詢問處 Questions</span>:</h3>
        <p>
            CCCM Phone芝華宣道的電話: 847-868-2226<br/>
            Email: cccc.register.1@gmail.com​<br/>
        </p>
        <h3><span class="Heading3Char">奉献 Donation</span>:</h3>
        <p>
            大會開支約1/4 來自報名費，其餘尚需會眾與教會奉献補足。支票抬頭請寫CCCM <br/>
            Registration fee covers only 25% of the conference expenses and operational costs which depend largely on your generous donations. You can make your tax deductible contribution to CCCC 2016 and/or GRACE 2016 by making a separate check to CCCM and please mail it to the address listed below.
        </p>
        <br/>
        <p>
            Mail to:<br/>
            CCCM (Chicago Chinese Christian Missions)<br/>
            631 Illinois Route 83<br/>
            Suite 204<br/>
            Bensenville, IL 60106
        </p>
        <br/>
        <p>Thank you for your generous heart!
            CCCC/GRACE 2016 Coordinators</p>
        <br/>
    </div>
    <p>
        <a id="startFlow" href="cccc-flow">Start Over</a>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: "startFlow", event: "onclick", params: {fragments: "body", mode: "embedded"}}));
        </script>
    </p>	
</div>
