package com.example.demo.mapper;

import com.example.demo.pojo.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: demo
 * @className: AdminMapper
 * @description: admin mapper
 * @author: lov.moran
 * @date 2020/5/30 下午1:19
 */
public interface AdminMapper {
    /**
     * Gets all.
     *
     * @return the all
     */
    @Select("SELECT * FROM ADMIN")
    List<Admin> getAll();

    /**
     * Gets one.
     *
     * @param name the name
     * @return the all
     */
    @Select("SELECT * FROM ADMIN WHERE NAME = #{name}")
    Admin getByName(String name);

    /**
     * Insert.
     *
     * @param admin the admin
     */
    @Insert("INSERT INTO ADMIN(NAME, PASSWORD) VALUES(#{name}, #{password})")
    void insert(Admin admin);

    /**
     * Update.
     *
     * @param admin the admin
     */
    @Update("UPDATE ADMIN SET PASSWORD = #{password} WHERE NAME = #{name}")
    void updateByName(Admin admin);

    /**
     * Delete.
     *
     * @param name the name
     */
    @Delete("DELETE FROM ADMIN WHERE NAME = #{name}")
    void delete(String name);

    /**
     * 登录
     *
     * @param admin the admin
     * @return
     */
    @Select("SELECT A.NAME FROM ADMIN A WHERE A.NAME = #{name} AND A.PASSWORD = #{password}")
    String login(Admin admin);
}
