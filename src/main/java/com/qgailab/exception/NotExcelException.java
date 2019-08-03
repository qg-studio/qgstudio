package com.qgailab.exception;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:36
 */
public class NotExcelException extends RuntimeException {
    public NotExcelException() {
        super();
    }

    public NotExcelException(String message) {
        super(message);
    }

    public NotExcelException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExcelException(Throwable cause) {
        super(cause);
    }

    protected NotExcelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
