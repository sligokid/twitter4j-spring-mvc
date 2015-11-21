package ie.eirwig.google;

import java.util.Arrays;
import java.util.logging.Logger;

import twitter4j.GeoLocation;
import twitter4j.TwitterException;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

/**
 * This Class parses geographical location coordinates from a GoogleMapsWrapper.
 */
public class GeoLocationBox {

	private static Logger	LOGGER	= Logger.getLogger(GeoLocationBox.class.getName());

	private double[][]		locationArray;

	public GeoLocationBox(GoogleMapsWrapper response) throws TwitterException, JSONException {
		LOGGER.info("Response: " + response);
		JSONObject jsonResponse = response.getResponse();
		JSONArray jsonResultArray = (JSONArray) jsonResponse.get("results");
		LOGGER.info("JSON status: " + jsonResponse.get("status"));

		JSONObject jsonResultElement = jsonResultArray.getJSONObject(0);
		JSONObject jsonGeometry = (JSONObject) jsonResultElement.get("geometry");

		JSONObject bounds = getGeolocationBounds(jsonGeometry);
		JSONObject northeast = (JSONObject) bounds.get("northeast");
		JSONObject southwest = (JSONObject) bounds.get("southwest");

		LOGGER.info("NE: " + northeast);
		LOGGER.info("SW: " + southwest);
		setLocationArray(northeast, southwest);
	}

	private JSONObject getGeolocationBounds(JSONObject jsonGeometry) throws JSONException {
		JSONObject bounds = null;
		try {
			bounds = (JSONObject) jsonGeometry.get("bounds");
		} catch (JSONException e) {
			bounds = (JSONObject) jsonGeometry.get("viewport");
		}
		return bounds;
	}

	private void setLocationArray(JSONObject northeast, JSONObject southwest) throws JSONException {
		Double neLong = (Double) northeast.get("lng");
		Double neLat = (Double) northeast.get("lat");
		Double swLong = (Double) southwest.get("lng");
		Double swLat = (Double) southwest.get("lat");
		GeoLocation northEastPoint = new GeoLocation(neLat, neLong);
		GeoLocation southWestPoint = new GeoLocation(swLat, swLong);
		locationArray = new double[][] { { southWestPoint.getLongitude(), southWestPoint.getLatitude() }, { northEastPoint.getLongitude(), northEastPoint.getLatitude() } };
	}

	public double[][] getLocationArray() {
		return locationArray;
	}

	@Override
	public String toString() {
		return "GeoLocationBox [locationArray=" + Arrays.toString(locationArray) + "]";
	}

}
