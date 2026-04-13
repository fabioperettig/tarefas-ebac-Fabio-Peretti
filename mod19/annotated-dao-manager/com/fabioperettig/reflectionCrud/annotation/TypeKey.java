package com.fabioperettig.reflectionCrud.annotation;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeKey {

    String value();

}
