package com.center.common.error;

public class SystemError extends Error {

    public SystemError() {
        super();
    }

    public SystemError(String message) {
        super(message);
    }

    public SystemError(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemError(Throwable cause) {
        super(cause);
    }

}
