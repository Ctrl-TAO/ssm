package com.example.springssm.apiversionconfig;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @author: taoshengjie
 * @Date: 2019/11/7 18:16
 * @Description:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    /*
     * api version code
     */
    int value();
}