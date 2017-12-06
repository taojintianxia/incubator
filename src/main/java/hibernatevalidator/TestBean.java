package hibernatevalidator;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class TestBean {

    @NotEmpty(message = "empty name is not allowed")
    private String name;

    @Max(99)
    private int age;

    private byte gender;

}
