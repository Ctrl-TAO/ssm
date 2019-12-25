package com.example.springssm.apiversionconfig;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author: taoshengjie
 * @Date: 2019/11/11 16:26
 * @Description: 将自己写的RequestMappingHandlerMapping覆盖springboot自带的RequestMappingHandlerMapping
 */
@SpringBootConfiguration
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new CustomRequestMappingHandlerMapping();
    }
}
