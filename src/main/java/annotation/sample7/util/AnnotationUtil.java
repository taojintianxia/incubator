package annotation.sample7.util;

import java.util.ArrayList;
import java.util.List;

import annotation.sample7.normalannotation.CustomAnnotationA;
import annotation.sample7.normalannotation.CustomAnnotationB;
import annotation.sample7.springannotation.CustomSpringAnnotationA;
import annotation.sample7.springannotation.CustomSpringAnnotationB;

public class AnnotationUtil {

    @SuppressWarnings("rawtypes")
    public static List<Class> getAnnotations() {
        List<Class> annotations = new ArrayList<>();
        annotations.add(CustomAnnotationA.class);
        annotations.add(CustomAnnotationB.class);
        annotations.add(CustomSpringAnnotationA.class);
        annotations.add(CustomSpringAnnotationB.class);

        return annotations;
    }

}
