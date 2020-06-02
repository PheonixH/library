package com.example.demo.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: library
 * @className: ReaderToken
 * @description: need reader token
 * @author: lov.moran
 * @date 2020-06-02 15:18
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReaderToken {
    boolean required() default true;
}
