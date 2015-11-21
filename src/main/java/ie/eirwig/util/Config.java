package ie.eirwig.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class Config {

	private static Logger		LOGGER	= Logger.getLogger(Config.class.getName());

	private final String		filename;

	private final String		logDirName;

	private final Properties	properties;

	public Config() throws IOException {
		this.properties = new Properties();
		this.properties.load(getClass().getResourceAsStream("config.properties"));
		this.logDirName = properties.getProperty("logdir");
		this.filename = "test";
	}

	public Config(String fileName) throws FileNotFoundException, IOException {
		LOGGER.info("Initializing... config file: " + fileName);
		if (fileName == null) {
			throw new RuntimeException("Config file required as agument 1..");
		}
		this.filename = fileName;
		this.properties = new Properties();
		this.properties.load(getClass().getResourceAsStream(fileName));
		this.logDirName = properties.getProperty("logdir");
	}

	public String getLogFileName() {
		if (logDirName == null) {
			throw new RuntimeException("Config file missing 'logdir' entry..");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String today = format.format(new Date());
		LOGGER.info("Today:" + today);
		return logDirName + filename + "_" + today + ".log";
	}

	public Configuration getTwitterConfiguration() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(properties.getProperty("oauth.consumerKey"));
		cb.setOAuthConsumerSecret(properties.getProperty("oauth.consumerSecret"));
		cb.setOAuthAccessToken(properties.getProperty("oauth.accessToken"));
		cb.setOAuthAccessTokenSecret(properties.getProperty("oauth.accessTokenSecret"));
		return cb.build();
	}

	protected String getLogDir() {
		return logDirName;
	}
}
