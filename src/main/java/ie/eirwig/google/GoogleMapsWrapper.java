package ie.eirwig.google;

import java.util.Arrays;
import java.util.logging.Logger;

import twitter4j.TwitterException;
import twitter4j.internal.http.HttpClientImpl;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpRequest;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.http.RequestMethod;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

/**
 * This Class encapsulates a Json Http Response from Google maps API as a Json
 * object.
 * 
 * @see http
 *      ://maps.googleapis.com/maps/api/geocode/json?address=Ireland&sensor=true
 * @see http://www.darrinward.com/lat-long/?id=9369
 * @author kieran
 */
public class GoogleMapsWrapper {

	private static Logger		LOGGER		= Logger.getLogger(GoogleMapsWrapper.class.getName());

	private static String		REQUEST_URL	= "http://maps.googleapis.com/maps/api/geocode/json";

	private final HttpResponse	response;

	public GoogleMapsWrapper(HttpParameter[] parameters) throws TwitterException {
		this(REQUEST_URL, parameters);
	}

	public GoogleMapsWrapper(String url, HttpParameter[] parameters) throws TwitterException {
		LOGGER.info("Requesting: " + url + " Parameters: " + Arrays.toString(parameters));
		HttpClientImpl client = new HttpClientImpl();
		HttpRequest req = new HttpRequest(RequestMethod.GET, url, parameters, null, null);
		response = client.request(req);
		LOGGER.info("Response: " + response);
	}

	public JSONObject getResponse() throws TwitterException, JSONException {
		return response.asJSONObject();
	}

	@Override
	public String toString() {
		return "GoogleMapsWrapper [response=" + response + "]";
	}

}
