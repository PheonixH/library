package com.example.demo.service.impl;

import com.example.demo.mapper.BooksMapper;
import com.example.demo.mapper.ReaderMapper;
import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.StatusCodeDesc;
import com.example.demo.pojo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.pojo.entity.Books;
import com.example.demo.pojo.entity.Reader;
import com.example.demo.pojo.request.AddBook;
import com.example.demo.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: library
 * @className: BookServiceImpl
 * @description: book service impl class
 * @author: lov.moran
 * @date 2020-05-28 20:00
 */
@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BooksMapper booksMapper;

    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public BaseResponse queryAllBook() {
        BaseResponse response = null;
        try {
            List<Book> bookList = bookMapper.getAll();
            Map paramMap = new HashMap();
            paramMap.put("BookList", bookList);
            paramMap.put("TotalNumber", bookList.size());
            response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                    StatusCodeDesc.SUCCESS.getDesc(), paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }

    @Override
    public BaseResponse insertBook(AddBook addBook) {
        BaseResponse response = null;
        try {
            Books existBooks = booksMapper.getBySort(addBook.getBook().getSort());
            if (existBooks == null) {
                Books newBooks = new Books(addBook.getBook().getSort(), addBook.getBook().getName(),
                        addBook.getBook().getAuthor(), addBook.getNumber(), addBook.getNumber());
                booksMapper.insert(newBooks);
            } else {
                existBooks.setSum(existBooks.getSum() + addBook.getNumber());
                existBooks.setExists(existBooks.getExists() + addBook.getNumber());
                booksMapper.update(existBooks);
            }
            for (int i = 0; i < addBook.getNumber(); i++) {
                bookMapper.insert(addBook.getBook());
            }
            response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                    StatusCodeDesc.SUCCESS.getDesc());
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }

    @Override
    public BaseResponse insertReader(Reader reader) {
        BaseResponse response = null;
        try {
            Reader existReader = readerMapper.getId(reader.getName());
            if (existReader == null) {
                readerMapper.insert(reader);
            } else {
                Map<String, String> result = new HashMap<>();
                result.put("FailReason", "同名帐号已存在");
                response = new BaseResponse(StatusCodeDesc.EXISTS.getCode(),
                        StatusCodeDesc.EXISTS.getDesc(), result);
                return response;
            }
            response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                    StatusCodeDesc.SUCCESS.getDesc());
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }
}
