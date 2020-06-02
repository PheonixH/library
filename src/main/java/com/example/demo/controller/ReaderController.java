package com.example.demo.controller;

import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.entity.Book;
import com.example.demo.service.ReaderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: library
 * @className: CommonReaderController
 * @description: a common reader controller
 * @author: lov.moran
 * @date 2020-06-02 10:49
 */
@Slf4j
@RestController
@RequestMapping("/reader")
@Api(value = "Reader controller", tags = {"ReaderController"})
public class ReaderController {

    @Autowired
    ReaderService readerService;

    @ApiOperation(value = "just a test, return hello")
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation(value = "query all books")
    @RequestMapping("/queryAllBook")
    public BaseResponse queryAllBooks() {
        return readerService.queryAllBooks();
    }

    @ApiOperation(value = "query a book by id")
    @RequestMapping("/queryByID")
    public BaseResponse queryByID(@RequestBody Book book) {
        return readerService.queryBookByID(book.getId());
    }

    @ApiOperation(value = "query books by name")
    @RequestMapping("/queryByName")
    public BaseResponse queryByName(@RequestBody Book book) {
        return readerService.queryBooksByName(book.getName());
    }

    @ApiOperation(value = "query books by author")
    @RequestMapping("/queryByAuthor")
    public BaseResponse queryByAuthor(@RequestBody Book book) {
        return readerService.queryBooksByAuthor(book.getAuthor());
    }

    @ApiOperation(value = "query books by status")
    @RequestMapping("/queryByStatus")
    public BaseResponse queryByStatus(@RequestBody Book book) {
        return readerService.queryBooksByStatus((int) book.getStatus());
    }

    @ApiOperation(value = "borrow a book")
    @RequestMapping("/borrowBook")
    public BaseResponse borrow(@RequestBody Book book) {
        return readerService.borrowABook(book);
    }

    @ApiOperation(value = "return a book")
    @RequestMapping("/returnBook")
    public BaseResponse returnBook(@RequestBody Book book) {
        return readerService.returnABook(book);
    }
}
