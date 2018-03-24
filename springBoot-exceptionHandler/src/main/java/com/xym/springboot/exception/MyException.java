package com.xym.springboot.exception;

/**
 * @author xym
 */
public class MyException extends  Exception {

    public MyException(String message) {
        super(message);
    }

    public MyException() {
        super();
    }
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
