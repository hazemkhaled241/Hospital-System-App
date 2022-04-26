package com.example.medical.Networks;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String errorMessage;
    @SerializedName("data")
    private ConfirmationData confirmationData;


    public boolean isSuccess(){
        return status==1;
    }

    public LoginResponse(int status, String errorMessage, ConfirmationData confirmationData) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.confirmationData = confirmationData;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ConfirmationData getConfirmationData() {
        return confirmationData;
    }

    public void setConfirmationData(ConfirmationData confirmationData) {
        this.confirmationData = confirmationData;
    }
}
