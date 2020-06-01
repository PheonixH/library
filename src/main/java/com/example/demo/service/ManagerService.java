package com.example.demo.service;

import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.entity.Admin;
import com.example.demo.pojo.entity.Book;
import com.example.demo.pojo.entity.Reader;
import com.example.demo.pojo.request.AddBook;

import java.util.List;

/**
 * @program: library
 * @className: BookService
 * @description: book service interface
 * @author: lov.moran
 * @date 2020-05-28 19:58
 */

public interface ManagerService {

    BaseResponse queryAllBook();

    BaseResponse insertBook(AddBook addBook);

    BaseResponse deleteBook(List<Book> bookList);

    BaseResponse modifyBook(List<Book> bookList);

    BaseResponse insertReader(Reader reader);

    BaseResponse deleteReader(Reader reader);

    BaseResponse modifyReader(Reader reader);
}
