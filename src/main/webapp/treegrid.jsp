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


<div id="gridbox" style="width:100%;height:400px;background-color:white;overflow:hidden"></div>

<dhtmlx:body name="initializeDHTMLX" imagePath="imgs/">
    <dhtmlx:treegrid name="treegrid" id="gridbox" imageURL="imgs/icons_greenfolders">
        <dhtmlx:column name="Tree" type="tree"/>
        <dhtmlx:column name="Plain Text" type="ed"/>
        <dhtmlx:column name="Long Text" type="txt"/>
        <dhtmlx:column name="Color" type="ch"/>
        <dhtmlx:column name="Checkbox" type="ch"/>
    </dhtmlx:treegrid>
</dhtmlx:body>



<body style="width:100%;height:400px;margin:0px;padding:0px;overflow:hidden;background-color:#ffffff; background-image:none;">
</body>
<script language="JavaScript" type="text/javascript">
    function initialize() {
        window.dhx_globalImgPath = "imgs/";
        initializeDHTMLX();
        treegrid.loadXML('tree_grid.xml');
        
    }
    dhtmlxEvent(window,"load", initialize);
</script>
</html>

