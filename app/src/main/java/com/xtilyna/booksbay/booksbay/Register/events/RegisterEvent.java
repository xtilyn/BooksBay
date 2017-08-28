package com.xtilyna.booksbay.booksbay.Register.events;



public class RegisterEvent {

    public final static int onEmailAlreadyExistError = 0;
    public final static int onFailedToRegisterError = 1;
    public final static int onRegisterSuccess = 2;

    private int eventType;
    private String errorMessage;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
