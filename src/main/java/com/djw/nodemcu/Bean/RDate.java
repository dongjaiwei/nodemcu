package com.djw.nodemcu.Bean;

public class RDate<D>  {
    public int code = 200;
    public String message = "成功";
    public D data;

    public RDate(String message, D data) {
        this.message = message;
        this.data = data;
    }

    public RDate(D data) {
        this.data = data;
    }

    public RDate(int code, String message, D data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
