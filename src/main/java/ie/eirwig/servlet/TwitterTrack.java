package ie.eirwig.servlet;

import ie.eirwig.twitter.TwitterStreamListener;
import ie.eirwig.util.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.FilterQuery;
import twitter4j.GeoLocation;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.internal.org.json.JSONException;

@WebServlet("/TwitterTrack")
public class TwitterTrack extends BaseHttpServlet {

	private static final long		serialVersionUID					= 1L;

	/** Dir is relative to classpath must have '/'. */
	private static final String		ETC_CONFIG_SLIGOKIDTEST_PROPERTIES	= "/etc/config/sligokidtest.properties";

	private TwitterStream			twitterStream;

	private TwitterStreamListener	listener;

	public TwitterTrack() throws FileNotFoundException, IOException, TwitterException, JSONException {
		Config config = new Config(ETC_CONFIG_SLIGOKIDTEST_PROPERTIES);
		twitterStream = new TwitterStreamFactory(config.getTwitterConfiguration()).getInstance();
		listener = new TwitterStreamListener();

		FilterQuery filterQueue = new FilterQuery();
		String[] keywords = new String[] { "#BOD" };
		filterQueue.track(keywords);
		twitterStream.addListener(listener);
		twitterStream.filter(filterQueue);
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
