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
      <div id="main">
      <div id="menu">
 	  <%@ include file="menu.jsp" %> 
 	  </div>
      <div id="heatmap">
      	<img alt="" src="/eirwig-spring-mvc/resources/mytheme/img/app-1.png" height="600">
      	<img alt="" src="/eirwig-spring-mvc/resources/mytheme/img/app-2.png" height="600">
      </div>
      </div>
      <div id="panel">
         <div id="rdiv" >
         <a href="https://play.google.com/store/apps/details?id=com.beezer.eirwig" target=_blank">
  <img alt="Android app on Google Play"
       src="https://developer.android.com/images/brand/en_app_rgb_wo_60.png" />
</a>
         </div>
      </div>
      </div>
      <div id="debug"></div>
   </body>
</html>