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

import com.example.demo.auth.model.TokenInfoDto;


/**
 * The Class TokenInfoCustomMapper.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description TokenInfoCustomMapper class is a token info custom mapper class.
 */
@Mapper
public interface TokenInfoCustomMapper {

	/**
	 * Gets the token info.
	 *
	 * @param tokenStr the token str
	 * @return the token info
	 */
	public TokenInfoDto getTokenInfo(final String tokenStr);

	
	/**
	 * Gets the token info by user name.
	 *
	 * @param tokenMap the token map
	 * @return the token info by user name
	 */
	public TokenInfoDto getTokenInfoByUserName(final Map<String, Object> tokenMap);

	
	/**
	 * Adds the token info.
	 *
	 * @param tokenStr the token str
	 * @param userName the user name
	 * @param expiration the expiration
	 */
	public void addTokenInfo(final String tokenStr, final String userName, final long expiration);

	/**
	 * Update token info.
	 *
	 * @param tokenStr   the token str
	 * @param userName   the user name
	 * @param expiration the expiration
	 * @return the int
	 */
	public int updateTokenInfo(final String tokenStr, final String userName, final long expiration);
}
