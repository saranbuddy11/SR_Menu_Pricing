package base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static base.Environment.UNKNOWN;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TCNo {
    String numbers() default "";

    Environment environment() default UNKNOWN;
}