package ie.eirwig.servlet;

import ie.eirwig.twitter.TwitterStreamListener;
import ie.eirwig.util.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.GeoLocation;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@WebServlet("/TwitterSample")
public class TwitterSample extends BaseHttpServlet {

	private static final long		serialVersionUID				= 1L;

	/** Dir is relative to classpath must have '/'. */
	private static final String		ETC_CONFIG_EIRWIG_IE_PROPERTIES	= "/etc/config/eirwig_ie.properties";

	private TwitterStream			twitterStream;

	private TwitterStreamListener	listener;

	public TwitterSample() throws FileNotFoundException, IOException {
		Config config = new Config(ETC_CONFIG_EIRWIG_IE_PROPERTIES);
		twitterStream = new TwitterStreamFactory(config.getTwitterConfiguration()).getInstance();
		listener = new TwitterStreamListener();
		twitterStream.addListener(listener);
		twitterStream.sample();
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
