package com.lh.aop.demo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @description 
 *
 * @author lh
 *
 * @date 2016年6月24日 下午6:41:35
 */
public class MethodInvokeTimeAspect {
	private static Logger log = LoggerFactory.getLogger(MethodInvokeTimeAspect.class);

	public Object profile(ProceedingJoinPoint point) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = null;
		try {
			proceed = point.proceed();
			return proceed;

		} finally {

			long end = System.currentTimeMillis();

			Object[] args = point.getArgs();
			log.info("[{}],{},[{}], [{}] ", point, Arrays.toString(args), proceed, end - start);
		}

	}

	public void doThrowing(JoinPoint jp, Throwable ex) {
		log.error("{} error {}", jp, ex);
	}
}
