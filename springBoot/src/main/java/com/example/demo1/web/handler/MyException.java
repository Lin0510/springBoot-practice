package com.example.demo1.web.handler;

public class MyException extends RuntimeException {

    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
