package com.github.taojintianxia.helloworld;

import com.github.taojintianxia.helloworld.dao.StudentDAO;
import com.github.taojintianxia.helloworld.entity.Student;
import com.github.taojintianxia.util.HelloWorldUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Nianjun Sun
 * @date 2019-08-13 16:28
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMongodbApplication.class)
public class StudentDAOTest {

    @Autowired
    private StudentDAO studentDAO;

    @Test
    public void testSave() {
        Student student = HelloWorldUtil.generateStudent();
        studentDAO.insert(student);
        System.out.println(student.toString());
    }
}
