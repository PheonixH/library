package com.example.demo.service.impl;

import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.StatusCodeDesc;
import com.example.demo.pojo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
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
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public BaseResponse queryAllBook() {
        BaseResponse response = null;
        try {
            List<Book> bookList = bookMapper.getAll();
            Map paramMap = new HashMap();
            paramMap.put("BookList", bookList);
            response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                    StatusCodeDesc.SUCCESS.getDesc(), paramMap);
        } catch (Exception e) {
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }
}
