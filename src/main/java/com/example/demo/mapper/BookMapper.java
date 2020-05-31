package com.example.demo.mapper;

import com.example.demo.pojo.entity.Book;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * The interface Book mapper.
 *
 * @program: library
 * @className: BookMapper
 * @description: book mapper
 * @author: lov.moran
 * @date 2020 -05-28 00:58
 */
@Mapper
public interface BookMapper {

    /**
     * Gets all.
     *
     * @return the all
     */
    @Select("SELECT * FROM BOOK")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "SORT", property = "sort", jdbcType = JdbcType.INTEGER),
            @Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "AUTHOR", property = "author", jdbcType = JdbcType.VARCHAR),
            @Result(column = "STATUS", property = "status", jdbcType = JdbcType.INTEGER)
    })
    List<Book> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Select("SELECT * FROM BOOK WHERE ID = #{id}")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "SORT", property = "sort", jdbcType = JdbcType.INTEGER),
            @Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "AUTHOR", property = "author", jdbcType = JdbcType.VARCHAR),
            @Result(column = "STATUS", property = "status", jdbcType = JdbcType.INTEGER)
    })
    Book getById(long id);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Select("SELECT ID FROM BOOK WHERE NAME = #{name} AND SORT = #{sort} AND AUTHOR = #{author}")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "SORT", property = "sort", jdbcType = JdbcType.INTEGER),
            @Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "AUTHOR", property = "author", jdbcType = JdbcType.VARCHAR),
            @Result(column = "STATUS", property = "status", jdbcType = JdbcType.INTEGER)
    })
    Long getBookId(Book book);

    /**
     * Insert.
     *
     * @param book the book
     */
    @Insert("INSERT INTO BOOK(ID, SORT, NAME, AUTHOR, STATUS) VALUES(#{id}, #{sort}, #{name}, #{author}, #{status})")
    void insert(Book book);

    /**
     * Update.
     *
     * @param book the book
     */
    @Update("UPDATE BOOK SET SORT = #{sort} , NAME = #{name}, AUTHOR = #{author}, STATUS = #{status} WHERE ID = #{id}")
    void update(Book book);

    /**
     * Delete.
     *
     * @param Id the id
     */
    @Delete("DELETE FROM BOOK WHERE ID = #{id}")
    void delete(long Id);
}
