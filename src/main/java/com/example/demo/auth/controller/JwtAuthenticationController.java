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
package com.example.demo.auth.controller;

import java.util.Objects;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.model.AuthenticationResponseDto;
import com.example.demo.auth.model.JwtRequest;
import com.example.demo.auth.model.UserDetailsDto;
import com.example.demo.auth.model.UserRegisterReqDto;
import com.example.demo.auth.service.AuthenticationService;
import com.example.demo.common.util.Constants;
import com.example.demo.common.util.DemoResponse;
import com.example.demo.common.util.Message;
import com.example.demo.exception.RegistrationException;

/**
 * The Class JwtAuthenticationController.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description JwtAuthenticationController class that is the login class.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.base-path}")
public class JwtAuthenticationController {

	/** The authentication service. */
	@Autowired
	AuthenticationService authenticationService;

	/**
	 * Login.
	 *
	 * @param authenticationRequest the authentication request
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PostMapping(value = Constants.LOGIN_API_URL)
	public ResponseEntity<DemoResponse> login(@RequestBody final JwtRequest authenticationRequest) throws Exception {
		DemoResponse customResponse = null;
		Message message = null;
		if (Objects.isNull(authenticationRequest.getUserName())
				|| Strings.isBlank(authenticationRequest.getPassword())) {
			message = new Message(Constants.ERR0007, Constants.ERR0007_MSG);
			customResponse = new DemoResponse(Constants.FAILURE, message, null);
			return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
		}

		final AuthenticationResponseDto response = authenticationService.authenticate(authenticationRequest);
		message = new Message(Constants.SUC0001, Constants.SUC0001_MSG);
		customResponse = new DemoResponse(Constants.SUCCESS, message, response);

		return new ResponseEntity<>(customResponse, HttpStatus.ACCEPTED);
	}

	/**
	 * Register.
	 *
	 * @param userRegisterReqDto the user register req dto
	 * @return the response entity
	 * @throws DemoException
	 * @throws RegistrationException
	 */
	@PostMapping(value = Constants.REGISTER_API_URL)
	public ResponseEntity<DemoResponse> register(@RequestBody final UserRegisterReqDto userRegisterReqDto)
			throws RegistrationException {

		DemoResponse customResponse = null;
		Message message = null;

		if (Strings.isBlank(userRegisterReqDto.getUserName()) || Strings.isBlank(userRegisterReqDto.getPassword())) {
			message = new Message(Constants.ERR0007, Constants.ERR0007_MSG);
			customResponse = new DemoResponse(Constants.FAILURE, message, null);
			return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
		}
		final UserDetailsDto regUsrDtl = authenticationService.register(userRegisterReqDto);

		if (Objects.isNull(regUsrDtl)) {
			message = new Message(Constants.ERR0002, Constants.ERR0002_MSG);
			customResponse = new DemoResponse(Constants.FAILURE, message, regUsrDtl);
			return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
		}
		message = new Message(Constants.SUC0004, Constants.SUC0004_MSG);
		customResponse = new DemoResponse(Constants.SUCCESS, message, regUsrDtl);
		return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
	}

}
