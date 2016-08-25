package annotation.sample9;

@Metatype
public @interface MethodLevelAnnotation2 {
    @MethodLevelAnnotation(name = "KKK")
    String name() default "";
}
