package com.pkglobal.subscriber.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;

import com.pkglobal.subscriber.converter.AttributeEncryptor;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity(name = "AUDIT_LOG")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Audit {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "id", unique = true, length = 50)
	private String id;

	@Column(name = "customer_Number")
	@Convert(converter = AttributeEncryptor.class)
	private String customerNumber;

	@Convert(converter = AttributeEncryptor.class)
	private String payload;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

}
