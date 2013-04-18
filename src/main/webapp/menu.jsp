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


<body style="width:100%;height:400px;margin:0px;padding:0px;overflow:hidden;background-color:#ffffff; background-image:none;">
<div style="height: 250px;"><div id="menu"></div></div>
</body>

<dhtmlx:body name="initializeDHTMLX">
    <dhtmlx:menu name="main_menu" id="menu" iconsPath="imgs/">
        <dhtmlx:menuSibling id="file" text="File" >
            <dhtmlx:menuChild id="new" text="New" position="0" imageEnabled="new.gif">
                <dhtmlx:menuChild id="subNew1" text="Sub-New-1" position="0"/>
                <dhtmlx:menuSeparator nextTo="subNew1"/>
                <dhtmlx:menuChild id="subNew2" text="Sub-New-2" position="2"/>
            </dhtmlx:menuChild>
            <dhtmlx:menuSeparator nextTo="subNew1"/>
            <dhtmlx:menuChild id="save" text="Save" position="2"/>
            <dhtmlx:menuRadioButton id="radio1" text="Radio 1" position="3" group="radio"/>
            <dhtmlx:menuRadioButton id="radio2" text="Radio 2" position="4" group="radio"/>
            <dhtmlx:menuCheckBox id="check" text="Check 1" position="5"/>
        </dhtmlx:menuSibling>
    </dhtmlx:menu>
</dhtmlx:body>

<script language="JavaScript" type="text/javascript">
    function initialize() {
        window.dhx_globalImgPath = "imgs/";
        initializeDHTMLX();
    }

    dhtmlxEvent(window,"load", initialize);
</script>
</html>

