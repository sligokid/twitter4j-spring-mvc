<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring4 MVC -HelloWorld</title>
<link rel="shortcut icon" type="image/png" href="/eirwig-spring-mvc/resources/img/favicon.png" />
</head>
<body> 

<h2>Index</h2>

<ol>
	<li><h3>[Controllers]</h3></li>
	<ol>
		<li><h4><a href="ticker">Latest Time</a></h4></li>
		<li><h4><a href="tweeter-single">Latest Tweet</a></h4></li>
		<li><h4><a href="tweeter-all">Latest Tweets Scrolling</a></h4></li>
		<li><h4><a href="world">World Tweets</a></h4></li>
		<li><h4><a href="world-roulette">World Roulette</a></h4></li>
		<li><h4><a href="ireland">Ireland Tweets</a></h4></li>
		<li><h4><a href="ireland-roulette">Ireland Roulette</a></h4></li>
		<li><h4><a href="cso-world">CSO World</a></h4></li>
		<li><h4><a href="cso-population">CSO Population</a></h4></li>
		<ol>
			<li><h5><a href="cso-population?single-t">Single Men & Women</a></h5></li>
			<li><h5><a href="cso-population?single-m">Single Men</a></h5></li>
			<li><h5><a href="cso-population?single-f">Single  Women</a></h5></li>
			<li><h5><a href="cso-population?ethnic-ie">Irish Nationals</a></h5></li>
			<li><h5><a href="cso-population?ethnic-uk">British Nationals</a></h5></li>
			<li><h5><a href="cso-population?ethnic-pl">Polish Nationals</a></h5></li>
			<li><h5><a href="cso-population?ethnic-lt">Lithuanian Nationals</a></h5></li>
		</ol>
	</ol>
</ol>

<h2>Stream Endpoints</h2>
<ol>
	<li><h3>[Servlets]</h3></li>
	<ol>
		<li><h4><a href="Ticker">Ticker</a></h4></li>
		<li><h4><a href="TwitterSample">TwitterSample</a></h4></li>
		<li><h4><a href="TwitterSampleImage">TwitterSampleImage</a></h4></li>
		<li><h4><a href="TwitterIreland">TwitterIreland</a></h4></li>
		<li><h4><a href="TwitterIrelandImage">TwitterIrelandImage</a></h4></li>
		<li><h4><a href="CSO">CSO</a></h4></li>
		<ol>
			<li><h5><a href="CSO">CSO Popolation </a></h4></li>
			<li><h5><a href="CSO?key=single-t">Single Men & Women</a></h4></li>
			<li><h5><a href="CSO?key=single-m">Single Men</a></h4></li>
			<li><h5><a href="CSO?key=single-f">Single  Women</a></h4></li>
			<li><h5><a href="CSO?key=ethnic-ie">Irish Nationals</a></h4></li>
			<li><h5><a href="CSO?key=ethnic-uk">British Nationals</a></h4></li>
			<li><h5><a href="CSO?key=ethnic-pl">Polish Nationals</a></h4></li>
			<li><h5><a href="CSO?key=ethnic-lt">Lithuanian Nationals</a></h4></li>
		</ol>
	</ol>
</ol>

<h2>REST Endpoint (Press Refresh for new Object)</h2>
<ol>
		<li><h4><a href="TwitterIrelandREST">TwitterIrelandREST</a></h4></li>
</ol>
</body>
</html>