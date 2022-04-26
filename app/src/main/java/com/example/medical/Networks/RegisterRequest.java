package com.example.medical.Networks;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {
private String email;
@SerializedName("first_name")
private String firstName;
@SerializedName("last_name")
private String lastName;
private String password;
private String gender;
private String birthday;
private String status;
private String address;

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", specialist='" + specialist + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private String mobile;
private String specialist;
private String type;

    public RegisterRequest(String email, String firstName, String lastName,
                           String password, String gender,
                           String birthday, String status,
                           String address, String mobile, String specialist,
                           String type) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
        this.address = address;
        this.mobile = mobile;
        this.specialist = specialist;
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
