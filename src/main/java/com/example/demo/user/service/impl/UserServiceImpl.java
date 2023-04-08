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
package com.example.demo.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.common.util.Constants;
import com.example.demo.common.util.MessagePropertyUtils;
import com.example.demo.user.service.UserService;
import com.example.demo.exception.DemoException;

/**
 * The Class UserServiceImpl.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 01 April, 2023
 * @description UserServiceImpl class is an implementation class of UserService.
 */
@Service
public class UserServiceImpl implements UserService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * Gets the user detail by username.
	 *
	 * @param userName the user name
	 * @return the user detail by username
	 * @throws DemoException
	 */
	@Override
	@NewSpan("UserServiceImpl.getUserDetailByUsername")
	public String getUserDetailByUsername(final String userName) throws DemoException {

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Entering into method UserServiceImpl.getUserDetailByUsername");
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(new StringBuilder("Input parameter: userName: ").append(userName).toString());
		}
		String resp = "";

		if (Constants.NAME.equalsIgnoreCase(userName)) {
			resp = new StringBuilder(userName).append(" get successfully.").toString();
		} else {
			throw new DemoException(MessagePropertyUtils.getErrorMessage(Constants.ERR0008_MSG), Constants.ERR0008, HttpStatus.BAD_REQUEST);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(new StringBuilder("Output parameter: resp: ").append(resp).toString());
		}
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Exiting from method UserServiceImpl.getUserDetailByUsername");
		}
		return resp;
	}

}
