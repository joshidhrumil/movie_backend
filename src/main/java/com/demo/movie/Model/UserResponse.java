package com.demo.movie.Model;

public class UserResponse
{
    public String Message;

    public UserResponse() {
    }

    public UserResponse(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
