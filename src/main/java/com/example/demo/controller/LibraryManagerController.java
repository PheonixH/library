package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @program: libraryDemo
 * @className: LibraryManagerController
 * @description: Library System Manage Controller
 * @author: lov.moran
 * @date 2020-05-27 19:00
 * */

@RestController
public class LibraryManagerController {

    @RequestMapping("/hello")
    public String welcome(){
        return "welcome to the library system!";
    }

    @RequestMapping("/showBooks")
    public String showBooks(){

        return "welcome to the library system!";
    }
}
