package com.example.demo.mapper;

import com.example.demo.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
//        testQuery();
    }

    //    @Test
//    public void testUpdate() {
//        System.out.println("----------测试更新------");
//        BlogType type = blogTypeMapper.getOne("455550e8ba444f8aabdd696a0976a6bb");
//        type.setTypeTxt("学习Spring Boot Mybatis");
//        blogTypeMapper.update(type);
//
//        type = blogTypeMapper.getOne("455550e8ba444f8aabdd696a0976a6bb");
//
//        System.out.println(type.getBtId() + "------>" + type.getTypeTxt());
//    }
//
    @Test
    public void testQuery() {
        Book book = bookMapper.getById(5001);
        System.out.println("----------查询数据------");
        System.out.println(book.getId() + "------>" + book.getName() + "------>" + book.getStatus());

    }
//
//    @Test
//    public void testDelete() {
//        System.out.println("----------测试删除------");
//        blogTypeMapper.delete("455550e8ba444f8aabdd696a0976a6bb");
//        testQuery();
//    }
}