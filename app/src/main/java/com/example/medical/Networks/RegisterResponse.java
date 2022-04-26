package com.example.medical.Networks;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String errorMessage;
    @SerializedName("data")
   private ConfirmationData confirmationData;


    public boolean isSuccess(){
        return status==1;
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

    public ConfirmationData getRegisterData() {
        return confirmationData;
    }

    public void setRegisterData(ConfirmationData confirmationData) {
        this.confirmationData = confirmationData;
    }
}
