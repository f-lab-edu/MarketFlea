package com.flab.marketflea.annotation;

import com.flab.marketflea.model.user.Role;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginValidation {
    Role role() default Role.CUSTOMER;
}
