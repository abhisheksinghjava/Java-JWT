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
import org.springframework.stereotype.Service;

import com.example.demo.user.service.UserService;

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
	 */
	@Override
	@NewSpan("UserServiceImpl.getUserDetailByUsername")
	public String getUserDetailByUsername(final String userName) {

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Entering into method UserServiceImpl.getUserDetailByUsername");
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(new StringBuilder("Input parameter: userName: ").append(userName).toString());
		}
		final String resp = new StringBuilder(userName).append(" get successfully.").toString();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(new StringBuilder("Output parameter: resp: ").append(resp).toString());
		}
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Exiting from method UserServiceImpl.getUserDetailByUsername");
		}
		return resp;
	}

}
