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
package com.example.demo.auth.service;

import com.example.demo.auth.model.AuthenticationResponseDto;
import com.example.demo.auth.model.JwtRequest;
import com.example.demo.auth.model.UserDetailsDto;
import com.example.demo.auth.model.UserRegisterReqDto;
import com.example.demo.exception.RegistrationException;

/**
 * The Interface AuthenticationService.
 *
 * @author - abhishek.singh@abc.com
 * @CreatedAt 13-April-2022
 * @description Interface for authentication.
 */
public interface AuthenticationService {

	/**
	 * Authenticate.
	 *
	 * @param jwtReq the jwt req
	 * @return the string
	 * @throws Exception the exception
	 */
	AuthenticationResponseDto authenticate(final JwtRequest jwtReq) throws Exception;

	/**
	 * Register.
	 *
	 * @param userRegisterReqDto the user register req dto
	 * @return the user details dto
	 * @throws RegistrationException
	 */
	UserDetailsDto register(final UserRegisterReqDto userRegisterReqDto) throws RegistrationException;

}
