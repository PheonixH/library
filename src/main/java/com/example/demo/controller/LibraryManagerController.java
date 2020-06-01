package com.example.demo.controller;


import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.entity.Book;
import com.example.demo.pojo.entity.Reader;
import com.example.demo.pojo.request.BookList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.demo.pojo.request.AddBook;
import com.example.demo.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
@Api(value = "管理员接口", tags = {"LibraryManagerController"})
public class LibraryManagerController {

    @Autowired
    ManagerService service;

    @ApiOperation(value = "hello world")
    @RequestMapping("/hello")
    public String oldWelcome() {
        return "welcome to the library system!";
    }

    @ApiOperation(value = "welcome to manage system")
    @RequestMapping("/welcome")
    public String newWelcome() {
        return "welcome to the new library system!";
    }


    @ApiOperation(value = "show all books")
    @RequestMapping("/showBooks")
    public BaseResponse showBooks() {
        return service.queryAllBook();
    }

    @ApiOperation(value = "add some books")
    @RequestMapping("/addBooks")
    public BaseResponse addBooks(@RequestBody AddBook addBook) {
        return service.insertBook(addBook);
    }

    @ApiOperation(value = "delete some books")
    @RequestMapping("/deleteBooks")
    public BaseResponse deleteBooks(@RequestBody BookList bookList) {
        return service.deleteBook(bookList.getBooks());
    }

    @ApiOperation(value = "modify some books, could not modify sort")
    @RequestMapping("/modifyBooks")
    public BaseResponse modifyBooks(@RequestBody BookList bookList) {
        return service.modifyBook(bookList.getBooks());
    }

    @ApiOperation(value = "add a common reader")
    @RequestMapping("/addReader")
    public BaseResponse addReader(@RequestBody Reader reader) {
        return service.insertReader(reader);
    }

    @ApiOperation(value = "delete a common reader")
    @RequestMapping("/deleteReader")
    public BaseResponse deleteReader(@RequestBody Reader reader) {
        return service.deleteReader(reader);
    }

    @ApiOperation(value = "modify a common reader")
    @RequestMapping("/modifyReader")
    public BaseResponse modifyReader(@RequestBody Reader reader) {
        return service.modifyReader(reader);
    }

}
