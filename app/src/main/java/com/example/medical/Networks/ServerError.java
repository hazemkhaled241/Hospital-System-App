package com.example.medical.Networks;

public class ServerError {
   private String message;

    public ServerError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
