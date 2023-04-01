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
package com.example.demo.exception.handler;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.util.Constants;
import com.example.demo.common.util.DemoResponse;
import com.example.demo.common.util.Message;
import com.example.demo.exception.DemoException;


/**
 * The ISPExceptionHandler.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 28 April, 2021
 * @description ISPExceptionHandler class.
 */
@ControllerAdvice
public class DemoExceptionHandler {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoExceptionHandler.class);

	/**
	 * Gets the exception response.
	 *
	 * @param errorCode  the error code
	 * @param errorMsg   the error msg
	 * @param httpStatus the http status
	 * @return the exception response
	 */
	private ResponseEntity<DemoResponse> getExceptionResponse(final String errorCode, final String errorMsg,
			final HttpStatus httpStatus) {
		final Message message = new Message();
		final DemoResponse expResponse = new DemoResponse();
		expResponse.setStatus(Constants.FAILURE);
		message.setKey(errorCode);
		message.setValue(errorMsg);
		expResponse.setMessage(message);
		HttpStatus responseStatusCode = httpStatus;
		// Check If Http Status Is Null Or Not
		if (Objects.isNull(httpStatus)) {
			LOGGER.info("Http Status:{}", httpStatus);
			responseStatusCode = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(expResponse, responseStatusCode);
	}

	/**
	 * Handle service exception.
	 *
	 * @param request       the request
	 * @param response      the response
	 * @param ispException the isp exception
	 * @return the response entity
	 */
	@ExceptionHandler(DemoException.class)
	@ResponseBody
	public ResponseEntity<DemoResponse> handleISPException(final HttpServletRequest request,
			final HttpServletResponse response, final DemoException ispException) {

		LOGGER.info("Exception message in ISPExceptionHandler.handleServiceException msg:{}",
				ispException.getErrorMsg());

		return getExceptionResponse(ispException.getErrorCode(), ispException.getErrorMsg(),
				ispException.getHttpStatus());
	}

	
	/**
	 * Handle runtime exception.
	 *
	 * @param request          the request
	 * @param response         the response
	 * @param runtimeException the runtime exception
	 * @return the response entity
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResponseEntity<DemoResponse> handleRuntimeException(final HttpServletRequest request,
			final HttpServletResponse response, final RuntimeException runtimeException) {

		LOGGER.info("Exception message in ISPExceptionHandler.handleRuntimeException msg:{}",
				runtimeException.getMessage(), runtimeException);
		final Message message = new Message();
		final DemoResponse expResponse = new DemoResponse();
		expResponse.setStatus(Constants.FAILURE);
		message.setKey(Constants.RENTIME_EXP_CODE);
		message.setValue("Internal Server Error");
		expResponse.setMessage(message);
		return new ResponseEntity<>(expResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handle bad credentials exception.
	 *
	 * @param request          the request
	 * @param response         the response
	 * @param runtimeException the runtime exception
	 * @return the response entity
	 */
	@ExceptionHandler({ BadCredentialsException.class, InternalAuthenticationServiceException.class })
	@ResponseBody
	public ResponseEntity<DemoResponse> handleBadCredentialsException(final HttpServletRequest request,
			final HttpServletResponse response, final RuntimeException runtimeException) {

		LOGGER.info("Exception message in ISPExceptionHandler.handleBadCredentialsException msg:{}",
				runtimeException.getMessage(), runtimeException);
		final Message message = new Message();
		final DemoResponse expResponse = new DemoResponse();
		expResponse.setStatus(Constants.FAILURE);
		message.setKey(Constants.ERR0003);
		message.setValue(Constants.ERR0003_MSG);
		expResponse.setMessage(message);
		return new ResponseEntity<>(expResponse, HttpStatus.UNAUTHORIZED);
	}
}
