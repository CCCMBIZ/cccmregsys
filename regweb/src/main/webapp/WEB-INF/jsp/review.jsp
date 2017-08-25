<%-- 
    Document   : review
    Created on : Nov 23, 2010, 12:53:15 AM
    Author     : CH1CHOO1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="all" href="/registration/styles/layout.css"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/blueprint/screen.css" />" media="screen, projection" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/blueprint/print.css" />"  media="print" />

        <script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>
        <title>Review your registration</title>
    </head>
    <body>
        <div id="page">
            <div id="header">
                <p align="center"><span class="style2">芝加哥 2014 基督徒大會報名表 Chicago Chinese Christian Conference 2014</span><br/>
                    主題:《覺醒--預備迎見你的神》 講員:饒孝楫、劉傳章、劉志雄...等牧師<br/>
                    時間: 12月27日(週六晚)開始,12月30日(週二午)結束 地點:Pheasant Run Resort (4051 East Main St., St. Charles, IL 60174)<br />
                </p>
            </div>
            <div id="content" align="left">

                <h3>Review your registration</h3>
                <p> This is your registration information. Please email <a href="mailto:registration@cccm.ws">registration@cccm.ws</a> if you need help with the registration</p>

                <table width="100%" border="0" cellspacing="2" cellpadding="1" >
                    <tr>
                        <td width="175" valign="top" bgcolor="#D9D9D9"><p style='line-height:normal'><b><span style='font-size:10.0pt'>英文姓 First Name </span></b></p></td>
                        <td width="162" valign="top" bgcolor="#D9D9D9"><p style='line-height:normal'><b><span style='font-size:10.0pt'>英文名 Last Name </span></b></p></td>
                        <td width="100" valign="top" bgcolor="#D9D9D9"><p align="center" style='text-align:center;line-height:normal'><b><span style='font-size:10.0pt'>中文姓名 Chinese Name </span></b></p></td>
                        <td width="48" valign="top" bgcolor="#D9D9D9"><p align="center" style='text-align:center;line-height:normal'><b><span style='font-size:10.0pt'>性別 M/F </span></b></p></td>
                        <td width="48" valign="top" bgcolor="#D9D9D9"><p align="center" style='text-align:center;line-height:normal'><b><span style='font-size:10.0pt'>年齡 Age </span></b></p></td>
                        <td width="300" valign="top" bgcolor="#D9D9D9">
                            <p style='line-height:normal'><b><span style='font-size:10.0pt'>專題 Seminar( <a href="#seminars">查寻專題</a></span></b>)</p>
                        </td>
                    </tr>
                    <c:forEach var="registration" items="${registrationList}">
                        <tr>
                            <td width="175" valign="top">${registration.firstName}</td>
                            <td width="162" valign="top">${registration.lastName}</td>
                            <td width="100" valign="top">${registration.chineseName}</td>
                            <td width="48" valign="top">${registration.gender}</td>
                            <td width="48" valign="top">${registration.age}</td>
                            <td width="300" valign="top">${registration.seminar}</td>
                        </tr>
                    </c:forEach>

                </table>
                <br/>
                <table width="100%" border="0" cellspacing="2" cellpadding="1">

                    <tr>
                        <td> <br/>注册号码 Registration Number:</td>
                        <td><br/>${assessment.registrationID}</td>
                    </tr>
                    <tr>
                        <td>報名日期 Registered Date:</td>
                        <td><span>
                                <fmt:formatDate pattern="MM/dd/yyyy" value="${assessment.registrationDate}" />
                            </span> </td>
                    </tr>
                    <tr>
                        <td>住址 Home Address</td>
                        <td><span>
                                ${assessment.homeStreetAddress}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>城市 City: </td>
                        <td><span>
                                ${assessment.homeCity}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>州 State: </td>
                        <td><span>
                                ${assessment.homeState}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>郵遞區號 Zip Code: </td>
                        <td><div>
                                ${assessment.homeZipCode}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>住家電話 Home Phone: </td>
                        <td>
                            <span>
                                ${assessment.homePhone}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>電郵 Email address: </td>
                        <td><span>
                                ${assessment.email}
                            </span>
                        </td>
                    </tr>

                </table>
                <br/>
                <table dir="ltr" style="height: 20px; width: 400px; text-align: left;"
                       border="0" cellpadding="0" cellspacing="0">
                    <tbody>
                        <tr>
                            <th style="background-color: white;"> <br>
                            </th>
                            <td bgcolor="white">
                                <p style="text-align: center;">第一天</p>
                            </td>
                            <td bgcolor="white">
                                <p style="text-align: center;">第二天</p>
                            </td>
                            <td bgcolor="white">
                                <p style="text-align: center;">第三天</p>
                            </td>
                            <td bgcolor="white">
                                <p style="text-align: center;">第四天</p>
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: white;"> <span style="width: 100px;">早
                                    餐 Breakfast</span> </th>
                            <td bgcolor="white">
                                <p style="text-align: center;"><span style="">n/a</span></p>
                            </td>
                            <td bgcolor="white">
                                <p style="text-align: center;">${registrationList[0].breakfast2}份</p>
                            </td>
                            <td bgcolor="white">
                                <p style="text-align: center;">${registrationList[0].breakfast3}份</p>
                            </td>
                            <td style="text-align: center;" bgcolor="white">
                                <p>${registrationList[0].breakfast4}份</p>
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: white;"> <span
                                    style="margin-top: 16px; height: 20px;">午餐 Lunch<span
                                        style="font-family: monospace;"><span class=""></span></span></span> </th>
                            <td bgcolor="white">
                                <p style="text-align: center;"><span style="">n/a</span></p>
                            </td>
                            <td bgcolor="white">
                                <p style="text-align: center;">${registrationList[0].lunch2}份</p>
                            </td>
                            <td bgcolor="white">
                                <p style="text-align: center;">${registrationList[0].lunch3}份</p>
                            </td>
                            <td style="text-align: center;"><p>${registrationList[0].lunch4}份</p>
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: white;">
                                晚餐 Dinner
                            </th>
                            <td bgcolor="white">
                                <p style="text-align: center;">${registrationList[0].dinner1}份</p>
                            </td>
                            <td bgcolor="white">
                                <p style="text-align: center;">${registrationList[0].dinner2}份</p>
                            </td>
                            <td bgcolor="white">
                                <p style="text-align: center;">${registrationList[0].dinner3}份</p>
                            </td>
                            <td style="text-align: center;" bgcolor="white">
                                <p><span style="">n/a</span></p>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <br/>
                <h3>Summary</h3>
                <table width="100%" border="1" cellspacing="0" cellpadding="0">
                    <tr>
                        <td valign="top" bgcolor="#D9D9D9">報名費计算</td>
                        <td valign="top" bgcolor="#D9D9D9">人数 Head Count</td>
                        <td valign="top" bgcolor="#D9D9D9">小計 Sub Fees</td>
                    </tr>
                    <tr>
                        <td>成人 Adults (age 18+)  - $${assessment.unitAdultRegistrationFee} x </td>
                        <td>${assessment.totalAdult}</td>
                        <td><span>
                                $${assessment.totalAdultRegistrationFee}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>青少年/兒童 Children/Youth (age 4-17) - $${assessment.unitNonAdultRegistrationFee} x </td>
                        <td>${assessment.totalNonAdult}</td>
                        <td><span>
                                $${assessment.totalNonAdultRegistrationFee}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>三歲以下 Baby/Toddlers (age 0-3) - free x </td>
                        <td>${assessment.totalBaby}</td>
                        <td><span>
                                $0
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>報名費合共 Total Registration Fees </td>
                        <td></td>
                        <td>
                            $${assessment.totalRegistrationFee}
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" bgcolor="#D9D9D9"> 膳食費计算 </td>
                        <td valign="top" bgcolor="#D9D9D9"> 份量 Meal Count </td>
                        <td valign="top" bgcolor="#D9D9D9"> 小計 Sub Fees</td>
                    </tr>
                    <tr>
                        <td>營養早餐與水果 Breakfasts: bun, fruit, cereal  - $5 x</td>
                        <td>${assessment.breakfastTotal}</td>
                        <td><span>
                                $${assessment.totalBreakfastFee}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>中式午餐飯盒 Lunches : Chinese box meal - $5 x</td>
                        <td>${assessment.lunchTotal}</td>
                        <td>
                            <span>
                                $${assessment.totalLunchFee}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>中式晚餐飯盒  Dinners: Chinese box meal - $8 x</td>
                        <td>${assessment.dinnerTotal}</td>
                        <td>
                            <span>
                                $${assessment.totalDinnerFee}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>膳食費合共Total Meal Fees</td>
                        <td></td>
                        <td>
                            <span>
                                $${assessment.totalMealsFee}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" bgcolor="#D9D9D9"> <br/> </td>
                        <td valign="top" bgcolor="#D9D9D9"> <br/> </td>
                        <td valign="top" bgcolor="#D9D9D9"> <br/> </td>
                    </tr>
                    <tr>
                        <td>總計 Total Fees (報名費registration fees + 膳食費meals fees) </td>
                        <td> <br/> </td>
                        <td><span>
                                $${assessment.grandTotal}
                            </span>
                        </td>
                    </tr>
                </table>
                <br/>
                <h3> Payment Status</h3>
                <table>
                    <tr>
                        <td> ${assessment.paymentStatus}</td>
                    </tr>
                    <tr><td><br/></td>
                    </tr>
                    <tr>
                        <td>
                            <b>If you have not made your payment. You may pay now with Credit Card or PayPal</b>
                            <p>Click button here</p>
                            <form:form method="post" modelAttribute="payObj" action="https://www.paypal.com/cgi-bin/webscr">
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
                                <p>
                                    <input type="image" src="http://www.paypal.com/en_US/i/btn/x-click-but06.gif" cssClass="button" key="button.pay" theme="simple"/>
                                </p>
                            </form:form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <br/>
                            <p>You may also pay by check. <b>INCLUDE YOUR Registration Number on the Memo line</b> and mail your Registration Fee and Meal Total check to
                                <br/>
                            </p>
                            <br/>
                            CCCM (Chicago Chinese Christian Missions)<br/>
                            631 Illinois Route 83<br/>
                            Suite 204 <br/>
                            Bensenville, IL 60106
                        </td>
                    </tr>
                </table>

                <br/>
                <h3 align="left"><a id="seminars">Seminar References  </a></h3>
                <h5 align="left">芝加哥2014華人基督徒大會中文成人節目規劃專題講座</h5>
                <table border="1" cellpadding="0" cellspacing="0" width="100%">
                    <tbody>
                        <tr>
                            <td width="27">
                                <p class="normal_text"
                                   style="text-align: center; line-height: 10pt;" align="center">編號<b> </b></p>
                            </td>
                            <td width="205">
                                <p class="normal_text"
                                   style="text-align: center; line-height: 10pt;" align="center"><b>12/28</b><b>星
                                        期日 專題時段#1 - 2:30-3:45pm</b></p>
                            </td>
                            <td width="30">
                                <p class="normal_text"
                                   style="text-align: center; line-height: 10pt;" align="center">編號<b> </b></p>
                            </td>
                            <td width="210">
                                <p class="normal_text"
                                   style="text-align: center; line-height: 10pt;" align="center"><b>12/28</b><b>星
                                        期日 專題時段#2 - 4:00-5:15pm</b></p>
                            </td>
                            <td width="28">
                                <p class="normal_text"
                                   style="text-align: center; line-height: 10pt;" align="center">編號<b> </b></p>
                            </td>
                            <td width="221">
                                <p class="normal_text"
                                   style="text-align: center; line-height: 10pt;" align="center"><b>12/29</b><b>星
                                        期一 專題時段#3 - 2:30-3:45pm</b></p>
                            </td>
                            <td width="32">
                                <p class="normal_text"
                                   style="text-align: center; line-height: 10pt;" align="center">編號<b> </b></p>
                            </td>
                            <td width="212">
                                <p class="normal_text"
                                   style="text-align: center; line-height: 10pt;" align="center"><b>12/29</b><b>星
                                        期一 專題時段#4 - 4:00-5:15pm</b></p>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;">K</span></span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">如何在職場傳福音？ （劉志雄）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><b>X</b></span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;"></span><span class="normal_text"
                                                   style="line-height: 10pt;">「你聽我的，就合一了！」（劉志雄）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;">Y</span></span><br/>
                            </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;"></span><span class="normal_text"
                                                   style="line-height: 10pt;">不是「信是得著的，就必得著」嗎？ （劉志雄）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;">U</span><br/>
                                </span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">變水為酒的婚姻 （劉志雄）</span></td>
                        </tr>
                        <tr>
                            <td valign="top"><span style="font-weight: bold;">A</span><br/>
                            </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">迷思與再思——基督徒的末世思維與眼光 （劉傳章）</span></td>
                            <td valign="top"><b>B</b></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;"></span><span class="normal_text"
                                                   style="line-height: 10pt;">迎見主再來應有的準備 （劉傳章）</span></td>
                            <td style="font-weight: bold;" valign="top"><span
                                    class="normal_text" style="text-align: center; line-height: 10pt;">C</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">如何理解聖經中關於末日的預言 （劉傳章）<span
                                        style="font-weight: bold; color: red;"></span><br/>
                                </span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;">D</span><span style="font-weight: bold; color: red;"></span> <br/>
                                </span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">最後一棒—末世的宣教含義與宣教契機 （黃光賜）</span></td>
                        </tr>
                        <tr>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt; font-weight: bold;">F</span><br/>
                            </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">如何使事奉有助靈命的成長（饒孝楫）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><b>E</b><b> </b></span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;"></span><span class="normal_text"
                                                   style="line-height: 10pt;">愈挫愈勇——勝過事奉中的創傷 （吳正群）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;">J</span></span><br/>
                            </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;"> </span><span class="normal_text"
                                                   style="line-height: 10pt;">同工爭執中的「你我他」：覺醒我的角色與責任 （饒孝楫）</span></td>
                            <td valign="top"><b>H</b><br/>
                            </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">江山代有才人出--培養教會事工接棒的土壤 （吳正群）</span> </td>
                        </tr>
                        <tr>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;">G</span><span style="font-weight: bold; color: red;"></span></span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">如何預備自己在宣教上有更深的參與 （黃光賜）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;">L</span></span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">人家不缺錢， 你該怎麼辦？——現今北美校園事工的策略 （林陳郁美）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;">M</span><br/>
                                </span></td>
                            <td valign="top">「我豈能不愛惜」——教會如何參與校園？（座談） （林志寰、郭韻芳、林恆志）<span class="normal_text"
                                                                                        style="line-height: 10pt;"></span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt; font-weight: bold;">N</span><br/>
                            </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">播種、澆灌、收割，如何“速成”？ （林陳郁美）-</span></td>
                        </tr>
                        <tr>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><b>P</b><b> </b></span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">聖經反對同性戀！！然後呢？ （葉顏瑋茵）</span></td>
                            <td valign="top"><span style="font-weight: bold;">S</span><span style="font-weight: bold; color: red;"></span><br/>
                            </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;"></span><span class="normal_text"
                                                   style="line-height: 10pt;">讓「微」聲遍滿全地 （基甸）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;"></span></span><span
                                    style="font-weight: bold;">Q</span> </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">從同性婚姻合法化的衝突，思索社會的多元與尊重 （葉顏瑋茵）</span></td>
                            <td valign="top"><b>T</b></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">網路的「箴言」vs. 生命的真理 （基甸） <span
                                        style="font-weight: bold; color: red;"></span><br/>
                                </span></td>
                        </tr>
                        <tr>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><b>R</b><b> </b></span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">神國好聲音在哪裡？ （基甸）</span></td>
                            <td valign="top"><span style="font-weight: bold;">Z2</span><br/>
                            </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;"></span><span class="normal_text"
                                                   style="line-height: 10pt;">與神親近，何等甘美（下） （王祈）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;"></span></span><span
                                    style="font-weight: bold;">V1</span> </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">培養優質下一代（上） （王祈）</span></td>
                            <td valign="top"><b>V2</b></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">培養優質下一代（下） （王祈） <span
                                        style="font-weight: bold; color: red;"></span><br/>
                                </span></td>
                        </tr>
                        <tr>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><b>Z1</b><b> </b></span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">與神親近，何等甘美 （上） （王祈）</span></td>
                            <td valign="top"><span style="font-weight: bold;">O</span><br/>
                            </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;"></span><span class="normal_text"
                                                   style="line-height: 10pt;">星火燎原─讓你的禱告震動列國 （黃光賜）</span></td>
                            <td valign="top"><span class="normal_text"
                                                   style="text-align: center; line-height: 10pt;"><span
                                        style="font-weight: bold;"></span></span><span
                                    style="font-weight: bold;">W1</span> </td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">憂鬱症：教會裡的隱形殺手（上） （石平南）</span></td>
                            <td valign="top"><b>W2</b></td>
                            <td valign="top"><span class="normal_text"
                                                   style="line-height: 10pt;">憂鬱症：教會裡的隱形殺手（下） （石平南）<span
                                        style="font-weight: bold; color: red;"></span><br/>
                                </span></td>
                        </tr>
                    </tbody>
                </table>

            </div>
            <div id="footer" align="center">
                <p>
                    <b><span style='font-size:11.0pt;'>Be sure to visit <a href="javascript:void(0)" onclick="window.open('http://www.cccm.ws/CCCM/cccmcccc.html', 'CCCC', 'height=500,width=700,menubar=yes,toolbar=yes,directories=yes,location=yes,resizable=yes,scrollbars=yes');">http://www.cccm.ws/CCCM/cccmcccc.html</a> for all the latest updates for CCCC 2014.</span></b>
                </p>
            </div>
        </div>
    </body>
</html>
