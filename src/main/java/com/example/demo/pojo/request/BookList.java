package com.example.demo.pojo.request;

import com.example.demo.pojo.entity.Book;
import lombok.Data;

import java.util.LinkedList;

/**
 * @program: library
 * @className: BookList
 * @description: book list
 * @author: lov.moran
 * @date 2020-06-01 16:26
 */
@Data
public class BookList {
    private LinkedList<Book> books;
}
