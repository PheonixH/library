package com.example.demo.mapper;

import com.example.demo.pojo.entity.Admin;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    void getAll() {
        System.out.println("========== getAll() test ==========");
        List<Admin> adminList = adminMapper.getAll();
        for (Admin a : adminList) {
            System.out.println(a.getName() + ":" + a.getPassword());
        }
        System.out.println("======== getAll() test end ========");
    }

    @Test
    void getByName() {
        System.out.println("========== getByName() test ==========");
        Admin a = adminMapper.getByName("manager");
        System.out.println(a.getName() + ":" + a.getPassword());
        System.out.println("======== getByName() test end ========");
    }

    @Test
    void insert() {
    }

    @Test
    void updateByName() {
    }

    @Test
    void delete() {
    }

    @Test
    void login() {
    }
}