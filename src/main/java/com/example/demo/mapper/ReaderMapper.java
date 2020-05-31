package com.example.demo.mapper;

import com.example.demo.pojo.entity.Reader;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * The interface Reader mapper.
 *
 * @program: demo
 * @className: ReaderMapper
 * @description:reader mapper
 * @author: lov.moran
 * @date 2020 /5/28 下午9:18
 */
public interface ReaderMapper {

    /**
     * Gets all.
     *
     * @return the all
     */
    @Select("SELECT * FROM READER")
    List<Reader> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Select("SELECT * FROM READER WHERE ID = #{id}")
    Reader getById(long id);

    /**
     * Insert.
     *
     * @param reader the reader
     */
    @Insert("INSERT INTO READER(ID, NAME, GRADE, PASSWORD) VALUES(#{id}, #{name}, #{grade}, #{password})")
    void insert(Reader reader);

    /**
     * Update.
     *
     * @param reader the reader
     */
    @Update("UPDATE READER SET NAME = #{name}, GRADE = #{grade}, PASSWORD = #{password} WHERE ID = #{id}")
    void update(Reader reader);

    /**
     * Delete.
     *
     * @param id the id
     */
    @Delete("DELETE FROM READER WHERE ID = #{id}")
    void delete(long id);
}
