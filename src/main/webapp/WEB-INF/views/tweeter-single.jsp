<!DOCTYPE html>
<html>
	<body>
		<h1>Latest Tweet :</h1>

		<div id="Tweet"></div>

		<script>
		if (typeof (EventSource) !== "undefined") {
	    		var source = new EventSource( "/eirwig-spring-mvc/TwitterIreland");
	        	source.onmessage = function( event) {
		    		document.getElementById("Tweet").innerHTML = event.data + "<br><br>";
	     		};
         } else { document .getElementById("Tweet").innerHTML = "Sorry, your browser does not support server-sent events...";
         }
		</script>

</body>
</html>