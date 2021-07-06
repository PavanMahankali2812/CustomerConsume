package com.pkglobal.subscriber.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pkglobal.subscriber.converter.DefaultMessageRequestMaskConverter;
import com.pkglobal.subscriber.repository.AuditDataRepository;
import com.pkglobal.subscriber.service.DefaultConsumerService;


@ExtendWith(MockitoExtension.class)
class DefaultConsumerServiceTest {

    @InjectMocks
    private DefaultConsumerService defaultConsumerService;

    @Mock
    private AuditDataRepository auditDataRepository;

    @Mock
    private DefaultMessageRequestMaskConverter messageRequestMaskConverter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConsumeServiceWithSuccess() {
        String messageRequestString = buildMessageRequestStringForSucessResponse();
        assertDoesNotThrow(() -> defaultConsumerService.consumeService(messageRequestString));
    }

    @Test
    void testConsumeServiceWithErrorResponse() {
        String messageRequestString = buildMessageRequestStringForErrorResponse();
        Throwable exception = assertThrows(Exception.class,
                () -> defaultConsumerService.consumeService(messageRequestString));
        assertNotNull(exception);
    }

    private String buildMessageRequestStringForSucessResponse() {
        String jsonString =
                "{\"customerNumber\":\"CUST123456\",\"firstName\":\"Pavan Pavan\",\"lastName\":\"Kumarkumar\",\"country\":\"India\",\"countryCode\":\"IN\",\"mobileNumber\":\"9603335300\",\"email\":\"Pavan@gmail.com\",\"customerStatus\":\"OPEN\",\"birthDate\":\"02-02-2020\",\"address\":{\"addressLine1\":\"lakkavram\",\"addressLine2\":\"west\",\"postalCode\":\"534451\",\"street\":\"jungle\"}}";
               return jsonString;
    }


    private String buildMessageRequestStringForErrorResponse() {
        String jsonString = "Invalid data";
        return jsonString;
    }



}

