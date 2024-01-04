package com.mp.tractor.exception;

public class InvalidPayloadException extends RuntimeException {
    public InvalidPayloadException(String invalidPayload) {
        super(invalidPayload);
    }
}
