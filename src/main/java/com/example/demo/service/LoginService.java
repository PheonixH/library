package com.example.demo.service;

import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo
 * @className: AdminService
 * @description: admin service
 * @author: lov.moran
 * @date 2020/5/30 下午2:43
 */
public interface LoginService {

    BaseResponse registered(Admin admin);

    BaseResponse login(Admin admin);
}
