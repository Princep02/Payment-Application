package com.example.Project1.Service.DTOs;

public class LoginDTO {
    private String phonenumber;
    private String password;
    public LoginDTO() {
    }
    
    public LoginDTO(String phonenumber,String password){
        this.phonenumber=phonenumber;
        this.password=password;
    }
    // Add getters for phonenumber and password
    public String getphonenumber() {
        return phonenumber;
    }

    public String getPassword() {
        return password;
    }
    
    // Optionally, add setters if needed
    public void setphonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
