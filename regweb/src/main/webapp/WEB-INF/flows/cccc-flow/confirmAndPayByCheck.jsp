<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow"  class="span-18">
    <p class="success">Final Step - Pay by Check</p>    
    <div id="content" >
        <p>亲爱的弟兄姊妹Dear brother/sister</p>
        <br/>
        <p>
            感謝您註冊芝加哥華人基督徒大會2016！Thank you for registering for Chicago Chinese Christian Conference! 
        </p>
        <br/>
        <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
            <span lang="ZH-CN" style="font-size: 11pt; font-family: SimHei; color: blue;">
                <b>
                    谢谢您选择以支票付款。手續要在費用繳清後才完成，請在一星期內繳清費用${form.paymentCurrency} $${form.expense.totalRegistrationFee+form.expense.totalMealsFee}，否則報名資料將取消。支票抬头请写：CCCM，请在Memo中注明：CCCC2016，并请注明您的大会报名确认码ID ${form.formID}。请将支票寄至：
                    To complete your registration process. Please print this receipt and send your total payment within one week. Please <b>INCLUDE YOUR Registration Number on the Memo line</b> and mail ${form.paymentCurrency} $${form.expense.totalRegistrationFee+form.expense.totalMealsFee} check to
                </b>
            </span>
        </p>
        <br/>
        <p>
            CCCM (Chicago Chinese Christian Missions)<br/>
            631 Illinois Route 83<br/>
            Suite 204 <br/>
            Bensenville, IL 60106
        </p>
        <br/>
        <p>
            此邮件为确认您的注册费用以及订餐记录。总计付款$${form.expense.totalRegistrationFee+form.expense.totalMealsFee}，其中报名费：$${form.expense.totalRegistrationFee}，餐费：$${form.expense.totalMealsFee}。This email is to confirm your registration fee and meals. The total amount paid is $${form.expense.totalRegistrationFee+form.expense.totalMealsFee}.  This amount covers your conference fee and meals only.
        </p>
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
        <h3><span class="Heading3Char">住宿 Lodging Reservation</span>:</h3>
        <p>
            大會不負責房間登記。請在12/18前直接向The Westin Lombard Yorktown Center旅館訂房與繳費，每房（可住1~4人）每晚&nbsp;$69(稅後)，先訂先得。訂房時，請電<a href="tel:630-719-8000">630-719-8000</a>指名參加Chicago Chinese Christian Conference以享受大會優惠，或上網&nbsp;<a href="http://www.cccm.ws/" target="_blank">www.cccm.ws</a>&nbsp;連線至旅館。若有問題請電<a href="tel:847-868-2226">847-868-2226</a>&nbsp;(葉麗玲)。
        </p>
        <p>
            To book hotel rooms, please contact and pay directly to <strong>The Westin Lombard Yorktown Center</strong> before 12/18/2016, at the discount room rate of $69.00 (tax included, 1~4 people per room per night). You may either&nbsp;call <a href="tel:630-719-8000">630-719-8000</a> and claim as attendees of the <strong>Chicago Chinese Christian Conference</strong> to take this conference discount rate, or book online by connecting to the <a href="https://www.starwoodmeeting.com/events/start.action?id=1608308454&key=D06659F" target="_blank">hotel website</a>. For any questions please call <a href="tel:847-868-2226">847-868-2226</a>&nbsp;(<strong>Ms. Lillian</strong>).
        </p>
        <br/>
        <h3><span class="Heading3Char">申請補助 Financial Support</span>:</h3>
        <p>
            申請補助金者，請直接與葛甦姊妹聯繫(su6yliu@gmail.com) For financial support, please contact Su Ge at su6yliu@gmail.com.
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
        <div align="center" id="footer">
            <p>
                <b>
                    <span style="font-size:11.0pt;">Be sure to visit <a onClick="window.open('http://cccm.ws', 'CCCC2016', 'height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');" href="javascript:void(0)">http://cccm.ws</a> for all the latest updates for CCCC 2016.
                    </span>
                </b>
            </p>
        </div>
    </div>
</div>
