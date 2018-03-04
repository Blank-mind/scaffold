package com.appauth.model;


import com.appauth.config.ResultStatus;

public class ResultModel {

    private int code;

    private String message;

    private Object content;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getContent() {
        return content;
    }

    public ResultModel(int code, String message) {
        this.code = code;
        this.message = message;
        this.content = "";
    }

    public ResultModel(int code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public ResultModel(ResultStatus status) {
        this.message = status.getMessage();
        this.code = status.getCode();
        this.content = "";
    }

    public ResultModel(ResultStatus status, Object content) {
        this.message = status.getMessage();
        this.code = status.getCode();
        this.content = "";
    }

    public static ResultModel ok() {
        return new ResultModel(ResultStatus.SUCCESS);
    }

    public static ResultModel ok(Object content) {
        return new ResultModel(ResultStatus.SUCCESS, content);
    }

    public static ResultModel error(ResultStatus status) {
        return new ResultModel(status);
    }


}
