package com.example.demo.pojo;

public enum StatusCodeDesc {
    SUCCESS(200, "请求成功接收并处理"),
    NOT_FOUND(404, "请求的资源未找到"),
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