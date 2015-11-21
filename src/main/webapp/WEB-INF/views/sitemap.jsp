<html>
   <head>
      <title>Eirwig</title>
      <link rel="stylesheet" href="/eirwig-spring-mvc/resources/mytheme/css/eirwig_new.css" type="text/css" />
      <link rel="shortcut icon" type="image/png" href="/eirwig-spring-mvc/resources/img/favicon.png" />
      <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
      <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
      <script type="text/javascript" src="/eirwig-spring-mvc/resources/mytheme/js/heatmap.js"></script>
      <script type="text/javascript" src="/eirwig-spring-mvc/resources/mytheme/js/heatmap-gmaps.js"></script>
      <script type="text/javascript"  async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
       <%@ include file="analytics.jsp"%>
   </head>
   <body>
   
   <style type="text/css">
   #heatmap {
				position: relative;
				float: left;
				width: 800px;
				height: 600px;
				border: 1px dashed black;
				overflow-y: auto;
	}
   </style>
   
      <div id="main">
      	<div id="menu">
 	  	<%@ include file="menu.jsp" %> 
 	  	</div>
 	  
      	<div id="heatmap">
      		<div id="lsitemap">
   				<%@ include file="sitemap-l.jsp" %> 
      		</div>
      		<div id="rsitemap">
   				<%@ include file="sitemap-r.jsp" %> 
      		</div>
      	</div>
      	 <div id="panel">
         	<div id="rdiv" >
         	</div>
      	</div>
      </div>
      <div id="debug"></div>
   </body>
</html>