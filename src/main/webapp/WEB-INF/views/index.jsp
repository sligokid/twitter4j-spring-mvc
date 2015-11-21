<html>
<head>
<title>Eirwig</title>
<link rel="stylesheet" href="/eirwig-spring-mvc/resources/mytheme/css/eirwig_new.css" type="text/css" />
<link rel="stylesheet" href="/eirwig-spring-mvc/resources/mytheme/css/lightbox.css" type="text/css" />
<link rel="stylesheet" href="/eirwig-spring-mvc/resources/mytheme/css/table.css">
<link rel="shortcut icon" type="image/png" href="/eirwig-spring-mvc/resources/img/favicon.png" />
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="/eirwig-spring-mvc/resources/mytheme/js/heatmap.js"></script>
<script type="text/javascript" src="/eirwig-spring-mvc/resources/mytheme/js/heatmap-gmaps.js"></script>
<script type="text/javascript" src="/eirwig-spring-mvc/resources/mytheme/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/eirwig-spring-mvc/resources/mytheme/js/lightbox.min.js"></script>
<!--  Not working in IE
<script type="text/javascript" async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
 -->
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
												<%@ include file="menu.jsp"%>
								</div>

								<div id="heatmap">
												<h3>Eirwig - The world is listening</h3>
												<blockquote>
																It has been said that something as small 
																as the flutter of a butterfly's wing can ultimately cause a typhoon 
																halfway around the world.  
												</blockquote>
												<cite>The Butterfly Effect - Chaos Theory</cite>
												<br>
												<p class="p2">Eirwig is a social media experiment to demonstrate how easily a simple
																flutter of your wing (a tweet) can make it to the other side of the world. It is a fun way to combine
																live user tweets and embedded geo location information with Google maps and population density statistics.
																
												<blockquote>
																What you do and say on twitter is viewable worldwide and your location can be pinpointed to your front door.
												</blockquote>
												<cite>- @sligokid</cite>
												<p class="p2">You can use Eirwig to</p>
												<ol>
																<li class="p1">View <strong>live streaming</strong> of tweets being sent right now in Ireland or Worldwide</li>
																<li class="p1">View a <strong>live heat map</strong> of where exactly these tweets are coming from</li>
																<li class="p1">Play <strong>twitter roulette</strong> to see a new image sourced from twitter every 3 seconds (Not
																				Safe For Work!)</li>
																<li class="p1">Find out where all the <strong>single men and women</strong> are living in Ireland - go cupid!</li>
																<li class="p1">The more you watch the more you see.</li>
												</ol>
												<p class="p1">Get the app from the app store to view Ireland specific tweets and population density on
																your phone.</p>

												<p class="p1">Twitter is a wonderfully powerful resource, we @earwig_ie are huge fans - but with great
																power comes great responsibility.</p>
												<p class="p1">Enjoy - @sligokid @brianmcgowanire
								</div>
								<div id="panel">
												<div id="rdiv">
																<%@ include file="index-r.jsp"%>
												</div>
								</div>
				</div>
				<div id="debug"></div>
</body>
</html>