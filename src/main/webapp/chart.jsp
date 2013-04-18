<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.mylaensys.com/dhtmlx" prefix="dhtmlx" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
		<title></title>
		<link href="dhtmlx.css" rel="stylesheet" type="text/css" />
		<style>html,body{width:100%;height:100%;margin:0px;padding:0px;overflow:hidden;}</style>
		<link href="stylesheet.css" rel="stylesheet" type="text/css" />
	</head>
<script language="JavaScript" type="text/javascript" src="dhtmlx.js"></script>
<body>
</body>
</html>
<dhtmlx:body name='initializeDHTMLX' imagePath='imgs/'>
	<dhtmlx:layout name='layout_1' id='document.body'  pattern='2E' >
		<dhtmlx:layoutcell name='a' text='a' i18n='false' >
			<dhtmlx:areaChart  name='chart__1' value='#y#' alpha='1'>
				<dhtmlx:chartAxisX title='X axis' template='#x#' lines='true' />
				<dhtmlx:chartAxisY title='Y axis' lines='true' />
			</dhtmlx:areaChart>
		</dhtmlx:layoutcell>
		<dhtmlx:layoutcell name='b' text='b' i18n='false' >
		</dhtmlx:layoutcell>
	</dhtmlx:layout>
</dhtmlx:body>
<script language='JavaScript' type='text/javascript'>
	function initialize() {
		initializeDHTMLX();
    
        chart__1.load("sample_chart.xml");
	}
	dhtmlxEvent(window,'load', initialize);
</script>




