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
import java.util.LinkedList;
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
    public BaseResponse deleteBook(List<Book> bookList) {
        BaseResponse response = null;
        try {
            Map<String, String> failMap = new HashMap<>();
            List<String> successList = new LinkedList<>();
            for (Book abook : bookList) {
                if (String.valueOf(abook.getId()) != null) {
                    Book existBook = bookMapper.getById(abook.getId());
                    if (existBook == null) {
                        failMap.put(abook.getId().toString(),
                                StatusCodeDesc.BOOK_NOT_EXISTS.getDesc());
                    } else {
                        bookMapper.delete(abook);
                        successList.add(abook.getId().toString());
                        Book stillExistBook = bookMapper.getById(abook.getId());
                        if(stillExistBook == null){
                            booksMapper.delete(stillExistBook.getSort());
                        }
                    }
                } else {
                    failMap.put(abook.getId().toString(),
                            StatusCodeDesc.BOOK_ID_NOT_EXISTS.getDesc());
                }
            }
            Map<String, Object> data = new HashMap<>();
            data.put("successList", successList);
            data.put("failList", failMap);
            response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                    StatusCodeDesc.SUCCESS.getDesc(), data);
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }

    @Override
    public BaseResponse modifyBook(List<Book> bookList) {
        BaseResponse response = null;
        try {
            Map<String, String> failMap = new HashMap<>();
            List<String> successList = new LinkedList<>();
            for (Book abook : bookList) {
                if (abook.getId() != null) {
                    Book existBook = bookMapper.getById(abook.getId());
                    if (existBook == null) {
                        failMap.put(abook.getId().toString(),
                                StatusCodeDesc.BOOK_NOT_EXISTS.getDesc());
                    } else {
                        bookMapper.update(abook);
                        successList.add(abook.getId().toString());
                    }
                } else {
                    failMap.put(abook.getId().toString(),
                            StatusCodeDesc.BOOK_ID_NOT_EXISTS.getDesc());
                }
            }
            Map<String, Object> data = new HashMap<>();
            data.put("successList", successList);
            data.put("failList", failMap);
            response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                    StatusCodeDesc.SUCCESS.getDesc(), data);
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
            Reader existReader = readerMapper.getByName(reader.getName());
            if (existReader == null) {
                readerMapper.insert(reader);
            } else {
                response = new BaseResponse(StatusCodeDesc.ACCOUNT_EXISTS.getCode(),
                        StatusCodeDesc.ACCOUNT_EXISTS.getDesc());
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

    @Override
    public BaseResponse deleteReader(Reader reader) {
        BaseResponse response = null;
        try {
            if (reader.getId() != null) {
                Reader existReader = readerMapper.getById(reader.getId());
                if (existReader == null) {
                    response = new BaseResponse(StatusCodeDesc.ACCOUNT_NOT_EXISTS.getCode(),
                            StatusCodeDesc.ACCOUNT_NOT_EXISTS.getDesc());
                } else {
                    readerMapper.delete(reader.getId());
                    response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                            StatusCodeDesc.SUCCESS.getDesc());
                }
            } else {
                response = new BaseResponse(StatusCodeDesc.ACCOUNT_ID_NOT_EXISTS.getCode(),
                        StatusCodeDesc.ACCOUNT_ID_NOT_EXISTS.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }

    @Override
    public BaseResponse modifyReader(Reader reader) {
        BaseResponse response = null;
        try {
            if (reader.getId() != null) {
                Reader existReader = readerMapper.getById(reader.getId());
                if (existReader == null) {
                    response = new BaseResponse(StatusCodeDesc.ACCOUNT_NOT_EXISTS.getCode(),
                            StatusCodeDesc.ACCOUNT_NOT_EXISTS.getDesc());
                } else {
                    readerMapper.update(reader);
                    response = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(),
                            StatusCodeDesc.SUCCESS.getDesc());
                }
            } else {
                response = new BaseResponse(StatusCodeDesc.ACCOUNT_ID_NOT_EXISTS.getCode(),
                        StatusCodeDesc.ACCOUNT_ID_NOT_EXISTS.getDesc());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return response;
    }
}
