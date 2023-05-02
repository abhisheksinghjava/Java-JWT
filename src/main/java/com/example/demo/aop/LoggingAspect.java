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
package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.common.util.Constants;

import org.slf4j.Logger;

/**
 * The Class LoggingAspect.
 *
 * @author - abhishek.singh@abc.com
 * @createdAt 01 April, 2023
 * @description LoggingAspect class that is the AOP logger class.
 */
@Aspect
@Component
public class LoggingAspect {

	/** The Constant LOG. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	/** The pointcut. */
	private final transient String pointcut = Constants.EXECUTION_PUBLIC_COM_NEC;

	/**
	 * Log before.
	 *
	 * @param joinPoint the join point
	 */
	@Before(pointcut)
	public void logBefore(final JoinPoint joinPoint) {
		final String methodName = joinPoint.getSignature().getName();
		final String parameterDetails = getMethodParameters(joinPoint);
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace(new StringBuilder(Constants.TEMPLATE_ENTER).append(joinPoint.getTarget().getClass())
					.append(Constants.HASH).append(methodName).append(Constants.RIGHT_BRACKET).toString());
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(new StringBuilder(Constants.INPUT_PARAM).append(joinPoint.getTarget().getClass())
					.append(Constants.HASH).append(methodName).append(Constants.HASH).append(Constants.PARAMETERS)
					.append(parameterDetails).append(Constants.RIGHT_BRACKET).toString());
		}

	}

	/**
	 * Log after.
	 *
	 * @param joinPoint the join point
	 */
	@After(pointcut)
	public void logAfter(final JoinPoint joinPoint) {
		final String methodName = joinPoint.getSignature().getName();

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace(new StringBuilder(Constants.TEMPLATE_EXIT).append(joinPoint.getTarget().getClass())
					.append(Constants.HASH).append(methodName).append(Constants.HASH).append(Constants.RIGHT_BRACKET)
					.toString());
		}

	}

	/**
	 * Gets the method parameters.
	 *
	 * @param joinPoint the join point
	 * @return the method parameters
	 */
	private String getMethodParameters(final JoinPoint joinPoint) {
		final StringBuilder stringBuilder = new StringBuilder();
		final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		final String[] parameterNames = signature.getParameterNames();
		final Object[] parameterValues = joinPoint.getArgs();
		final int parameterSize = parameterNames == null ? 0 : parameterNames.length;
		for (int i = 0; i < parameterSize; i++) {
			stringBuilder.append(parameterNames[i]).append(Constants.COLON).append(parameterValues[0]);
			if (i < (parameterSize - 1)) {
				stringBuilder.append(Constants.COMMA);
			}
		}
		return stringBuilder.toString();
	}
}
