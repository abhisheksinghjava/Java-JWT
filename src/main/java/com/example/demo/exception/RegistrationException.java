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
package com.example.demo.exception;

import org.springframework.http.HttpStatus;

/**
 * The RegistrationException.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 28 April, 2021
 * @description RegistrationException class.
 */
public class RegistrationException extends DemoException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;

	/**
	 * Instantiates a new registration exception.
	 *
	 * @param errorMsg   the error msg
	 * @param errorCode  the error code
	 * @param httpStatus the http status
	 */
	public RegistrationException(String errorMsg, String errorCode, HttpStatus httpStatus) {
		super(errorMsg, errorCode, httpStatus);
	}

	/**
	 * Instantiates a new Registration Exception.
	 */
	public RegistrationException() {

	}

	/**
	 * Instantiates a new registration exception.
	 *
	 * @param errorMsg  the error msg
	 * @param errorCode the error code
	 */
	public RegistrationException(String errorMsg, String errorCode) {
		super(errorMsg, errorCode);
	}

	/**
	 * Instantiates a new Registration Exception.
	 *
	 * @param errorMsg the error msg
	 */
	public RegistrationException(String errorMsg) {
		super(errorMsg);
	}

	/**
	 * Instantiates a new Registration Exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public RegistrationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new Registration Exception.
	 *
	 * @param cause the cause
	 */
	public RegistrationException(Throwable cause) {
		super(cause);
	}

}
