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

/**
 * The Message.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 May, 2022
 * @description Message class.
 */
public class Message {

	/** The key. */
	private String key;

	/** The value. */
	private String value;

	/**
	 * Instantiates a new message.
	 */
	public Message() {
		super();
	}

	/**
	 * Instantiates a new message.
	 *
	 * @param key   the key
	 * @param value the value
	 */
	public Message(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * Instantiates a new message.
	 *
	 * @param key the key
	 */
	public Message(String key) {
		super();
		this.key = key;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
