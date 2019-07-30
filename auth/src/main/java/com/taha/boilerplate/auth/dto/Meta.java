package com.taha.boilerplate.auth.dto;

public class Meta {

    private String status = "success";
    private String code = "200";
    private String message = "success";

    public Meta(){}

    public Meta(String status, String code, String message){
        setStatus(status);
        setCode(code);
        setMessage(message);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
