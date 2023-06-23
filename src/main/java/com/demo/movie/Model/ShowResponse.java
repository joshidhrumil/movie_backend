package com.demo.movie.Model;

public class ShowResponse {

    public String Message;
    public String startTime;
    public String endTime;

    public ShowResponse(String message, String startTime, String endTime) {
        Message = message;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ShowResponse() {
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
