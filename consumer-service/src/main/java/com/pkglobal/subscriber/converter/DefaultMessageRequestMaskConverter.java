package com.pkglobal.subscriber.converter;

import org.springframework.stereotype.Component;

import com.pkglobal.subscriber.constants.SubscriberConstants;
import com.pkglobal.subscriber.model.MessageRequest;

@Component
public class DefaultMessageRequestMaskConverter implements MaskConverter<MessageRequest> {

	@Override
	public MessageRequest convert(MessageRequest messageRequest) {
		messageRequest.setCustomerNumber(messageRequest.getCustomerNumber().replaceAll(
				(SubscriberConstants.CUSTOMER_NUMBER_REGEX_EXPRESSION.getRegexExpression()),
				SubscriberConstants.MASK_CONSTANTS.getRegexExpression()));
		messageRequest.setBirthDate(messageRequest.getBirthDate().replaceAll(
				(SubscriberConstants.BIRTH_DATE_REGEX_EXPRESSION.getRegexExpression()),
				SubscriberConstants.MASK_CONSTANTS.getRegexExpression()));
		messageRequest.setEmail(messageRequest.getEmail().replaceAll(
				(SubscriberConstants.EMAIL_ID_REGEX_EXPRESSION.getRegexExpression()),
				SubscriberConstants.MASK_CONSTANTS.getRegexExpression()));
		return messageRequest;

	}

}
