package com.pkglobal.subscriber.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pkglobal.subscriber.model.Address;
import com.pkglobal.subscriber.model.MessageRequest;

class ObjectMapperUtilTest {

	@Mock
	private ObjectMapper mapper;

	@Test
	void testObjectMapperUtilWhenDomainObjectPassed() throws Exception {
		String messageRequestString = "{\"customerNumber\":\"C123456789\",\"firstName\":\"pavan pavan\",\"lastName\":\"kumar kumar\",\"birthDate\":null,\"country\":\"India\",\"countryCode\":\"IN\",\"mobileNumber\":\"9603335300\",\"email\":\"pavan@gmail.com\",\"customerStatus\":\"OPEN\",\"address\":{\"addressLine1\":\"lakkavaram\",\"addressLine2\":\"west\",\"street\":\"jungle\",\"postalCode\":\"534451\"}}";
		MessageRequest messageRequest = buildMessageRequestObject();
		MessageRequest result = ObjectMapperUtil.returnObjectFromJsonString(messageRequestString);
		Assertions.assertEquals(messageRequest, result);
	}

	private MessageRequest buildMessageRequestObject() {
		MessageRequest messageRequest = new MessageRequest();
		Address address = buildAddressObject();
		messageRequest.setAddress(address);
		messageRequest.setCountry("India");
		messageRequest.setCountryCode("IN");
		messageRequest.setCustomerNumber("C123456789");
		messageRequest.setCustomerStatus(CustomerStatusEnum.OPEN);
		messageRequest.setEmail("pavan@gmail.com");
		messageRequest.setFirstName("pavan pavan");
		messageRequest.setLastName("kumar kumar");
		messageRequest.setMobileNumber("9603335300");
		return messageRequest;
	}

	private Address buildAddressObject() {
		Address address = new Address();
		address.setAddressLine1("lakkavaram");
		address.setAddressLine2("west");
		address.setPostalCode("534451");
		address.setStreet("jungle");
		return address;
	}

}
