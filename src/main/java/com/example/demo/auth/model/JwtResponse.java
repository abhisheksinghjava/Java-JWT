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
package com.example.demo.auth.model;

import java.io.Serializable;

/**
 * The Class JwtResponse.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description JwtResponse class is a jwt response class.
 */
public class JwtResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8091879091924046844L;

	/** The jwttoken. */
	private final String jwttoken;

	/**
	 * Instantiates a new jwt response.
	 *
	 * @param jwttoken the jwttoken
	 */
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return this.jwttoken;
	}
}