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
      <div id="heatmap"></div>
      <div id="panel">
         <div id="rdiv" >
         </div>
      </div>
      </div>
      <div id="debug"></div>
      
      
      <script type="text/javascript">
      	var  maxTweets = 50;
      	var count = 0;
         var map;
         var heatmap; 
        	 window.onload = function() {
        	 			var myLatlng = new google.maps.LatLng(53.41291, -8.24389);
                  	var myOptions = {
                  	zoom: 7,
         			mapTypeId: google.maps.MapTypeId.HYBRID,
                  	center: myLatlng,
                  	disableDefaultUI: false,
                  	scrollwheel: true,
                  	draggable: true,
                  	navigationControl: true,
                  	mapTypeControl: true,
                  	scaleControl: true,
                  	 disableDoubleClickZoom: false
            };
         	
         	map = new google.maps.Map(document.getElementById("heatmap"), myOptions);	
         	heatmap = new HeatmapOverlay(map, {
         		"radius":10, 
         		"visible":true, 
         		"opacity":50,
         		});
         
         };
         
         if (typeof (EventSource) !== "undefined") {
         var source = new EventSource("/eirwig-spring-mvc/TwitterIreland");
          		source.onmessage = function(event)  {
           		document.getElementById("debug").innerHTML = event.data;
           		obj = JSON.parse(event.data);
           		heatmap.addDataPoint(obj.lat, obj.lng, 1);
           		if (count == maxTweets) {
          			 $("#rdiv").empty();
          			count = 0;
          		}
          		count++;
        			printTweet(obj.id);
           	};
         	} else {
          		document.getElementById("debug").innerHTML = "Sorry, your browser does not support server-sent events...";
          	}
      </script>
      <script type="text/javascript">
         function printTweet(id){
         $.ajax({
                 url: "https://api.twitter.com/1/statuses/oembed.json?id="+id+"&align=right&width=150",
                 dataType: "jsonp",
                 success: function(data){
                 $("#rdiv").append(data.html);
                 }
             });
         }
      </script>
   </body>
</html>