package com.example.demo.mapper;

import com.example.demo.domain.Book;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/*
 * @program: library
 * @className: BookMapper
 * @description: book mapper
 * @author: lov.moran
 * @date 2020-05-28 00:58
 * */
@Mapper
public interface BookMapper {

    @Select("SELECT * FROM BOOK")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "SORT", property = "sort", jdbcType = JdbcType.INTEGER),
            @Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "AUTHOR", property = "author", jdbcType = JdbcType.VARCHAR),
            @Result(column = "STATUS", property = "status", jdbcType = JdbcType.INTEGER)
    })
    List<Book> getAll();

    @Select("SELECT * FROM BOOK WHERE ID = #{id}")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "SORT", property = "sort", jdbcType = JdbcType.INTEGER),
            @Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "AUTHOR", property = "author", jdbcType = JdbcType.VARCHAR),
            @Result(column = "STATUS", property = "status", jdbcType = JdbcType.INTEGER)
    })
    Book getById(long id);

    @Insert("INSERT INTO BOOK(ID, SORT, NAME, AUTHOR, STATUS) VALUES(#{id}, #{sort}, #{name}, #{author}, #{status})")
    void insert(Book book);

    @Update("INSERT INTO BOOK(ID, SORT, NAME, AUTHOR, STATUS) VALUES(#{id}, #{sort}, #{name}, #{author}, #{status})")
    void update(Book book);

    @Delete("DELETE FROM BOOK WHERE ID = #{id}")
    void delete(long Id);
}
