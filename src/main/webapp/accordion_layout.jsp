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

<div id="accodion_a1">
    Hello World
</div>
<dhtmlx:body name="initializeDHTMLX" imagePath="imgs/">
    <dhtmlx:accordion name="main_accordion" id="document.body" openItem="a1">
        <dhtmlx:accordioncell name="a1" text="First" id="accodion_a1" hasRole="manager,pluto">
            <dhtmlx:layout name="layout_1"  pattern="3L"/>
        </dhtmlx:accordioncell>
        <dhtmlx:accordioncell name="a2" text="Second" hasRole="manager,pluto">
            <dhtmlx:tabbar name="tabbar_1">
                <dhtmlx:tab  name="a1" text="Tab-a1"/>
                <dhtmlx:tab  name="a2" text="Tab-a2"/>
            </dhtmlx:tabbar>                                
        </dhtmlx:accordioncell>
        <dhtmlx:accordioncell name="a3" text="Third" hasRole="manager"/>        
    </dhtmlx:accordion>
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

