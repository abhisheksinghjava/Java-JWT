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
package com.example.demo.auth.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.auth.mapper.UserDetailsCustomMapper;
import com.example.demo.auth.model.UserDetailsDto;
import com.example.demo.common.util.Constants;

/**
 * The Class JwtUserDetailsServiceImpl.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description JwtUserDetailsServiceImpl class is a jwt response class.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	/** The usr dtls custom mapper. */
	@Autowired
	UserDetailsCustomMapper usrDtlsCustomMapper;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtUserDetailsServiceImpl.class);

	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {

		final Map<String, Object> hMap = new HashMap<>();
		hMap.put(Constants.USER_NAME, userName);
		final UserDetailsDto usrDtl = usrDtlsCustomMapper.getUserDetails(hMap);
		if (Objects.nonNull(usrDtl) && usrDtl.getUserName().equals(userName)) {
			return new User(usrDtl.getUserName(), usrDtl.getPassword(), new ArrayList<>());
		} else {
			LOGGER.warn("User not fornd for user name:{}", userName);
			throw new UsernameNotFoundException("User not found with userName: " + userName);
		}

	}

}