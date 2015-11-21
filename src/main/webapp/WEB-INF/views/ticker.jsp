<!DOCTYPE html>
<html>
	<body>
		<h1>Current Server Time :</h1>

		<div id="ServerTime"></div>

		<script>
		if (typeof (EventSource) !== "undefined") {
	    		var source = new EventSource( "/eirwig-spring-mvc/Ticker");
	        	source.onmessage = function( event) {
		    		document.getElementById("ServerTime").innerHTML = event.data + "<br><br>";
	     		};
         } else { document .getElementById("ServerTime").innerHTML = "Sorry, your browser does not support server-sent events...";
         }
		</script>

</body>
</html>