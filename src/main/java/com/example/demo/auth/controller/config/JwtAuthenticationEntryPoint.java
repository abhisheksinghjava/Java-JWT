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
package com.example.demo.auth.controller.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.demo.common.util.Constants;
import com.example.demo.common.util.DemoResponse;
import com.example.demo.common.util.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The Class JwtAuthenticationEntryPoint.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description JwtAuthenticationEntryPoint class is an authentication entry
 *              point class .
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7858869558953243875L;

	/**
	 * Commence.
	 *
	 * @param request       the request
	 * @param response      the response
	 * @param authException the auth exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		final Message message = new Message(Constants.ERR0003, Constants.ERR0003_MSG);
		final DemoResponse customResponse = new DemoResponse(Constants.FAILURE, message, null);
		final Gson gson = new GsonBuilder().serializeNulls().create();
		final String json = gson.toJson(customResponse);
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getOutputStream().println(json);
	}
}
