package org.babycobol.exception;

public class ExecutionStoppedException extends RuntimeException {
    public ExecutionStoppedException(String message) {
        super(message);
    }
}
