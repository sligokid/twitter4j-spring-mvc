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
 * The Class TwitterIrelandRest services requests for Twitter Ireland data via
 * REST API.
 */
@WebServlet("/TwitterIrelandREST")
public class TwitterIrelandRest extends BaseHttpServlet {

	private static final long		serialVersionUID					= 1L;

	private static final Logger		LOGGER								= Logger.getLogger(TwitterIrelandRest.class.getName());

	/** Dir is relative to classpath must have '/'. */
	private static final String		ETC_CONFIG_SLIGOKIDTEST_PROPERTIES	= "/etc/config/sligokidtest.properties";

	private static final String		IRELAND								= "Ireland";

	private TwitterStream			twitterStream;

	private TwitterStreamListener	listener;

	public TwitterIrelandRest() throws FileNotFoundException, IOException, TwitterException, JSONException {
		Config config = new Config(ETC_CONFIG_SLIGOKIDTEST_PROPERTIES);
		twitterStream = new TwitterStreamFactory(config.getTwitterConfiguration()).getInstance();
		listener = new TwitterStreamListener();

		HttpParameter address = new HttpParameter("address", IRELAND);
		HttpParameter sensor = new HttpParameter("sensor", "false");
		HttpParameter[] parameters = { address, sensor };

		GoogleMapsWrapper response = new GoogleMapsWrapper(parameters);
		GeoLocationBox locationBox = new GeoLocationBox(response);
		LOGGER.info("LocationBox: " + locationBox);

		FilterQuery fq = new FilterQuery();
		fq.locations(locationBox.getLocationArray());
		twitterStream.addListener(listener);
		twitterStream.filter(fq);
	}

	@Override
	protected void runPrintWriter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		String oldStatus = "";
		if (listener.getStatus() != null) {
			String status = listener.getStatus().getText();
			if (!oldStatus.equals(status)) {
				GeoLocation location = listener.getStatus().getGeoLocation();
				printWriter.print("{\n");
				printWriter.print("\"id\": \"" + listener.getStatus().getId() + "\",\n");
				printWriter.print("\"text\": \"" + listener.getStatus().getText() + "\",\n");
				printWriter.print("\"user\": \"" + listener.getStatus().getUser().getScreenName() + "\",\n");
				printWriter.print("\"profileImageUrl\": \"" + listener.getStatus().getUser().getProfileImageURL() + "\",\n");
				printWriter.print("\"lat\": " + location.getLatitude() + ",\n");
				printWriter.print("\"lng\": " + location.getLongitude() + "\n");
				printWriter.print("}\n\n");
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
