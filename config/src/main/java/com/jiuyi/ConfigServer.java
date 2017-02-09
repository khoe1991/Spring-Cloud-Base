package com.jiuyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer //开启配置中心注解
@EnableDiscoveryClient //向eureka注册
@SpringBootApplication
public class ConfigServer {
    public static void main( String[] args ) {
        SpringApplication.run(ConfigServer.class, args);
    }
}
