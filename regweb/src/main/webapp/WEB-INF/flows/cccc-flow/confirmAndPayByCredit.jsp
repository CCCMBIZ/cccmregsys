<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow"  class="span-18">
    <p class="notice">Step 6 - Pay by Credit</p>
    <hr style="width: 80%; height: 2px;">
    <div id="content" align="left">
        <h3>Pay by CREDIT CARD or PayPal 付款方式：信用卡或PayPal</h3>
        <div>
            <table>
                <tr>
                    <td>
                        <b>I authorize CCCM to collet $${form.expense.totalMealsFee + form.expense.totalRegistrationFee} from my account.</b>
                    </td>
                </tr>
                <tr>
                    <td>
                        我授权芝华宣道团从我的账号中支取下述金额：$${form.expense.totalMealsFee + form.expense.totalRegistrationFee}
                    </td>
                </tr>
            </table>
            <hr/>
            <p>在您点击“Pay Now”进入下一页前，请阅读有以下的注意事项：Please follow instructions below for payment options in next page:</p> 
            <ul type="circle">
                <li>如果您有Paypal账户,請使用 <font color="red"><b>OPTION 1</b></font> 輸入账号與密碼登录PayPal账户。<br/>If you have Paypal account, please use <font color="red"><b>OPTION 1</b></font> to login and make a payment.</li>
                <li>如果您使用信用卡付款,請使用 <font color="red"><b>OPTION 2</b></font> 点击"Pay with Debit or Credit Card" 按钮前進用卡付款。<br/>If you wish to pay with debit or credit card, please use <font color="red"><b>OPTION 2</b></font>, click the button to pay with debit/credit card</li>
                <li>请勿点击浏览器的退回键，以免丢失您的所有信息。Please do not use back button of browser.</li>
            </ul>

            <div align="center">
                <img src="<c:url value="/resources/styles/images/PaymentOptionsB.jpg" />" width="378" height="336" align="center"/>
                <br/>
                <hr/>
            </div>
            <b>点击下方图标付款. Please click button below to make payment</b>
            <br/>
            <br/>
            <form:form method="post" modelAttribute="paymentProvider" action="${paymentUrl}">
                <form:hidden path="cmd"/>
                <form:hidden path="redirect_cmd"/>
                <form:hidden path="business"/>
                <form:hidden path="item_name"/>
                <form:hidden path="item_number"/>
                <form:hidden path="amount"/>
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
                <p>
                    <input type="image" src="http://www.paypal.com/en_US/i/btn/x-click-but06.gif" cssClass="button" key="button.pay" theme="simple"/>
                </p>
            </form:form>
        </div>

    </div>


</div>