package com.example.demo.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: library
 * @className: PassToken
 * @description: do not need token
 * @author: lov.moran
 * @date 2020-06-02 15:17
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectToken {
    boolean required() default true;
}
