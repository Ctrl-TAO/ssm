package com.example.springssm.controller;

import com.example.springssm.apiversionconfig.ApiVersion;
import com.example.springssm.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: taoshengjie
 * @Date: 2019/11/7 16:46
 * @Description: 测试版本号
 */
@RestController
@Api("test")
@RequestMapping("{version}")
public class DemoController {

    @Autowired
    DemoService demoService;

    @ApiOperation(value = "测试post请求",notes="注意事项")
    @GetMapping(path = "/hello")
    @ApiVersion(3)
    public Object test(){
        return true;
    }

    @ApiOperation(value = "测试post请求",notes="注意事项")
    @GetMapping(path = "/hello")
    @ApiVersion(5)
    public Object test02(){
        return false;
    }
}
