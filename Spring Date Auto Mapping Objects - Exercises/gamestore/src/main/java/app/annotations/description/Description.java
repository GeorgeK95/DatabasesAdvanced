package app.annotations.description;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@NotNull
@Component
@Constraint(validatedBy = DescriptionValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
    String message() default "Invalid description.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
