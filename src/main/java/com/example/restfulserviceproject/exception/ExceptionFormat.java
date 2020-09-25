package com.example.restfulserviceproject.exception;

import java.util.Date;

public class ExceptionFormat {

    Date timestamp;
    String msg;
    String desc;

    public ExceptionFormat(Date timestamp, String msg, String desc) {
        this.timestamp = timestamp;
        this.msg = msg;
        this.desc = desc;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public String getDesc() {
        return desc;
    }
}
