package com.github.taojintianxia.helloworld.dao.impl;

import com.github.taojintianxia.helloworld.dao.StudentDAO;
import com.github.taojintianxia.helloworld.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2019-08-13 16:24
 */
@Component
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Student student) {
        mongoTemplate.insert(student);
    }

    @Override
    public void update(Student student) {
        Query query = new Query(Criteria.where("id").is(student.getId()));
        Update update = new Update();
        update.set("name", student.getName());
        update.set("age", student.getAge());
        update.set("gender", student.getGender());
        mongoTemplate.updateFirst(query, update, Student.class);
    }

    @Override
    public void delete(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Student.class);
    }

    @Override
    public List<Student> listByName(String name) {
        return null;
    }

    @Override
    public Student getById(String id) {
        return null;
    }
}
