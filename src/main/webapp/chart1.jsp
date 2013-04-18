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
<div id="chart" style="width:100%;height:100%"></div>
</body>
<script>
	var data = [
		{ "companyA":"-1.9", "companyB":1, year:"2000" },
		{ "companyA":"-0.8", "companyB":0.8, year:"2001" },
		{ "companyA":"3.4", "companyB":1.9, year:"2002" },
		{ "companyA":"4.1", "companyB":2.5, year:"2003" },
		{ "companyA":"4.3", "companyB":3.1, year:"2004" },
		{ "companyA":"5.9", "companyB":4.5, year:"2005" },
		{ "companyA":"6.1", "companyB":5.7, year:"2006" },
		{ "companyA":"6.5", "companyB":7.2, year:"2007" },
		{ "companyA":"5.2", "companyB":6.5, year:"2008" },
		{ "companyA":"4.8", "companyB":6.8, year:"2009" }
	];


    function initialize() {
		var chart1 =  new dhtmlXChart({
			view:"line",
			container:"chart",
	    	value:"#companyA#",
			item:{
				borderColor: "#3399ff",
				color: "#ffffff"
			},
			xAxis:{
				template:"#year#"
			},
			yAxis:{
				start:-2,
				step:1,
				end:8
			},
			padding:{
				left:35,
				bottom:20
			},
            label : "#sales#",
            tooltip : "tooltip",
			origin:0,
			legend:{
				layout:"x",
				width: 75,
				align:"center",
				valign:"bottom",
				marker:{
					type:"round",
					width:15
				},
				values:[
					{text:"company A",color:"#3399ff"},
					{text:"company B",color:"#66cc00"}
				]
			}
		})


		chart1.addSeries({
			value:"#companyB#",
			item:{
				borderColor: "#66cc00",
				color: "#ffffff",
			},
			line:{
				color:"#66cc00",
				width:3,
			}
		})
		chart1.parse(data,"json");
    }

    dhtmlxEvent(window,"load", initialize);

	</script>
</html>

