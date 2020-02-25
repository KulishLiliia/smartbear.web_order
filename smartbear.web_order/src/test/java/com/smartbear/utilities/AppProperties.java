package com.smartbear.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AppProperties {

	private static Properties properties =getProperties();
	private static final Logger logger = Logger.getLogger(AppProperties.class);

	public static final String BASE_URL = properties.getProperty("base_url");
	public static final String BROWSER_TYPE = properties.getProperty("browser_type");
	public static final int IMPLICITLY_WAIT = Integer.parseInt(properties.getProperty("implicitly_wait"));

	
	
	private static Properties getProperties() {

		Properties properties = new Properties();

		String filePath = System.getProperty("user.dir") + "/src/test/resources/Properties/config.properties";
		try {
			InputStream inputStream = new FileInputStream(filePath);
			properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("File is not found");
			logger.error(e.getMessage());
		}

		return properties;
	}

}
