/** COPYRIGHT (C) ABC INDIA PVT.LTD.
 * 
 * ALL RIGHTS RESERVED BY ABC INDIA PVT.LTD., THIS PROGRAM
 * MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS
 * FURNISHED BY ABC INDIA PVT.LTD., NO PART OF THIS PROGRAM
 * MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
 * WITHOUT THE PRIOR WRITTEN PERMISSION OF ABC INDIA PVT.LTD..
 * 
 * ABC INDIA PVT.LTD. CONFIDENTIAL AND PROPRIETARY
 */
package com.example.demo.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * The MessagePropertyUtils.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 10 April, 2023
 * @description MessagePropertyUtils class.
 */
public class MessagePropertyUtils {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(MessagePropertyUtils.class);
	
	private static  Properties property = loadProperties(Constants.MESSAGE_RESOURCE_FILE);
	
	
	private MessagePropertyUtils() {
		
	}
	
	public static Properties loadProperties(final String fileName) {
		
		Properties prop=null;
		LOGGER.info("In MessagePropertyUtils Going to load configuration.");
		//load a property file
		try(InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)){
			prop=new Properties();
			prop.load(inputStream);
		}catch(final IOException exception) {
			LOGGER.error("Property file not found",exception);
		}
		return prop;
		
	}
	
	public static String getErrorMessage(final String key) {
		return property.getProperty(key);
	}

}
