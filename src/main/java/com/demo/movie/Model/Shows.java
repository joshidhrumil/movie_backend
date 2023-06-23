package com.demo.movie.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Shows {

    @Id
    private String showId;
    private String startTime;
    private String endTime;
    private boolean softDelete;


    public Shows() {
    }

    @Autowired
    public Shows( String startTime , String endTime, boolean softDelete) {

        this.startTime = startTime;
        this.endTime = endTime;
        this.softDelete =softDelete;

    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
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
