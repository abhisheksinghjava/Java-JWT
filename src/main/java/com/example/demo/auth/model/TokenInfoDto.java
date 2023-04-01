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
 * The Class TokenInfoDto.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description TokenInfoDto class is a POJO class for token.
 */
public class TokenInfoDto {

	/** The user name. */
	private String userName;

	/** The token str. */
	private String tokenStr;

	/** The expiration. */
	private long expiration;

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
	 * Gets the token str.
	 *
	 * @return the token str
	 */
	public String getTokenStr() {
		return tokenStr;
	}

	/**
	 * Sets the token str.
	 *
	 * @param tokenStr the new token str
	 */
	public void setTokenStr(String tokenStr) {
		this.tokenStr = tokenStr;
	}

	/**
	 * Gets the expiration.
	 *
	 * @return the expiration
	 */
	public long getExpiration() {
		return expiration;
	}

	/**
	 * Sets the expiration.
	 *
	 * @param expiration the new expiration
	 */
	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}

	/**
	 * Instantiates a new token info dto.
	 *
	 * @param userName   the user name
	 * @param tokenStr   the token str
	 * @param expiration the expiration
	 */
	public TokenInfoDto(String userName, String tokenStr, long expiration) {
		super();
		this.userName = userName;
		this.tokenStr = tokenStr;
		this.expiration = expiration;
	}

	/**
	 * Instantiates a new token info dto.
	 */
	public TokenInfoDto() {
		super();
	}

}