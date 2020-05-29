package com.example.demo.pojo;

import lombok.Data;

/**
 * @program: library
 * @className: BaseResponse
 * @description: base response
 * @author: lov.moran
 * @date 2020-05-28 20:29
 */
@Data
public class BaseResponse {

    private int code;

    private String desc;

    private Object data;

    public BaseResponse(int code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public BaseResponse(int code, String desc) {
        this.code = code;
        this.desc = desc;
        this.data = null;
    }

}
