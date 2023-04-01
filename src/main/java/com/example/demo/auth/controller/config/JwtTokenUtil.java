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
package com.example.demo.auth.controller.config;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * The Class JwtTokenUtil.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 05 April, 2022
 * @description JwtTokenUtil class is a token util class.
 */
@Component
public class JwtTokenUtil implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2550185165626007488L;

	/** The secret. */
	@Value("${jwt.secret}")
	private String secret;


	/**
	 * Gets the username from token.
	 *
	 * @param token the token
	 * @return the username from token
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Gets the issued at date from token.
	 *
	 * @param token the token
	 * @return the issued at date from token
	 */
	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	/**
	 * Gets the expiration date from token.
	 *
	 * @param token the token
	 * @return the expiration date from token
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 * Gets the claim from token.
	 *
	 * @param <T>            the generic type
	 * @param token          the token
	 * @param claimsResolver the claims resolver
	 * @return the claim from token
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * Gets the all claims from token.
	 *
	 * @param token the token
	 * @return the all claims from token
	 */
	private Claims getAllClaimsFromToken(String token) {
		Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	/**
	 * Checks if is token expired.
	 *
	 * @param token the token
	 * @return the boolean
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * Ignore token expiration.
	 *
	 * @param token the token
	 * @return the boolean
	 */
	private Boolean ignoreTokenExpiration(String token) {
		// here you specify tokens, for that the expiration is ignored
		return false;
	}

	/**
	 * Generate token.
	 *
	 * @param userDetails the user details
	 * @return the string
	 */
	public String generateToken(UserDetails userDetails,Date expirationTime) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername(),expirationTime);
	}

	/**
	 * Do generate token.
	 *
	 * @param claims  the claims
	 * @param subject the subject
	 * @return the string
	 */
	private String doGenerateToken(Map<String, Object> claims, String subject,Date expirationTime) {

		final Date createdDate = new Date();
		Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(createdDate)
				// comment expiration date because session is managed by app
				.setExpiration(expirationTime).signWith(key, SignatureAlgorithm.HS256).compact();
	}

	/**
	 * Can token be refreshed.
	 *
	 * @param token the token
	 * @return the boolean
	 */
	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}

	/**
	 * Validate token.
	 *
	 * @param token       the token
	 * @param userDetails the user details
	 * @return the boolean
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
