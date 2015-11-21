package ie.eirwig.twitter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class TwitterStreamListener implements StatusListener {

	private ConcurrentMap<String, Integer>	countryCounts;

	private AtomicLong						tweetCount;

	private Status							status;

	public TwitterStreamListener() {
		countryCounts = new ConcurrentHashMap<String, Integer>();
		tweetCount = new AtomicLong();
	}

	public void onStatus(Status status) {
		if (status.getPlace() != null && status.getGeoLocation() != null) {
			setStatus(status);
			countCountry(status);
		}
	}

	private void countCountry(Status status) {
		String country = status.getPlace().getCountry();
		Integer count = countryCounts.get(country);
		if (count != null) {
			countryCounts.put(country, ++count);
		} else {
			countryCounts.put(country, 1);
		}
		tweetCount.incrementAndGet();
	}

	private synchronized void setStatus(Status status) {
		this.status = status;
	}

	public synchronized Status getStatus() {
		return status;
	}

	public AtomicLong getTweetCount() {
		return tweetCount;
	}

	public ConcurrentMap<String, Integer> getCountryCounts() {
		return countryCounts;
	}

	public void onException(Exception arg0) {
	}

	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
	}

	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
	}

	public void onScrubGeo(long userId, long upToStatusId) {
	}

	public void onStallWarning(StallWarning warning) {
	}

}
