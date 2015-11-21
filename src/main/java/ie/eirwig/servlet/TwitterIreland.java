package ie.eirwig.servlet;

import ie.eirwig.google.GeoLocationBox;
import ie.eirwig.google.GoogleMapsWrapper;
import ie.eirwig.twitter.TwitterStreamListener;
import ie.eirwig.util.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.FilterQuery;
import twitter4j.GeoLocation;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.org.json.JSONException;

/**
 * The Class TwitterIreland services requests for Twitter Ireland data.
 */
@WebServlet("/TwitterIreland")
public class TwitterIreland extends BaseHttpServlet {

	private static final long		serialVersionUID					= 1L;

	private static final Logger		LOGGER								= Logger.getLogger(TwitterIreland.class.getName());

	/** dir is relative to classpath must have '/' */
	private static final String		ETC_CONFIG_SLIGOKIDTEST_PROPERTIES	= "/etc/config/sligokidtest.properties";

	private static final String		IRELAND								= "Ireland";

	private TwitterStream			twitterStream;

	private TwitterStreamListener	listener;

	public TwitterIreland() throws FileNotFoundException, IOException, TwitterException, JSONException {
		Config config = new Config(ETC_CONFIG_SLIGOKIDTEST_PROPERTIES);
		twitterStream = new TwitterStreamFactory(config.getTwitterConfiguration()).getInstance();
		listener = new TwitterStreamListener();

		GeoLocationBox locationBox = getGeoLocationBox();

		FilterQuery fq = new FilterQuery();
		fq.locations(locationBox.getLocationArray());
		twitterStream.addListener(listener);
		twitterStream.filter(fq);
	}

	private GeoLocationBox getGeoLocationBox() throws TwitterException, JSONException {
		HttpParameter address = new HttpParameter("address", IRELAND);
		HttpParameter sensor = new HttpParameter("sensor", "false");
		HttpParameter[] parameters = { address, sensor };

		GoogleMapsWrapper response = new GoogleMapsWrapper(parameters);
		GeoLocationBox locationBox = new GeoLocationBox(response);
		LOGGER.info("LocationBox: " + locationBox.toString());
		return locationBox;
	}

	@Override
	protected void runPrintWriter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		String oldStatus = "";
		while (true) {
			if (listener.getStatus() != null) {
				String status = listener.getStatus().getText();
				if (!oldStatus.equals(status)) {
					GeoLocation location = listener.getStatus().getGeoLocation();
					printWriter.print("data:" + "{\n");
					printWriter.print("data:\"id\": \"" + listener.getStatus().getId() + "\",\n");
					printWriter.print("data:\"text\": \"" + listener.getStatus().getText() + "\",\n");
					printWriter.print("data:\"user\": \"" + listener.getStatus().getUser().getScreenName() + "\",\n");
					printWriter.print("data:\"profileImageUrl\": \"" + listener.getStatus().getUser().getProfileImageURL() + "\",\n");
					printWriter.print("data:\"con\": \"" + listener.getStatus().getPlace().getCountry() + "\",\n");
					printWriter.print("data:\"lat\": " + location.getLatitude() + ",\n");
					printWriter.print("data:\"lng\": " + location.getLongitude() + ",\n");
					printWriter.print("data:\"tweetCount\": " + listener.getTweetCount() + "\n");
					printWriter.print("data:" + "}\n\n");
					printWriter.flush();
					oldStatus = status;
				}
			}
			try {
				Thread.currentThread();
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
