package com.example.demo.pojo;

public enum StatusCodeDesc {
    SUCCESS(200, "请求成功接收并处理"),
    LOGIN_FAIL_WRONG_INFORMATION(1001,"帐号或密码错误"),
    ACCOUNT_EXISTS(1002, "帐号已存在"),
    ACCOUNT_NOT_EXISTS(1003, "帐号不存在"),
    ACCOUNT_ID_NOT_EXISTS(1004, "帐号ID缺失"),
    BOOK_NOT_EXISTS(2001, "书籍不存在"),
    BOOK_ID_NOT_EXISTS(2002, "书籍ID缺失"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误，导致无法完成请求的内容");

    private int code;

    private String desc;

    StatusCodeDesc(int code, String desc) {
        this.setCode(code);
        this.setDesc(desc);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
