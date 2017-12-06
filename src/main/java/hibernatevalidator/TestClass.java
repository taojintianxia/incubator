package hibernatevalidator;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class TestClass {

    public static void main(String... args) {
        TestBean testBean = new TestBean();
        printTestBean(testBean);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<TestBean>> constraintViolations = validator.validate(testBean);
        System.out.println("constraintViolations size is " + constraintViolations.size());
        Iterator<ConstraintViolation<TestBean>> iterator = constraintViolations.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getMessage());
        }
    }

    public static void printTestBean(TestBean testBean) {
        System.out.println(testBean);
    }

}
