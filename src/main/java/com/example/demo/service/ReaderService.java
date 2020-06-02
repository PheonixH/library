package com.example.demo.service;

import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.entity.Book;
import com.example.demo.pojo.entity.Reader;

/**
 * @program: library
 * @className: ReaderService
 * @description: reader service interface
 * @author: lov.moran
 * @date 2020-06-02 11:24
 */
public interface ReaderService {

    Reader findById(Reader reader);

    Reader findByName(Reader reader);

    BaseResponse queryAllBooks();

    BaseResponse queryBookByID(Long id);

    BaseResponse queryBooksByName(String name);

    BaseResponse queryBooksByAuthor(String author);

    BaseResponse queryBooksByStatus(int status);

    BaseResponse borrowABook(Book book);

    BaseResponse returnABook(Book book);
}
