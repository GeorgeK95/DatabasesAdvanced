package app.annotations.password;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by George-Lenovo on 7/26/2017.
 */
@NotNull
@Component
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Invalid password.";

    int minLength() default 6;

    int maxLength() default 50;

    boolean containLowerCaseLetter() default true;

    boolean containUpperCaseLetter() default true;

    boolean containDigit() default true;

    boolean containSymbol() default true;

    boolean nullAble() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
