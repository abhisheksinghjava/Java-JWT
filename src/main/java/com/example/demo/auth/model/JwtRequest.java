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
 * The Class JwtRequest.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description JwtRequest class is a jwt request class.
 */
public class JwtRequest implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5926468583005150707L;

	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new jwt request.
	 */
	// default constructor for JSON Parsing
	public JwtRequest() {
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Instantiates a new jwt request.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	public JwtRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	

	
}