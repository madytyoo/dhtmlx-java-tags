<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.mylaensys.com/dhtmlx" prefix="dhtmlx" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
		<title></title>
		<link href="dhtmlx.css" rel="stylesheet" type="text/css" />
		<style>html,body{width:100%;height:100%;margin:0px;padding:0px;overflow:hidden;}</style>
	</head>
<script language="JavaScript" type="text/javascript" src="dhtmlx.js"></script>
<dhtmlx:body name="initializeDHTMLX">
	<dhtmlx:layout name='layout_1' id='document.body'  pattern='2E' >
		<dhtmlx:layoutcell name='a' text='a' id='html_1'>
		</dhtmlx:layoutcell>
		<dhtmlx:layoutcell name='b' text='b'>
		</dhtmlx:layoutcell>
	</dhtmlx:layout>
</dhtmlx:body>    
<div id='html_1'>
<p>Hello, world</p>

</div>
<body>
</body>
</html>

<script language='JavaScript' type='text/javascript'>
	function initialize() {
		initializeDHTMLX();
	}
	dhtmlxEvent(window,'load', initialize);
</script>