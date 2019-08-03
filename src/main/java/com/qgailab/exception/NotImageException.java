package com.qgailab.exception;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:36
 */
public class NotImageException extends RuntimeException {
    public NotImageException() {
        super();
    }

    public NotImageException(String message) {
        super(message);
    }

    public NotImageException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotImageException(Throwable cause) {
        super(cause);
    }

    protected NotImageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
