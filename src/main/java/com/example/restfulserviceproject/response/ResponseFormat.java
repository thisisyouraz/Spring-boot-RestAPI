package com.example.restfulserviceproject.response;

public class ResponseFormat {

    private int resultCode;
    private String msg;
    private String desc;

    public ResponseFormat(int resultCode, String msg, String desc) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.desc = desc;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
