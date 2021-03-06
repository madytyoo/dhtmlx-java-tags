<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://www.mylaensys.com/dhtmlx" prefix="dhtmlx" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <title>DHTMLX TagLib</title>
    <link href="dhtmlx.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript" type="text/javascript" src="dhtmlx.js"></script>


<div id="toolbar"></div>

<dhtmlx:body name="initializeDHTMLX">
    <dhtmlx:toolbar name="toolbar" id="toolbar">
        <dhtmlx:toolbarText id="first" position="0" text="first"/>
        <dhtmlx:toolbarSeparator id="first" position="1"/>
        <dhtmlx:toolbarButton id="second" position="2" text="second"/>
        <dhtmlx:toolbarButtonSelect id="third" position="3" text="third">
            <dhtmlx:toolbarListOption id="third1" position="1" type="button" text="third-1"/>
            <dhtmlx:toolbarListOption id="third2" position="2" type="separator" text="third-2"/>
            <dhtmlx:toolbarListOption id="third3" position="3" type="button" text="third-3"/>
        </dhtmlx:toolbarButtonSelect>
        <dhtmlx:toolbarButtonTwoState id="twostate" position="4" text="TwoStates"/>
        <dhtmlx:toolbarSeparator id="first" position="5"/>
        <dhtmlx:toolbarInput id="first" position="6"/>
        <dhtmlx:toolbarSeparator id="first" position="7"/>
        <dhtmlx:toolbarSlider id="slider" position="8"/>
    </dhtmlx:toolbar>
</dhtmlx:body>

<body style="width:100%;height:400px;margin:0px;padding:0px;overflow:hidden;background-color:#ffffff; background-image:none;">
</body>
<script language="JavaScript" type="text/javascript">
    function initialize() {
        window.dhx_globalImgPath = "imgs/";
        initializeDHTMLX();
    }
    dhtmlxEvent(window,"load", initialize);
</script>
</html>

