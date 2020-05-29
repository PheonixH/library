package com.example.demo.mapper;

import com.example.demo.domain.Grade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * The interface Grade mapper.
 *
 * @program: demo
 * @className: GradeMapper
 * @description:Grade mapper
 * @author: lov.moran
 * @date 2020 /5/28 下午8:57
 */
public interface GradeMapper {

    /**
     * Gets all.
     *
     * @return the all
     */
    @Select("SELECT * FROM GRADE")
    List<Grade> getAll();

    /**
     * Gets all.
     *
     * @param id the id
     * @return the all
     */
    @Select("SELECT * FROM GRADE WHERE ID = #{id}")
    Grade getById(long id);

    /**
     * Insert.
     *
     * @param grade the grade
     */
    @Insert("INSERT INTO GRADE(ID, MAX,) VALUES(#{id}, #{max})")
    void insert(Grade grade);

    /**
     * Update.
     *
     * @param grade the grade
     */
    @Update("UPDATE GRADE SET MAX = #{max} WHERE ID = #{id}")
    void update(Grade grade);

    /**
     * Delete.
     *
     * @param Id the id
     */
    @Delete("DELETE FROM GRADE WHERE ID = #{id}")
    void delete(long Id);
}
