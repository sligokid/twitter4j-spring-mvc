function isIE() {
	var ua = window.navigator.userAgent;
	var msie = ua.indexOf("MSIE ");

	if (msie > 0) // If Internet Explorer, return version number
		return true;
	else
		return false;
}