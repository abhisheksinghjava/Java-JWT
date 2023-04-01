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

/**
 * The Class LoginRequest.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description LoginRequest class is a login request class.
 */
public class LoginRequest {
	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

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
	 * Instantiates a new login request.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	public LoginRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * Instantiates a new login request.
	 */
	public LoginRequest() {
		super();
	}
	
	
}
