package com.haubui.sample.exception;

import com.haubui.sample.common.exception.GeneralException;

public class UserException extends GeneralException {

    private String errorCode;

    private String errorMessage;

    private Object[] params;

    public UserException() {
        super();
    }

    public UserException(String errorMessage) {
        super(errorMessage);
    }

    public UserException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public UserException(String errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public UserException(String errorCode, String errorMessage, Object[] params, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.params = params;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Object[] getParams() {
        return params;
    }
}
