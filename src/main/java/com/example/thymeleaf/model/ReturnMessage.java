package com.example.thymeleaf.model;

public class ReturnMessage {

    String returnMessage;

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    @Override
    public String toString() {
        return returnMessage;
    }
}
