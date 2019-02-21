package com.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
    Date timeStamp;
    String message;
    String details;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public ExceptionResponse(Date timeStamp, String message, String details) {

        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
