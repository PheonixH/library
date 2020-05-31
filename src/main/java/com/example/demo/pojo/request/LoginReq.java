package com.example.demo.pojo.request;

import lombok.Data;

/**
 * @program: demo
 * @className: LoginReq
 * @description: login request json
 * @author: lov.moran
 * @date 2020/5/30 下午3:11
 */
@Data
public class LoginReq {
    private String name;
    private String password;
}
