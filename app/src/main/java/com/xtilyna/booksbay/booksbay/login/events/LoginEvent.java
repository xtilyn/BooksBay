package com.xtilyna.booksbay.booksbay.login.events;


public class LoginEvent {

    public final static int ON_EMAIL_UNVERIFIED_ERROR = 0;
    public final static int ON_PASSWORD_ERROR = 1;
    public final static int ON_INVALID_USER_ERROR = 2;
    public final static int ON_SIGN_IN_ERROR = 3;
    public final static int ON_LOGIN_SUCCESS = 4;
    public final static int ON_PASSWORD_RESET_EMAIL_SEND = 5; // TODO

    private int eventType;
    private String message;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
