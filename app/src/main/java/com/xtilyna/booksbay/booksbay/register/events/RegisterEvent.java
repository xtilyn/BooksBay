package com.xtilyna.booksbay.booksbay.register.events;



public class RegisterEvent {

    public final static int onEmailAlreadyExistError = 0;
    public final static int onFailedToRegisterError = 1;
    public final static int onRegisterSuccess = 2;
    public final static int onVerificationEmailError = 3;

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
