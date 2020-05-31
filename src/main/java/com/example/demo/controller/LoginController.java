package com.example.demo.controller;

import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.entity.Admin;
import com.example.demo.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo
 * @className: LoginController
 * @description: login controller
 * @author: lov.moran
 * @date 2020/5/31 下午5:10
 */
@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {


    @Autowired
    AdminService adminService;

    @RequestMapping("/index")
    public String index(){
        return "loginPage";
    }

    @PostMapping(value = "/registered")
    public BaseResponse registered(@RequestBody Admin admin) {
        return adminService.registered(admin);
    }


    @RequestMapping(value = "/adminLogin")
    public String login(@RequestBody Admin admin, RedirectAttributes model, HttpServletResponse response) {
        BaseResponse baseResponse =  adminService.login(admin);
        if (baseResponse.getCode() == 200){
            Cookie cookie = new Cookie("isLogin", "yes");
            // 设置为30min
            cookie.setMaxAge(30 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "admin";
        } else {
            model.addFlashAttribute("error", "密码错误");
            return "loginPage";
        }
    }
}
