package com.example.Exception;

public class ErrorResponse {
    private String errorCode;
    private String message;

    //first of all need because return the error 
    public ErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

   

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
