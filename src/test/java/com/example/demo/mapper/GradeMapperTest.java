package com.example.demo.mapper;

import com.example.demo.domain.Book;
import com.example.demo.domain.Grade;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class GradeMapperTest {
    @Autowired
    GradeMapper gradeMapper;

    @Test
    void getAll() {
        List<Grade> list = gradeMapper.getAll();
        System.out.println("----------查询数据------");
        list.stream().forEach(item -> {
            System.out.println("id:" + item.getId() + "-sort max:" + item.getMax());
        });
    }

    @Test
    void insert() {
        System.out.println("----------测试插入------");
        Grade grade = new Grade(0, 0);
        gradeMapper.insert(grade);
        getAll();
    }

    @Test
    void update() {
        System.out.println("----------测试更新------");
        Grade grade = new Grade(0, 1);
        gradeMapper.insert(grade);
        getAll();
    }

    @Test
    void delete() {
        System.out.println("----------测试删除------");
        gradeMapper.delete(0);
        getAll();
    }
}