package com.github.taojintianxia.util;

import com.github.taojintianxia.helloworld.entity.Student;
import org.apache.commons.text.RandomStringGenerator;

import java.security.SecureRandom;

/**
 * @author Nianjun Sun
 * @date 2019-08-13 16:50
 */
public class HelloWorldUtil {

    public static Student generateStudent() {
        Student student = new Student();
        student.setName(new RandomStringGenerator.Builder().withinRange('a', 'z').build().generate(8));
        student.setAge(Math.abs(new SecureRandom().nextInt(60) + 10));
        student.setGender(new SecureRandom().nextBoolean() == true ? "F" : "M");

        return student;
    }
}
