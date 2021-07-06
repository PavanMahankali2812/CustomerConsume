package com.pkglobal.subscriber.exception;

public class ConsumerServiceException extends RuntimeException {

    private static final long serialVersionUID = 1508326122999959630L;
    private final String statusMessage;

    public ConsumerServiceException(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
