<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="popupFlow" >
    <p class="error">You have chosen to cancel. Your data will be lost.</p>
    <div >
        <form:form id="confirmation" action="${flowExecutionUrl}" acceptCharset="UTF-8">
            <button id="return" type="submit" name="_eventId_return">&lt;&lt; Return</button>
            <button id="continue" type="submit" name="_eventId_continue">Continue &gt;&gt;</button>

            <script type="text/javascript">
                Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'return', event: 'onclick', formId: 'confirmation'}));
                Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'continue', event: 'onclick', formId: 'confirmation'}));
            </script>
        </form:form>
    </div>
</div>