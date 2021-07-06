package com.pkglobal.subscriber.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Customer Status
 */
public enum CustomerStatusEnum {
    OPEN("OPEN"),

    CLOSE("CLOSE"),

    SUSPENDED("SUSPENDED"),

    RESTORED("RESTORED");

    private String value;

    private CustomerStatusEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static CustomerStatusEnum fromValue(String text) {
        for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
