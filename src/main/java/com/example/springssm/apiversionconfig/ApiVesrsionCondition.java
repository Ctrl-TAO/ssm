package com.example.springssm.apiversionconfig;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: taoshengjie
 * @Date: 2019/11/7 18:18
 * @Description: 编写版本号使用规则
 */
public class ApiVesrsionCondition implements RequestCondition<ApiVesrsionCondition> {

    // 路径中版本的前缀， 这里用 /v[1-9]/的形式
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");

    private int apiVersion;

    public ApiVesrsionCondition(int apiVersion){
        this.apiVersion = apiVersion;
    }

    /**
     * 将不同的筛选条件合并
     *
     */
    @Override
    public ApiVesrsionCondition combine(ApiVesrsionCondition other) {
        return new ApiVesrsionCondition(other.getApiVersion());
    }

    /***
     * 根据request查找匹配到的筛选条件
     *
     */
    @Override
    public ApiVesrsionCondition getMatchingCondition(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        Matcher m = VERSION_PREFIX_PATTERN.matcher(request.getRequestURI());
        if(m.find()){
            Integer version = Integer.valueOf(m.group(1));
            // 如果请求的版本号大于配置版本号， 则返回当前最大版本
            if(version >= this.apiVersion) {
                return this;
            }
        }
        return null;

    }

    /***
     * 实现不同条件类的比较，从而实现优先级排序
     *
     */
    @Override
    public int compareTo(ApiVesrsionCondition other, HttpServletRequest request) {
        return other.getApiVersion() - this.apiVersion;
    }


    public int getApiVersion() {
        return apiVersion;
    }
}
