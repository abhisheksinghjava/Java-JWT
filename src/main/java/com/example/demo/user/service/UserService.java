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
package com.example.demo.user.service;

/**
 * The Interface UserService.
 *
 * @author - abhishek.singh@abc.com
 * @CreatedAt 01-April-2023
 * @description Interface for UserService.
 */
public interface UserService {
	
	/**
	 * Gets the user detail by username.
	 *
	 * @param userName the user name
	 * @return the user detail by username
	 */
	String getUserDetailByUsername(final String userName);

}
