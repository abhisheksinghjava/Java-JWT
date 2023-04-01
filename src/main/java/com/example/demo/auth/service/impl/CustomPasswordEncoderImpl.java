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

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * The class CustomPasswordEncoderImpl.
 *
 * @author - abhishek.singh@abc.com
 * @CreatedAt 16-April-2022
 * @description Custom Password Encoder class.
 */
@Component
public class CustomPasswordEncoderImpl implements PasswordEncoder {

	/** The password encoder. */
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	/**
	 * Encode.
	 *
	 * @param rawPassword the raw password
	 * @return the string
	 */
	@Override
	public String encode(CharSequence rawPassword) {
		String hashed = passwordEncoder.encode(rawPassword);
		return hashed;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
