package com.why.bdb.exceptions;

public class BdbException extends RuntimeException {

    public BdbException(String msg) {
        super(msg);
    }

    public BdbException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BdbException(Throwable cause) {
        super(cause);
    }
}
