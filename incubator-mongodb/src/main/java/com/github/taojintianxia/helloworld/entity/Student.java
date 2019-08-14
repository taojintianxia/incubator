package com.github.taojintianxia.helloworld.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Nianjun Sun
 * @date 2019-08-13 16:16
 */
@Data
@Document(collection = "student")
public class Student {

    @Id
    private String id;

    private String name;

    private Integer age;

    private String gender;
}
