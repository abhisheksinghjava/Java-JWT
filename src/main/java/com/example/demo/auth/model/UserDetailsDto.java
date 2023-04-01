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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class UserDetails.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description UserDetails class is a POJO class for user.
 */
public class UserDetailsDto {


	/** The user name. */
	private String userName;

	/** The password. */
	@JsonIgnore
	private String password;

	/**
	 * Instantiates a new user.
	 */
	public UserDetailsDto() {

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
	 * Instantiates a new user details dto.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	public UserDetailsDto( String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}