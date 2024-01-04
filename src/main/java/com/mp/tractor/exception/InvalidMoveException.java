package com.mp.tractor.exception;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(String invalidMove) {
        super(invalidMove);
    }
}
