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
 * The AuthenticationException.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 28 April, 2021
 * @description AuthenticationException class.
 */
public class AuthenticationException extends DemoException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5L;

	/**
	 * Instantiates a new authentication exception.
	 *
	 * @param errorMsg   the error msg
	 * @param errorCode  the error code
	 * @param httpStatus the http status
	 */
	public AuthenticationException(String errorMsg, String errorCode, HttpStatus httpStatus) {
		super(errorMsg, errorCode, httpStatus);
	}

	/**
	 * Instantiates a new Authentication Exception.
	 */
	public AuthenticationException() {

	}

	/**
	 * Instantiates a new authentication exception.
	 *
	 * @param errorMsg  the error msg
	 * @param errorCode the error code
	 */
	public AuthenticationException(String errorMsg, String errorCode) {
		super(errorMsg, errorCode);
	}

	/**
	 * Instantiates a new Authentication Exception.
	 *
	 * @param errorMsg the error msg
	 */
	public AuthenticationException(String errorMsg) {
		super(errorMsg);
	}

	/**
	 * Instantiates a new Authentication Exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new Authentication Exception.
	 *
	 * @param cause the cause
	 */
	public AuthenticationException(Throwable cause) {
		super(cause);
	}

}
