package com.mp.tractor.exception;

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String invalidPosition) {
        super(invalidPosition);
    }
}
