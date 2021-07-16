package com.pkglobal.subscriber.service;

import org.apache.kafka.common.errors.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pkglobal.subscriber.converter.DefaultMessageRequestMaskConverter;
import com.pkglobal.subscriber.entity.Audit;
import com.pkglobal.subscriber.exception.ConsumerServiceException;
import com.pkglobal.subscriber.model.MessageRequest;
import com.pkglobal.subscriber.model.MessageResponse;
import com.pkglobal.subscriber.repository.AuditDataRepository;
import com.pkglobal.subscriber.util.ObjectMapperUtil;

@Service
public class DefaultConsumerService implements ConsumerService {

	private static final Logger logger = LoggerFactory.getLogger(DefaultConsumerService.class);

	@Autowired
	private AuditDataRepository auditDataRepository;

	@Autowired
	private DefaultMessageRequestMaskConverter messageRequestConverter;

	@Override
	@KafkaListener(topics = "${cloudkarafka.topic}")
	public void consumeService(String messageRequestString) {
		try {
			MessageRequest messageRequest = ObjectMapperUtil.returnObjectFromJsonString(messageRequestString);
			MessageRequest maskMessageRequest = messageRequestConverter.convert(messageRequest);
			logger.info("Started to consume messageRequest : {}", maskMessageRequest);
			Audit auditEntity = buildAuditEntity(messageRequestString, messageRequest);
			auditDataRepository.save(auditEntity);
			MessageResponse response = buildMessageResponse();
			logger.info("Finished to consume message : {}", response);
		} catch (TimeoutException ex) {
			throw new ConsumerServiceException(ex.getMessage());

		}

	}

	private Audit buildAuditEntity(String messageRequestString, MessageRequest messageRequest) {
		Audit auditEntity = new Audit();
		auditEntity.setCustomerNumber(messageRequest.getCustomerNumber());
		auditEntity.setPayload(messageRequestString);
		return auditEntity;
	}

	private MessageResponse buildMessageResponse() {
		MessageResponse response = new MessageResponse();
		response.setData("Consumed Message sucessfully");
		response.setStatus("success");
		return response;
	}

}
