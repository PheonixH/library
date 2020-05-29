package com.example.demo.mapper;

import com.example.demo.pojo.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testInsert() {
        System.out.println("----------测试插入------");
        Book type = new Book();
        type.setId(5001);
        type.setSort("T1001");
        type.setName("Spring Boot MyBatis 实例讲解");
        type.setAuthor("A");
        type.setStatus(1);
        bookMapper.insert(type);
        testQuery();
    }

    @Test
    public void testUpdate() {
        System.out.println("----------测试更新------");
        Book book = bookMapper.getById(5001);
        book.setName("学习Spring Boot Mybatis");
        bookMapper.update(book);

        book = bookMapper.getById(5001);

        System.out.println("id:" + book.getId() + "-sort id:" + book.getSort() + "-name:" + book.getName()
                + "-author:" + book.getAuthor() + "-status:" + book.getStatus());
    }

    @Test
    public void testQuery() {
        List<Book> list = bookMapper.getAll();
        System.out.println("----------查询数据------");
        list.stream().forEach(item -> {
            System.out.println("id:" + item.getId() + "-sort id:" + item.getSort() + "-name:" + item.getName()
                    + "-author:" + item.getAuthor() + "-status:" + item.getStatus());
        });
    }

    @Test
    public void testDelete() {
        System.out.println("----------测试删除------");
        bookMapper.delete(5001);
        testQuery();
    }
}