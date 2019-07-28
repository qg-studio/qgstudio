package com.qgailab.exception;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:36
 */
public class PathNotExistException extends RuntimeException {
    public PathNotExistException() {
        super();
    }

    public PathNotExistException(String message) {
        super(message);
    }

    public PathNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PathNotExistException(Throwable cause) {
        super(cause);
    }

    protected PathNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
