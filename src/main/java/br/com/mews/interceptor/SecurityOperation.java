package br.com.mews.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

/**
 * @author wmews
 */
@Interceptor
@Security
public class SecurityOperation {

	@Inject
	private Logger logger;

	@AroundInvoke
	public Object operation(InvocationContext context) throws Exception {
		logger.info("before operation");
		Object obj = context.proceed();
		logger.info("after operation");
		return obj;
	}
}
