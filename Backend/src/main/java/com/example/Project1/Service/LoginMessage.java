package com.example.Project1.Service;

public class LoginMessage {
    private String message;
    private Boolean status;
    private String token;
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public Boolean getStatus(){
        return status;
    }
    public void setStatus(Boolean status){
        this.status=status;
    }
    public void setToken(String token){
        this.token=token;
    }
    public String getToken(){
        return token;
    }

    public LoginMessage(String message,Boolean status,String token){
        this.message=message;
        this.status=status;
        this.token=token;
    }


}
