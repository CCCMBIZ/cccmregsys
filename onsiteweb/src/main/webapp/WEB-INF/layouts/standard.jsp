<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>芝加哥2016華人基督徒大會 网上报名</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
        <link rel="stylesheet" href="<c:url value="/resources/styles/blueprint/screen.css" />" type="text/css" media="screen, projection" />
        <link rel="stylesheet" href="<c:url value="/resources/styles/blueprint/print.css" />" type="text/css" media="print" />
        <!--[if lt IE 8]>
                <link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection" />
        <![endif]-->
        <script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>
    </head>
    <body class="tundra">
        <div id="page" class="container">
            <div align="center">
                <img src="<c:url value="/resources/styles/images/ccccgracebanner.jpg" />" width="785" height="88" alt="芝加哥2016華人基督徒大會 网上报名" align="center"/>
                <br/>
                <hr/>
            </div>
            <div>
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
    </body>
</html>