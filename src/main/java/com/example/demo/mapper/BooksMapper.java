package com.example.demo.mapper;

import com.example.demo.pojo.entity.Book;
import com.example.demo.pojo.entity.Books;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * The interface Books mapper.
 *
 * @program: demo
 * @className: BooksMapper
 * @description:books mapper
 * @author: lov.moran
 * @date 2020 /5/28 下午8:48
 */
@Mapper
public interface BooksMapper {

    /**
     * Gets all.
     *
     * @return the all
     */
    @Select("SELECT * FROM BOOKS")
    @Results({
            @Result(column = "SORT", property = "sort", jdbcType = JdbcType.INTEGER),
            @Result(column = "NAME", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "AUTHOR", property = "author", jdbcType = JdbcType.VARCHAR),
            @Result(column = "SUM", property = "sum", jdbcType = JdbcType.INTEGER),
            @Result(column = "EXISTS", property = "exists", jdbcType = JdbcType.INTEGER)
    })
    List<Books> getAll();


    /**
     * Get one books which is selected by id.
     *
     * @param sort the sort
     * @return the books selected by id
     */
    @Select("SELECT * FROM BOOKS WHERE SORT = #{sort}")
    Books getBySort(String sort);

    /**
     * Insert.
     *
     * @param books the books
     */
    @Insert("INSERT INTO BOOKS(SORT, NAME, AUTHOR, SUM, EXISTS) " +
            "VALUES (#{sort}, #{name}, #{author}, #{status}, #{exists})")
    void insert(Books books);

    /**
     * Update.
     *
     * @param books the books
     */
    @Update("UPDATE BOOKS SET NAME = #{name}, AUTHOR = #{author}, STATUS = #{status} WHERE SORT = #{sort}")
    void update(Books books);

    /**
     * Delete.
     *
     * @param Id the id
     */
    @Delete("DELETE FROM BOOKS WHERE SORT = #{sort}")
    void delete(long Id);
}
