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
    Layout a
</div>
<dhtmlx:body name="initializeDHTMLX" imagePath="imgs/">
    <dhtmlx:layout name="main_layout" id="main_layout" pattern="3L">
        <dhtmlx:layoutcell name="a" text="Hello" id="layout_a" fixWidth="true" hideHeader="true"/>
        <dhtmlx:layoutcell name="b">
            <dhtmlx:menu name="cell_b_menu" iconsPath="/img">
                <dhtmlx:menuSibling id="menu_b" text="Menu Cell B">
                    <dhtmlx:menuChild id="sub" text="Sub Menu" position="0">
                        <dhtmlx:menuChild id="subNew1" text="Sub-New-1" position="0"/>
                        <dhtmlx:menuSeparator nextTo="subNew1"/>
                        <dhtmlx:menuChild id="subNew2" text="Sub-New-2" position="2"/>
                    </dhtmlx:menuChild>
                    <dhtmlx:menuSeparator nextTo="subNew1"/>
                    <dhtmlx:menuChild id="item" text="Item" position="2"/>
                    <dhtmlx:menuRadioButton id="radio1" text="Radio 1" position="3" group="radio"/>
                    <dhtmlx:menuRadioButton id="radio2" text="Radio 2" position="4" group="radio"/>
                    <dhtmlx:menuCheckBox id="check" text="Check 1" position="5"/>
                </dhtmlx:menuSibling>
            </dhtmlx:menu>            
        </dhtmlx:layoutcell>
        <dhtmlx:layoutcell name="c">
        </dhtmlx:layoutcell>
    </dhtmlx:layout>
</dhtmlx:body>

<body style="width:100%;height:400px;margin:0px;padding:0px;overflow:hidden;background-color:#ffffff; background-image:none;">
</body>
<script language="JavaScript" type="text/javascript">
    function initialize() {
        window.dhx_globalImgPath = "imgs/";
        initializeDHTMLX();
        alert(main_layout.cells("a").getText());
    }

    dhtmlxEvent(window,"load", initialize);
</script>
</html>

