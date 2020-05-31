package com.example.demo.service.impl;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.StatusCodeDesc;
import com.example.demo.pojo.entity.Admin;
import com.example.demo.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo
 * @className: AdminServiceImpl
 * @description: admin service impl
 * @author: lov.moran
 * @date 2020/5/30 下午2:43
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public BaseResponse registered(Admin admin) {
        BaseResponse baseResponse = null;
        try {
            Admin existAdmin = adminMapper.getByName(admin.getName());
            if (existAdmin != null) {
                baseResponse = new BaseResponse(201, "用户名已存在");
                return baseResponse;
            }
            adminMapper.insert(admin);
            baseResponse = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(), "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return baseResponse;
    }

    @Override
    public BaseResponse login(Admin admin) {
        BaseResponse baseResponse = null;
        try {
            String adminName = adminMapper.login(admin);
            if (adminName == null) {
                baseResponse = new BaseResponse(StatusCodeDesc.LOGIN_FAIL_WRONG_INFORMATION.getCode(),
                        StatusCodeDesc.LOGIN_FAIL_WRONG_INFORMATION.getDesc());

                return baseResponse;
            }
            baseResponse = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(), "登陆成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return baseResponse;
    }
}
