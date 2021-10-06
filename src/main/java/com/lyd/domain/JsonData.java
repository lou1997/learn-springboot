package com.lyd.domain;

public class JsonData {
    private int code;//状态码，0表示成功，-1表示失败  可加更多
    private Object data; //结果

    private String msg; //错误描述

    public String getMsg() {
        return msg;
    }

    public JsonData(int code, String msg,Object data) {
        this.code = code;
        this.msg = msg;
        this.data=data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }
}
