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
package com.example.demo.auth.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.auth.model.UserDetailsDto;


/**
 * The Class UserDetailsCustomMapper.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description UserDetailsCustomMapper class is a user detail custom mapper
 *              class.
 */
@Mapper
public interface UserDetailsCustomMapper {

	/**
	 * Gets the user details.
	 *
	 * @param loginMap the login map
	 * @return the user details
	 */
	public UserDetailsDto getUserDetails(final Map<String, Object> loginMap);

	/**
	 * Adds the user details.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the int
	 */
	public int addUserDetails(final String userName, final String password);

	/**
	 * Gets the user details by user name.
	 *
	 * @param userName the user name
	 * @return the user details by user name
	 */
	public UserDetailsDto getUserDetailsByUserName(final String userName);

}
