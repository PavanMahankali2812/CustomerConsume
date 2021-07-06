package com.pkglobal.subscriber.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pkglobal.subscriber.exception.ConsumerServiceException;
import com.pkglobal.subscriber.model.MessageRequest;

public class ObjectMapperUtil {

    static final Logger LOGGER = LoggerFactory.getLogger(ObjectMapperUtil.class);

    private ObjectMapperUtil() {
        throw new AssertionError("No Object Creation");
    }

    public static MessageRequest returnObjectFromJsonString(String messageRequestString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.readValue(messageRequestString, MessageRequest.class);
        } catch (JsonProcessingException ex) {
            throw new ConsumerServiceException(
                    "Failed in the Parsing with exception" + ex.getMessage());
        }
    }
}
