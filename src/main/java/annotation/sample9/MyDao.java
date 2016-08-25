package annotation.sample9;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
@MethodLevelAnnotation
public @interface MyDao {
}
