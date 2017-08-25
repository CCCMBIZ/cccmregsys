<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18"> 
    <p class="notice"><b>專題講座題目與時間Seminar for Chinese conference ONLY</b><br></p>
        <form:form id="seminar" action="${flowExecutionUrl}" modelAttribute="form" acceptCharset="UTF-8">
        <table border="1" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
                <tr>
                    <td rowspan="4" width="8"><br/>
                    </td>
                    <td rowspan="4" width="340"><br/>
                    </td>
                    <td colspan="5" bgcolor="#ccffff">
                        <p style="text-align: center; line-height: 11pt;" align="center"><b>成
                                人中文專題研討登記表 </b></p>
                    </td>
                </tr>
                <tr>
                    <td colspan="5">
                        <p style="text-align: center; line-height: 10pt;" align="center">請
                            參考下面「專題研討表」，每人在每一時段請選一個專題，並將編號填入下面欄位（兒童,青少年免填寫）。 </p>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p style="text-align: center; line-height: 10pt;" align="center">12/29星期4下午</p>
                    </td>
                    <td colspan="3">
                        <p style="text-align: center; line-height: 10pt;" align="center">12/30星期5下午</p>
                    </td>
                </tr>
                <tr>
                    <td width="99">
                        <p style="text-align: center; line-height: 10pt;" align="center"><b>專
                                題時段#1</b> </p>
                    </td>
                    <td width="100">
                        <p style="text-align: center; line-height: 10pt;" align="center"><b>專
                                題時段#2</b> </p>
                    </td>
                    <td width="100">
                        <p style="text-align: center; line-height: 10pt;" align="center"><b>專
                                題時段#3</b> </p>
                    </td>
                    <td width="100">
                        <p style="text-align: center; line-height: 10pt;" align="center"><b>專
                                題時段#4</b> </p>
                    </td>
                </tr>
                <c:forEach items="${form.registrants}" varStatus="registrant">
                    <tr>
                        <c:set var="index" value="${registrant.index}"/>
                        <td><strong>${registrant.index+1}</strong></td>
                        <td width="340">${form.registrants[index].person.firstName} &#160; ${form.registrants[index].person.lastName} &#160; ${form.registrants[index].person.chineseName}</td>
                        <td width="99">
                            <form:select path="registrants[${registrant.index}].seminar.session1" multiple="false"> 
                                <form:option value="" label="-- 專題 --"/> 
                                <form:option value="F1" label="F1"/> 
                                <form:option value="G" label="G"/> 
                                <form:option value="T1" label="T1"/> 
                                <form:option value="X1" label="X1"/> 
                                <form:option value="C1" label="C1"/> 
                                <form:option value="N1" label="N1"/>
                                <form:option value="A" label="A"/> 
                            </form:select><br/>
                        </td>
                        <td width="100">
                            <form:select path="registrants[${registrant.index}].seminar.session2" multiple="false"> 
                                <form:option value="" label="-- 專題 --"/> 
                                <form:option value="F2" label="F2"/> 
                                <form:option value="T2" label="T2"/> 
                                <form:option value="B" label="B"/>
                                <form:option value="X2" label="X2"/>
                                <form:option value="C2" label="C2"/>
                                <form:option value="N2" label="N2"/> 
                                <form:option value="M" label="M"/>
                            </form:select><br/>
                        </td>
                        <td width="100">
                            <form:select path="registrants[${registrant.index}].seminar.session3" multiple="false"> 
                                <form:option value="" label="-- 專題 --"/> 
                                <form:option value="D" label="D"/>
                                <form:option value="S" label="S"/>
                                <form:option value="K" label="K"/>
                                <form:option value="P1" label="P1"/>
                                <form:option value="W" label="W"/>
                                <form:option value="J" label="J"/>
                                <form:option value="Q" label="Q"/>
                            </form:select><br/>
                        </td>
                        <td width="100">
                            <form:select path="registrants[${registrant.index}].seminar.session4" multiple="false"> 
                                <form:option value="" label="-- 專題 --"/> 
                                <form:option value="H" label="H"/> 
                                <form:option value="R" label="R"/> 
                                <form:option value="E" label="E"/> 
                                <form:option value="P2" label="P2"/> 
                                <form:option value="V" label="V"/>
                                <form:option value="L" label="L"/>
                                <form:option value="U" label="U"/>
                            </form:select><br/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <hr style="width: 100%; height: 2px;">
        <p style="line-height: 12pt;"><b>IV. </b><b>成人中文專題研討表</b>
            每人每一時段請選一專題，在上面專題登記表填入編號。大會將按登記人數和場地容量作最後的分配。(所有信息將在會後製作光碟， 請注意訂購單的服務) 
        </p>
        
        <p>&nbsp;</p>
        <table style="height: 582px;"  width="779"  border="1" cellpadding="0" cellspacing="0" >
            <tbody>
                <tr>  
                    <td colspan="2" width="576">
                        <h4><strong>12/29 (Thu)</strong></h4>
                    </td>
                    <td colspan="2" width="576">
                        <h4><strong>12/30 (Fri)</strong></h4>
                    </td>
                </tr>
                <tr>
                    <td width="432">
                        <p>專題時段#1 (2:30-3:45pm)</p>
                    </td>
                    <td width="144">
                        <p>專題場地</p>
                    </td>
                    <td width="432">
                        <p>專題時段#3 (2:30-3:45pm)</p>
                    </td>
                    <td width="144">
                        <p>專題場地</p>
                    </td>
                </tr>
                <tr>
                    <td width="432">
                        <p>F1 從制度面落實教會的聖潔見證-上（林祥源）</p>
                        <p>G 交的出、接的上的事工傳承（朱正中）</p>
                        <p>T1 幸福選擇題#1--單身樂無窮（王祈）</p>
                        <p>X1 危機四伏的靈界探索-上（李前明）</p>
                        <p>C1 從友誼到佈道-上（滕張佳音）</p>
                        <p>N1 依靠神清除內在生命的垃圾-上（劉富理）</p>
                        <p>A 建立教會與校園的夥伴關係（高智浩）</p>
                        <p>&nbsp;</p>
                    </td>
                    <td width="144">
                        <p>尚未確定</p>
                    </td>
                    <td width="432">
                        <p>D 教會新挑戰─北美華人人口結構快速轉變（林祥源）</p>
                        <p>S 愛火重燃（王祈）</p>
                        <p>K 如何復興教會的禱告會（劉富理）</p>
                        <p>P1 與當代及現實接軌的讀經生活-上（賴若瀚）</p>
                        <p>W 當科學遇到信仰（袁岱青）</p>
                        <p>J 同工間的衝突與復和（朱正中）</p>
                        <p>Q 幫助子女面對政治導向的壓力（高智浩）</p>
                        <p>&nbsp;</p>
                    </td>
                    <td width="144">
                        <p>尚未確定</p>
                    </td>
                </tr>
                <tr>
                    <td width="432">
                        <p>專題時段#2 (4:00-5:15pm)</p>
                    </td>
                    <td width="144">
                        <p>專題場地</p>
                    </td>
                    <td width="432">
                        <p>專題時段#4 (4:00-5:15pm)</p>
                    </td>
                    <td width="144">
                        <p>專題場地</p>
                    </td>
                </tr>
                <tr>
                    <td width="432">
                        <p>F2 從制度面落實教會的聖潔見證-下（林祥源）</p>
                        <p>T2 幸福選擇題#2--拍拖全攻略（王祈）</p>
                        <p>B 跨越鴻溝&mdash;向年轻世代宣教（梁偉光）</p>
                        <p>X2 危機四伏的靈界探索-下（李前明）</p>
                        <p>C2 從友誼到佈道-下（滕張佳音）</p>
                        <p>N2 依靠神清除內在生命的垃圾-下（劉富理）</p>
                        <p>M 優化EQ與靈命（朱正中）</p>
                    </td>
                    <td width="144">
                        <p>尚未確定</p>
                    </td>
                    <td width="432">
                        <p>H 北美粵語教會的未來（林祥源）</p>
                        <p>R 與E世代子女溝通（王祈）</p>
                        <p>E 讓英文部走出小媳婦的地位（Ronald Rothenburg）</p>
                        <p>P2 與當代及現實接軌的讀經生活-下（賴若瀚）</p>
                        <p>V 福音信仰問題解答（李前明、袁岱青）</p>
                        <p>L 献上&ldquo;厨餘&rdquo;祭？！&mdash;事奉心態總體驗（滕張佳音）</p>
                        <p>U 神與我事業的規劃（朱正中）</p>
                        <p>&nbsp;</p>
                    </td>
                    <td width="144">
                        <p>尚未確定</p>
                    </td>
                </tr>
            </tbody>
        </table>
        <p>&nbsp;</p>
        <hr style="width: 100%; height: 2px;">
        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'seminar', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'previous', event: 'onclick', formId: 'seminar', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'seminar', popup: true, params: {fragments: "body"}}));
        </script>

    </form:form>
</div>


