package com.jiuyi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，
 *  等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
   */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }
}
