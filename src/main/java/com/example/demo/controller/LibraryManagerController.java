package com.example.demo.controller;


import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.entity.Admin;
import com.example.demo.pojo.request.AddBook;
import com.example.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(value = "/admin")
public class LibraryManagerController {

    @Autowired
    BookService bookService;

    @RequestMapping("/hello")
    public String oldWelcome() {
        return "welcome to the library system!";
    }

    @RequestMapping("/welcome")
    public String newWelcome() {
        return "welcome to the new library system!";
    }

    @RequestMapping("/showBooks")
    public BaseResponse showBooks() {
        return bookService.queryAllBook();
    }

    @RequestMapping("/addBooks")
    public BaseResponse addBooks(@RequestBody AddBook addBook) {
        return bookService.insertBook(addBook);
    }


}
