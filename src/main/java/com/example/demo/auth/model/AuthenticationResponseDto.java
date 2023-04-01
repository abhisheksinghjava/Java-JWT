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
 * The Class AuthenticationResponseDto.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description AuthenticationResponseDto class is a authentication response
 *              class.
 */
public class AuthenticationResponseDto {

	/** The token. */
	private String token;

	/** The user. */
	private UserDetailsDto user;

	/** The expiration. */
	private Long expiration;

	public AuthenticationResponseDto() {

	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public UserDetailsDto getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(UserDetailsDto user) {
		this.user = user;
	}

	/**
	 * Gets the expiration.
	 *
	 * @return the expiration
	 */
	public Long getExpiration() {
		return expiration;
	}

	/**
	 * Sets the expiration.
	 *
	 * @param expiration the new expiration
	 */
	public void setExpiration(Long expiration) {
		this.expiration = expiration;
	}

	/**
	 * Instantiates a new authentication response dto.
	 *
	 * @param token      the token
	 * @param user       the user
	 * @param expiration the expiration
	 */
	public AuthenticationResponseDto(String token, UserDetailsDto user, Long expiration) {
		super();
		this.token = token;
		this.user = user;
		this.expiration = expiration;
	}

}
