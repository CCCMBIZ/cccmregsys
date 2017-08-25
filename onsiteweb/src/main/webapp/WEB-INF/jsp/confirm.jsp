<%-- 
    Document   : confirm
    Created on : Oct 25, 2010, 5:16:33 PM
    Author     : CH1CHOO1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

        <title>Thank you for your payment</title>
    </head>
    <body>
        <div id="page">
            <div id="header">
                <p align="center"><span class="style2">芝加哥 2016 基督徒大會報名表 Chicago Chinese Christian Conference 2016</span><br/>
                    主題:《覺醒--預備迎見你的神》 講員:饒孝楫、劉傳章、劉志雄...等牧師<br/>
                    時間: 12月27日(週六晚)開始,12月30日(週二午)結束 地點:Pheasant Run Resort (4051 East Main St., St. Charles, IL 60174)<br />
                </p>
            </div>
            <div id="content" align="left">
                <h1>Thank you for your payment. Your registration is completed. Please save your record.</h1>
                <p>
                    Thank you for registration. We received your payment. The total amount paid is $<c:out value="${amountPaid}" />. Please print this review page for your record.
                </p>
                <p>Your Confirmation Number is <c:out value="${registrationId}" /></p>
                <h3><span class="Heading3Char">网上查询注册資料Check Your registration Online</span>:</h3>
                <p> 您可以随时查询您的具体注册信息，如已注册的人/家人，勾选的饭食，专题选择等。 </p>
                <ol type="1">
                    <li>请点击这里进入  <a href="javascript:void(0)" onclick="window.open('http://cccm.biz/registration/lookupById.htm', 'Pheasant Run Resort', 'height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');">http://cccm.biz/registration/lookupById.htm</a></li>
                    <li>请在方框内填写您的注册号码，然后点击“enter”进入查看您的註冊資料。</li>
                </ol>                  
                </p>
                <h3><span class="Heading3Char">住宿Lodging Reservation</span>:</h3>
                <p>
                    請在 12/17 前直接向 Pheasant Run Resort 旅館訂房與繳費，每房（可住 1~4 人）每晚 $65(稅後)，先訂先得；大會不負責房間登記。訂房時，請電 1-800-474-3272 指名 “CCCM Group” 以享受大會優惠，或上網 <a href="javascript:void(0)" onclick="window.open('https://bookings.ihotelier.com/Pheasant-Run-Resort/bookings.jsp?groupID=1134840&hotelID=2932', 'Pheasant Run Resort', 'height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');">Pheasant Run Resort Hotel Reservation</a>  連線至旅館，以享受大會優惠。若有問題請電 847-868-2226 (葉麗玲)。
                </p>
                <h3><span class="Heading3Char">申請補助Financial Support</span>:</h3>
                <p>
                    申請補助金者，請直接與洪玉純姊妹聯繫(supermire@hotmail.com)
                </p>
                <h3><span class="Heading3Char">詢問處Question</span>:</h3>
                <p>
                    CCCM Phone芝華宣道的電話: 8478682226<br/>
                    Email: cccm4u@gmail.com<br/>
                </p>
                <h3><span class="Heading3Char">奉献Donation</span>:</h3>
                <p>
                    大會開支約1/4 來自報名費，其餘尚需會眾與教會奉献補足。支票抬頭請寫CCCM 
                    Registration fee covers only 25% of the conference expenses and operational costs which depend largely on your generous donations. You can make your tax deductible contribution to CCCC 2012 and/or GRACE 2012 by making a separate check to CCCM and please mail it to the address listed below.
                </p>
                <p>Mail to:</p>
                <p>
                    CCCM (Chicago Chinese Christian Missions)<br/>
                    631 Illinois Route 83<br/>
                    Suite 204<br/>
                    Bensenville, IL 60106
                </p>
                <p>Thank you for your generous heart!</p>
                <p>CCCC 2016 &#38; GRACE 2016 Coordinators</p>
                <br/>
            </div>
            <div id="footer" align="center">
                <p>
                    <b><span style='font-size:11.0pt;'>Be sure to visit <a href="javascript:void(0)" onclick="window.open('http://www.cccm.ws/CCCM/cccmcccc.html', 'CCCC', 'height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');">http://www.cccm.ws/CCCM/cccmcccc.html</a> for all the latest updates for CCCC 2016.</span></b>
                </p>
            </div>
        </div>
    </body>
</html>
