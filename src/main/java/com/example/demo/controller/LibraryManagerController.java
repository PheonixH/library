package com.example.demo.controller;


import com.example.demo.pojo.BaseResponse;
import com.example.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: libraryDemo
 * @className: LibraryManagerController
 * @description: Library System Manage Controller
 * @author: lov.moran
 * @date 2020-05-27 19:00
 */
@Slf4j
@RestController
@RequestMapping(value = "/manager")
public class LibraryManagerController {

    @Autowired
    BookService bookService;

    @RequestMapping("/hello")
    public String welcome() {
        return "welcome to the library system!";
    }

    @RequestMapping("/showBooks")
    public BaseResponse showBooks() {
        return bookService.queryAllBook();
    }


}
