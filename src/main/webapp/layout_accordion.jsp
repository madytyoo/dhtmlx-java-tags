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

<div id="main_layout" style="position:absolute;width:960px; height:600px;">
</div>


<div id="layout_a">
    Hello World
</div>
<dhtmlx:body name="initializeDHTMLX">
    <dhtmlx:layout name="main_layout" id="main_layout" pattern="3L">
        <dhtmlx:layoutcell name="a" text="Hello" id="layout_a" fixWidth="true" hideHeader="true">
            <dhtmlx:layout name="layout_2"  pattern="3L"/>
        </dhtmlx:layoutcell>
        <dhtmlx:layoutcell name="b">
            <dhtmlx:accordion name="main_accordion" openItem="a2">
                <dhtmlx:accordioncell name="a1" text="First" id="accodion_a1" hasRole="manager,pluto"/>
                <dhtmlx:accordioncell name="a2" text="Second" hasRole="manager,pluto"/>
                <dhtmlx:accordioncell name="a3" text="Third" hasRole="manager"/>
            </dhtmlx:accordion>
        </dhtmlx:layoutcell>
    </dhtmlx:layout>
</dhtmlx:body>

<body style="width:100%;height:400px;margin:0px;padding:0px;overflow:hidden;background-color:#ffffff; background-image:none;">
</body>
<script language="JavaScript" type="text/javascript">
    function doOnExpand(item) {
        alert("onExpand item " + item );
    }
    function doOnCollapse(item) {
        alert("onCollapse item " + item );
    }

    function doOnPanelResize(ids) {
        alert("doOnPanelResize items are  " + ids.toString() );
    }
    function initialize() {
        window.dhx_globalImgPath = "imgs/";
        initializeDHTMLX();
        alert(main_layout.cells("a").getText());
    }

    dhtmlxEvent(window,"load", initialize);
</script>
</html>

