package com.pe.seek.exception;

public class InternalErrorException extends RuntimeException {

	private String message;

    public InternalErrorException() {}

    public InternalErrorException(String msg) {
        super(msg);
        this.message = msg;
    }
}
