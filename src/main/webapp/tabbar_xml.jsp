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



<div id="tab_a1" style="display:none">
    <dhtmlx:security hasPermission="tab-1">
        <dhtmlx:granted>
            The content has been <font color="green"><b>granted</b></font>
        </dhtmlx:granted>
        <dhtmlx:denied>
            The content has been <font color="red"><b>denied</b></font>
        </dhtmlx:denied>
    </dhtmlx:security>
</div>

<div id="tab_a2" style="display:none">
    <a href="logout.jsp">Logout</a>
</div>

<dhtmlx:body name="initializeDHTMLX" imagePath="imgs/" i18n="ResourceBundle">
    <dhtmlx:tabbar name="tabbar" id="document.body" xml="tabbar.xml" />
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

