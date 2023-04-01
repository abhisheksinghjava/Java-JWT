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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.auth.controller.config.JwtTokenUtil;
import com.example.demo.auth.mapper.TokenInfoCustomMapper;
import com.example.demo.auth.mapper.UserDetailsCustomMapper;
import com.example.demo.auth.model.AuthenticationResponseDto;
import com.example.demo.auth.model.JwtRequest;
import com.example.demo.auth.model.TokenInfoDto;
import com.example.demo.auth.model.UserDetailsDto;
import com.example.demo.auth.model.UserRegisterReqDto;
import com.example.demo.auth.service.AuthenticationService;
import com.example.demo.common.util.Constants;
import com.example.demo.exception.AuthenticationException;
import com.example.demo.exception.RegistrationException;

/**
 * The Interface AuthenticationServiceImpl.
 *
 * @author - abhishek.singh@abc.com
 * @CreatedAt 13-April-2022
 * @description Interface for authentication.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	/** The authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	/** The jwt token util. */
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/** The jwt in memory user details service. */
	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	/** The jwt expiration. */
	@Value("${jwt.expiration}")
	private String jwtExpiration;

	/** The usr dtls custom mapper. */
	@Autowired
	UserDetailsCustomMapper usrDtlsCustomMapper;

	/** The token info custom mapper. */
	@Autowired
	TokenInfoCustomMapper tokenInfoCustomMapper;

	/** The custom password encoder impl. */
	@Autowired
	CustomPasswordEncoderImpl customPasswordEncoderImpl;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	/**
	 * Authenticate.
	 *
	 * @param jwtReq the jwt req
	 * @return the authentication response dto
	 * @throws Exception the exception
	 */
	@Override
	public AuthenticationResponseDto authenticate(final JwtRequest jwtReq) throws Exception {

		final AuthenticationResponseDto respDto = new AuthenticationResponseDto();
		authenticate(jwtReq.getUserName(), jwtReq.getPassword());
		final long currTime = new Date().getTime();
		final Date expirationTime = new Date(currTime + (Integer.parseInt(jwtExpiration) * 60000));
		final String token = jwtTokenUtil
				.generateToken(jwtInMemoryUserDetailsService.loadUserByUsername(jwtReq.getUserName()), expirationTime);
		addOrUpdateTokenInDb(jwtReq.getUserName(), token, expirationTime.getTime());
		respDto.setToken(token);
		respDto.setExpiration(expirationTime.getTime());
		final Map<String, Object> hMap = new HashMap<>();
		hMap.put(Constants.USER_NAME, jwtReq.getUserName());
		respDto.setUser(usrDtlsCustomMapper.getUserDetails(hMap));
		return respDto;
	}

	/**
	 * Adds the or update token in db.
	 *
	 * @param userName   the user name
	 * @param tokenStr   the token str
	 * @param expiration the expiration
	 */
	private void addOrUpdateTokenInDb(final String userName, final String tokenStr, final long expiration) {

		final Map<String, Object> hMap = new HashMap<>();
		hMap.put(Constants.USER_NAME, userName);
		final TokenInfoDto tokenInfoDto = tokenInfoCustomMapper.getTokenInfoByUserName(hMap);
		if (Objects.nonNull(tokenInfoDto)) {
			LOGGER.info("tokenInfoDto is not null");
			tokenInfoCustomMapper.updateTokenInfo(tokenStr, userName, expiration);
		} else {
			LOGGER.info("tokenInfoDto is null");
			tokenInfoCustomMapper.addTokenInfo(tokenStr, userName, expiration);
		}

	}

	/**
	 * Authenticate.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the authentication
	 * @throws AuthenticationException the authentication exception
	 */
	private Authentication authenticate(String userName, String password) throws AuthenticationException {

		Objects.requireNonNull(userName);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			// Load userDetails after Authentication to generate Token
			final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(userName);

			return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		} catch (final DisabledException exc) {
			throw new AuthenticationException(Constants.ERR0020_MSG, Constants.ERR0020, HttpStatus.BAD_REQUEST);

		} catch (final BadCredentialsException exc) {
			throw new AuthenticationException(Constants.ERR0003_MSG, Constants.ERR0003, HttpStatus.UNAUTHORIZED);
		}
	}

	/**
	 * Register.
	 *
	 * @param userDetailsDto the user details dto
	 * @return the user details dto
	 * @throws RegistrationException the registration exception
	 */
	@Override
	public UserDetailsDto register(final UserRegisterReqDto userDetailsDto) throws RegistrationException {

		final UserDetailsDto userDt = usrDtlsCustomMapper.getUserDetailsByUserName(userDetailsDto.getUserName());

		if (Objects.isNull(userDt)) {
			final int recCount = usrDtlsCustomMapper.addUserDetails(userDetailsDto.getUserName(),
					customPasswordEncoderImpl.encode(userDetailsDto.getPassword()));
			if (recCount == 1) {
				LOGGER.info("User added successfully");
				final UserDetailsDto retDto = new UserDetailsDto();
				retDto.setUserName(userDetailsDto.getUserName());
				return retDto;
			} else {

				throw new RegistrationException(Constants.ERR0018_MSG, Constants.ERR0018, HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new RegistrationException(Constants.ERR0019_MSG, Constants.ERR0019, HttpStatus.CONFLICT);
		}
	}

}
