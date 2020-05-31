package com.example.demo.pojo.request;

import com.example.demo.pojo.entity.Book;
import lombok.Data;

/**
 * @program: demo
 * @className: AddBook
 * @description: manager add books
 * @author: lov.moran
 * @date 2020/5/31 下午10:58
 */
@Data
public class AddBook {

    private int number;
    private Book book;
}
