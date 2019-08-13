package com.github.taojintianxia.helloworld.dao;

import com.github.taojintianxia.helloworld.entity.Student;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2019-08-13 16:20
 */
public interface StudentDAO {

    /**
     * save record
     *
     * @param student
     */
    void insert(Student student);

    /**
     * update record
     *
     * @param student
     */
    void update(Student student);

    /**
     * delete record by id
     *
     * @param id
     */
    void delete(String id);

    /**
     * list all records witch have the same name
     *
     * @param name
     * @return
     */
    List<Student> listByName(String name);

    /**
     * get record by id
     *
     * @param id
     * @return
     */
    Student getById(String id);
}
