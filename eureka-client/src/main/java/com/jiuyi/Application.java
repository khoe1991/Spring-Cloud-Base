package com.jiuyi;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/1/18 10:34
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController //标记为：restful
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/")
    public String home() {
        System.out.println("访问成功！");
        return "Hello world";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
