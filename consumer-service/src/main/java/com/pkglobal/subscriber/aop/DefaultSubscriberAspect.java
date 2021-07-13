package com.pkglobal.subscriber.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pkglobal.subscriber.entity.Error;
import com.pkglobal.subscriber.model.ErrorResponse;
import com.pkglobal.subscriber.repository.ErrorDataRepository;

@Aspect
@Component
public class DefaultSubscriberAspect {

	private static final Logger logger = LoggerFactory.getLogger(DefaultSubscriberAspect.class);

	@Autowired
	private ErrorDataRepository errorDataRepository;

	@AfterThrowing(pointcut = "execution(* com.pkglobal.subscriber.service.DefaultConsumerService.*(..)) and args(messageRequestString)", throwing = "ex")
	public void logError(Exception ex, String messageRequestString) {
		Error errorEntity = buildErrorEntity(messageRequestString, ex);
		errorDataRepository.save(errorEntity);
		ErrorResponse errorResponse = buildErrorResponse(ex);
		logger.error("ErrorResponse :{}", errorResponse);
	}

	@Before(value = "execution(* com.pkglobal.subscriber.service.DefaultConsumerService.*(..)) and args(messageRequestString)")
	public void beforeAdvice(Exception ex, String messageRequestString) {
		Error errorEntity = buildErrorEntity(messageRequestString, ex);
		errorDataRepository.save(errorEntity);
		ErrorResponse errorResponse = buildErrorResponse(ex);
		logger.error("ErrorResponse :{}", errorResponse);
	}

	@Around(value = "execution(* com.pkglobal.subscriber.service.DefaultConsumerService.*(..)) and args(messageRequestString)")
	public void afterAdvice(Exception ex, String messageRequestString) {
		Error errorEntity = buildErrorEntity(messageRequestString, ex);
		errorDataRepository.save(errorEntity);
		ErrorResponse errorResponse = buildErrorResponse(ex);
		logger.error("ErrorResponse :{}", errorResponse);
	}

	private Error buildErrorEntity(String messageRequestString, Exception e) {
		Error errorEntity = new Error();
		errorEntity.setPayload(messageRequestString);
		errorEntity.setErrorDescription(e.getMessage());
		errorEntity.setErrorType(e.getClass().getName());
		return errorEntity;
	}

	private ErrorResponse buildErrorResponse(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("error");
		errorResponse.setMessage(e.getMessage());
		errorResponse.setErrorType(e.getClass().getName());
		logger.error("ErrorResponse :{}", errorResponse);
		return errorResponse;
	}

}
