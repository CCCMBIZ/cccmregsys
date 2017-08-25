<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18"> 
    <p class="notice"><b>4. 勾選餐點</b><br>Step 4 - Order Meals </p>

    <form:form id="mealPlan" action="${flowExecutionUrl}" modelAttribute="form" acceptCharset="UTF-8">

        <table style="border-collapse: collapse; width: 617px;" border="0" cellspacing="0" cellpadding="0">
            <thead>
                <tr style="height: 31.5pt;">
                    <td class="xl66" style="height: 31.5pt; width: 74pt;" width="98" height="42">&nbsp;</td>
                    <td class="xl67" style="width: 5pt;" width="6">&nbsp;</td>
                    <td class="xl69" style="width: 128px; font-weight: bold;">12/28 (Wed)</td>
                    <td class="xl69" style="width: 129px; font-weight: bold;">12/29 (Thu)</td>
                    <td class="xl69" style="width: 127px; font-weight: bold;">12/30 (Fri)</td>
                    <td class="xl69" style="width: 123px; font-weight: bold;">12/31 (Sat)</td>
                </tr>
            </thead>
            <tbody>
                <tr style="height: 25pt;">
                    <td class="xl70" style="height: 35.25pt; font-weight: bold;" height="47">Breakfast $5</td>
                    <td class="xl67">&nbsp;</td>
                    <td class="xl68" style="width: 128px; font-family: monospace;">&nbsp;</td>
                    <td class="xl66" style="width: 129px;">&nbsp;&nbsp;(粥,牛奶,水果,中式麵包Porridge , milk, fruit , Chinese bread)</td>
                    <td class="xl66" style="width: 127px;">&nbsp;&nbsp;(粥,牛奶,水果,中式麵包Porridge , milk, fruit , Chinese bread)</td>
                    <td class="xl66" style="width: 123px;">&nbsp;&nbsp;(粥,牛奶,水果,中式麵包Porridge , milk, fruit , Chinese bread)</td>
                </tr>
                <tr style="height: 6pt;">
                    <td style="height: 6pt;" height="8">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td class="xl67" style="width: 128px; font-family: monospace;">&nbsp;</td>
                    <td class="xl67" style="width: 129px;">
                        <form:select id="breakfast2" path="registrants[0].mealplan.breakfast2">
                            <form:option value="0" />
                            <form:option value="1" />
                            <form:option value="2" />
                            <form:option value="3" />
                            <form:option value="4" />
                            <form:option value="5" />
                            <form:option value="6" />
                            <form:option value="7" />
                            <form:option value="8" />
                            <form:option value="9" />
                        </form:select>份
                    </td>
                    <td class="xl67" style="width: 127px;">
                        <form:select id="breakfast3" path="registrants[0].mealplan.breakfast3">
                            <form:option value="0" />
                            <form:option value="1" />
                            <form:option value="2" />
                            <form:option value="3" />
                            <form:option value="4" />
                            <form:option value="5" />
                            <form:option value="6" />
                            <form:option value="6" />
                            <form:option value="7" />
                            <form:option value="8" />
                            <form:option value="9" />
                        </form:select>份
                    </td>
                    <td class="xl67" style="width: 123px;">
                        <form:select id="breakfast4" path="registrants[0].mealplan.breakfast4">
                            <form:option value="0" />
                            <form:option value="1" />
                            <form:option value="2" />
                            <form:option value="3" />
                            <form:option value="4" />
                            <form:option value="5" />
                            <form:option value="6" />
                            <form:option value="6" />
                            <form:option value="7" />
                            <form:option value="8" />
                            <form:option value="9" />
                        </form:select>份
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">&nbsp;</td>
                    <td style="vertical-align: top;">&nbsp;</td>
                    <td style="vertical-align: top; width: 128px;">&nbsp;</td>
                    <td style="vertical-align: top; width: 9;">&nbsp;</td>
                    <td style="vertical-align: top; width: 127px;">&nbsp;</td>
                    <td style="vertical-align: top; width: 123px;">&nbsp;</td>
                </tr>
                <tr style="height: 39pt;">
                    <td class="xl70" style="height: 39pt; font-weight: bold;" height="52">Lunch $6</td>
                    <td class="xl67">&nbsp;</td>
                    <td class="xl68" style="width: 128px; font-family: monospace;">&nbsp;</td>
                    <td class="xl72" style="width: 129px;">&nbsp;Hot Dog &amp; Pizzia</td>
                    <td class="xl71" style="width: 127px;">
                        <p>&nbsp;撈麵或<br />Chicken Nuggets</p>
                    </td>
                    <td class="xl72" style="width: 123px;">&nbsp;Chicken Sandwich</td>
                </tr>
                <tr style="height: 6.75pt;">
                    <td class="xl67" style="height: 6.75pt;" height="9">&nbsp;</td>
                    <td class="xl67">&nbsp;</td>
                    <td class="xl67" style="width: 128px;">&nbsp;</td>
                    <td class="xl67" style="width: 129px;">
                        <form:select id="lunch2" path="registrants[0].mealplan.lunch2">
                            <form:option value="0" />
                            <form:option value="1" />
                            <form:option value="2" />
                            <form:option value="3" />
                            <form:option value="4" />
                            <form:option value="5" />
                            <form:option value="6" />
                            <form:option value="6" />
                            <form:option value="7" />
                            <form:option value="8" />
                            <form:option value="9" />
                        </form:select>份
                    </td>
                    <td class="xl67" style="width: 127px;">
                        <form:select id="lunch3" path="registrants[0].mealplan.lunch3">
                            <form:option value="0" />
                            <form:option value="1" />
                            <form:option value="2" />
                            <form:option value="3" />
                            <form:option value="4" />
                            <form:option value="5" />
                            <form:option value="6" />
                            <form:option value="6" />
                            <form:option value="7" />
                            <form:option value="8" />
                            <form:option value="9" />
                        </form:select>份
                    </td>
                    <td class="xl67" style="width: 123px;">
                        <form:select id="lunch4" path="registrants[0].mealplan.lunch4">
                            <form:option value="0" />
                            <form:option value="1" />
                            <form:option value="2" />
                            <form:option value="3" />
                            <form:option value="4" />
                            <form:option value="5" />
                            <form:option value="6" />
                            <form:option value="6" />
                            <form:option value="7" />
                            <form:option value="8" />
                            <form:option value="9" />
                        </form:select>份
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">&nbsp;</td>
                    <td style="vertical-align: top;">&nbsp;</td>
                    <td style="vertical-align: top; width: 128px;">&nbsp;</td>
                    <td style="vertical-align: top; width: 129px;">&nbsp;</td>
                    <td style="vertical-align: top; width: 127px;">&nbsp;</td>
                    <td style="vertical-align: top; width: 123px;">&nbsp;</td>
                </tr>
                <tr style="height: 39.75pt;">
                    <td class="xl70" style="height: 39.75pt; font-weight: bold;" height="53">Dinner $9</td>
                    <td class="xl67">&nbsp;</td>
                    <td class="xl66" style="width: 128px;">&nbsp;<em>中餐Chinese Food</em></td>
                    <td class="xl66" style="width: 129px;">&nbsp;<em>中餐Chinese Food</em></td>
                    <td class="xl66" style="width: 127px;">&nbsp;<em>中餐Chinese Food</em></td>
                    <td class="xl68" style="width: 123px;">&nbsp;</td>
                </tr>
                <tr>
                    <td style="vertical-align: top;">&nbsp;</td>
                    <td style="vertical-align: top;">&nbsp;</td>
                    <td style="vertical-align: top;">
                        <form:select id="dinner1" path="registrants[0].mealplan.dinner1">
                            <form:option value="0" />
                            <form:option value="1" />
                            <form:option value="2" />
                            <form:option value="3" />
                            <form:option value="4" />
                            <form:option value="5" />
                            <form:option value="6" />
                            <form:option value="6" />
                            <form:option value="7" />
                            <form:option value="8" />
                            <form:option value="9" />
                        </form:select>份
                    </td>
                    <td style="vertical-align: top;">
                        <form:select id="dinner2" path="registrants[0].mealplan.dinner2">
                            <form:option value="0" />
                            <form:option value="1" />
                            <form:option value="2" />
                            <form:option value="3" />
                            <form:option value="4" />
                            <form:option value="5" />
                            <form:option value="6" />
                            <form:option value="6" />
                            <form:option value="7" />
                            <form:option value="8" />
                            <form:option value="9" />
                        </form:select>份
                    </td>
                    <td style="vertical-align: top;">
                        <form:select id="dinner3" path="registrants[0].mealplan.dinner3">
                            <form:option value="0" />
                            <form:option value="1" />
                            <form:option value="2" />
                            <form:option value="3" />
                            <form:option value="4" />
                            <form:option value="5" />
                            <form:option value="6" />
                            <form:option value="6" />
                            <form:option value="7" />
                            <form:option value="8" />
                            <form:option value="9" />
                        </form:select>份
                    </td>
                    <td style="vertical-align: top;">N/A</td>
                </tr>
            </tbody>
        </table>
        <hr style="width: 80%; height: 2px;">
        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'mealPlan', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'previous', event: 'onclick', formId: 'mealPlan', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'mealPlan', popup: true, params: {fragments: "body"}}));
        </script>

    </form:form>
</div>


