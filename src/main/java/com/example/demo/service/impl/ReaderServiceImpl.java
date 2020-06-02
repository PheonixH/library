package com.example.demo.service.impl;

import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.ReaderMapper;
import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.StatusCodeDesc;
import com.example.demo.pojo.entity.Book;
import com.example.demo.pojo.entity.Reader;
import com.example.demo.service.ReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: library
 * @className: ReaderServiceImpl
 * @description: reader service class
 * @author: lov.moran
 * @date 2020-06-02 11:25
 */
@Service
@Slf4j
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Reader findById(Reader reader) {
        return readerMapper.getById(reader.getId());
    }

    @Override
    public Reader findByName(Reader reader) {
        return readerMapper.getByName(reader.getName());
    }

    @Override
    public BaseResponse queryAllBooks() {
        BaseResponse response = null;
        try {
            List<Book> bookList = bookMapper.getAll();
            Map paramMap = new HashMap();
            paramMap.put("TotalNumber", bookList.size());
            paramMap.put("BookList", bookList);
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
    public BaseResponse queryBookByID(Long id) {
        BaseResponse response = null;
        try {
            Book book = bookMapper.getById(id);
            if (book == null) {
                response = new BaseResponse(StatusCodeDesc.BOOK_NOT_EXISTS.getCode(),
                        StatusCodeDesc.BOOK_NOT_EXISTS.getDesc());
            } else {
                Map paramMap = new HashMap();
                paramMap.put("Book", book);
                response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                        StatusCodeDesc.SUCCESS.getDesc(), paramMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }

    @Override
    public BaseResponse queryBooksByName(String name) {
        BaseResponse response = null;
        try {
            List<Book> bookList = bookMapper.getByName(name);
            if (bookList.isEmpty()) {
                response = new BaseResponse(StatusCodeDesc.BOOK_NOT_EXISTS.getCode(),
                        StatusCodeDesc.BOOK_NOT_EXISTS.getDesc());
            } else {
                Map paramMap = new HashMap();
                paramMap.put("TotalNumber", bookList.size());
                paramMap.put("BookList", bookList);
                response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                        StatusCodeDesc.SUCCESS.getDesc(), paramMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }

    @Override
    public BaseResponse queryBooksByAuthor(String author) {
        BaseResponse response = null;
        try {
            List<Book> bookList = bookMapper.getByAuthor(author);
            if (bookList.isEmpty()) {
                response = new BaseResponse(StatusCodeDesc.BOOK_NOT_EXISTS.getCode(),
                        StatusCodeDesc.BOOK_NOT_EXISTS.getDesc());
            } else {
                Map paramMap = new HashMap();
                paramMap.put("TotalNumber", bookList.size());
                paramMap.put("BookList", bookList);
                response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                        StatusCodeDesc.SUCCESS.getDesc(), paramMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }

    @Override
    public BaseResponse queryBooksByStatus(int status) {
        BaseResponse response = null;
        try {
            List<Book> bookList = bookMapper.getByStatus(status);
            if (bookList.isEmpty()) {
                response = new BaseResponse(StatusCodeDesc.BOOK_NOT_EXISTS.getCode(),
                        StatusCodeDesc.BOOK_NOT_EXISTS.getDesc());
            } else {
                Map paramMap = new HashMap();
                paramMap.put("TotalNumber", bookList.size());
                paramMap.put("BookList", bookList);
                response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                        StatusCodeDesc.SUCCESS.getDesc(), paramMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }

    @Override
    public BaseResponse borrowABook(Book book) {
        BaseResponse response = null;
        try {
            Book existingBook = bookMapper.getById(book.getId());
            if (existingBook == null) {
                response = new BaseResponse(StatusCodeDesc.BOOK_NOT_EXISTS.getCode(),
                        StatusCodeDesc.BOOK_NOT_EXISTS.getDesc());
            } else if (existingBook.getStatus() == 2) {
                response = new BaseResponse(StatusCodeDesc.BOOK_IS_BORROWED.getCode(),
                        StatusCodeDesc.BOOK_IS_BORROWED.getDesc());
            } else if (existingBook.getStatus() == 3) {
                response = new BaseResponse(StatusCodeDesc.BOOK_IS_KEEPING.getCode(),
                        StatusCodeDesc.BOOK_IS_KEEPING.getDesc());
            } else {
                existingBook.setStatus(2);
                bookMapper.update(existingBook);
                response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                        StatusCodeDesc.SUCCESS.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }

    @Override
    public BaseResponse returnABook(Book book) {
        BaseResponse response = null;
        try {
            Book existingBook = bookMapper.getById(book.getId());
            if (existingBook == null) {
                response = new BaseResponse(StatusCodeDesc.BOOK_NOT_EXISTS.getCode(),
                        StatusCodeDesc.BOOK_NOT_EXISTS.getDesc());
            } else if (existingBook.getStatus() == 1) {
                response = new BaseResponse(StatusCodeDesc.BOOK_IS_RETURN.getCode(),
                        StatusCodeDesc.BOOK_IS_RETURN.getDesc());
            } else if (existingBook.getStatus() == 3) {
                response = new BaseResponse(StatusCodeDesc.BOOK_IS_KEEPING.getCode(),
                        StatusCodeDesc.BOOK_IS_KEEPING.getDesc());
            } else {
                existingBook.setStatus(1);
                bookMapper.update(existingBook);
                response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                        StatusCodeDesc.SUCCESS.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }


}
