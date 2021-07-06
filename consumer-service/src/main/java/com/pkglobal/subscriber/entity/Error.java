package com.pkglobal.subscriber.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity(name = "ERROR_LOG")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Error {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", unique = true, length = 50)
    private String id;

    @Column(name = "error_type")
    private String errorType;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "error_description")
    private String errorDescription;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String payload;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}
