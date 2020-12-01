package com.hit.eryi.infrastructure.aspect;

import java.lang.annotation.*;

/**
 * @ClassName : WebLog
 * @Description:
 * @Date : 2018-07-12 13:39
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLog {
    String description()  default "";
}
