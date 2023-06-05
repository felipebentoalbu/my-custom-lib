package br.com.customlib.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SecurityResource {

    String type() default SecurityResourceType.USER;

    String property() default SecurityResourceProperty.USER;

    String source() default SecurityResourceSource.ID;

}