package com.example.demo.util;

import java.lang.annotation.*;

/**
 * @program: library
 * @className: ControllerMonitor
 * @description: controller log & monitor
 * @author: lov.moran
 * @date 2020-06-03 16:50
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerMonitor {
    String description() default "";
}
