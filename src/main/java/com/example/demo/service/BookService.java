package com.example.demo.service;

import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.entity.Admin;
import com.example.demo.pojo.request.AddBook;

/**
 * @program: library
 * @className: BookService
 * @description: book service interface
 * @author: lov.moran
 * @date 2020-05-28 19:58
 */

public interface BookService {

    BaseResponse queryAllBook();

    BaseResponse insertBook(AddBook addBook);
}
