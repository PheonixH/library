package com.example.demo.pojo;

public enum StatusCodeDesc {
    SUCCESS(200, "操作成功"),
    LOGIN_FAIL_WRONG_INFORMATION(1001,"帐号或密码错误"),
    ACCOUNT_EXISTS(1002, "帐号已存在"),
    ACCOUNT_NOT_EXISTS(1003, "帐号不存在"),
    ACCOUNT_ID_NOT_EXISTS(1004, "帐号ID缺失"),
    ACCOUNT_TOKEN_INVALID(1005, "帐号认证失败"),
    BOOK_NOT_EXISTS(2001, "书籍不存在"),
    BOOK_ID_NOT_EXISTS(2002, "书籍ID缺失"),
    BOOK_IS_BORROWED(2003,"书籍已经借出"),
    BOOK_IS_KEEPING(2004,"该书籍是保留书籍，暂不可借出"),
    BOOK_IS_RETURN(2005,"书籍已经在仓库中"),
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
