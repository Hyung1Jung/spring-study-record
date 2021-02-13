package com.example.validatingforminput.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Time;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private String date;
    private String milliseconds_since_epoch;
    private String time;

    public Value() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMilliseconds_since_epoch() {
        return milliseconds_since_epoch;
    }

    public void setMilliseconds_since_epoch(String milliseconds_since_epoch) {
        this.milliseconds_since_epoch = milliseconds_since_epoch;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Value{" +
                "date='" + date + '\'' +
                ", milliseconds_since_epoch='" + milliseconds_since_epoch + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

}