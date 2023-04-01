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
 * The IspResponse.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 13 April, 2021
 * @description IspResponse class.
 */
public class DemoResponse {

	/** The status. */
	private String status;

	/** The message. */
	private Message message;

	/** The response. */
	private Object data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(Message message) {
		this.message = message;
	}

	/**
	 * Instantiates a new custom response.
	 */
	public DemoResponse() {
		super();
	}

	/**
	 * Instantiates a new custom response.
	 *
	 * @param status  the status
	 * @param message the message
	 * @param data    the data
	 */
	public DemoResponse(String status, Message message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;

	}

	/**
	 * Instantiates a new custom response.
	 *
	 * @param status  the status
	 * @param message the message
	 */
	public DemoResponse(String status, Message message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * Instantiates a new custom response.
	 *
	 * @param status the status
	 * @param data   the data
	 */
	public DemoResponse(String status, Object data) {
		this.status = status;
		this.data = data;
	}
}
