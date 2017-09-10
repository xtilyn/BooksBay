package com.xtilyna.booksbay.booksbay.menu.events;


public class MenuEvent {

    public final static int onLogoutUserEvent = 0;

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
