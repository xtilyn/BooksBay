package com.xtilyna.booksbay.booksbay.home.events;


public class HomeEvent {

    public final static int onFailedToRecoverSession = 0;
    public final static int onNoPostsToShowError = 1;


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
