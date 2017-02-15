package com.jiuyi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/8 20:32
 */

@EnableDiscoveryClient //用来发现config-server服务
@RefreshScope //配置refresh刷新的关键注解
@EnableEurekaClient
@SpringBootApplication
@RestController
public class ComputeService {

    @Value("${cm.user}")
    private String user;

    @RequestMapping("/hello")
    public String hello () {
        String hello = "compute-service01 " + user + "!!";
        System.out.println(hello);
        return hello;
    }

    public static void main( String[] args ) {
        SpringApplication.run(ComputeService.class, args);
    }
}

/*
 * post刷新配置文件要点：
 *      1 客户端上添加@RefreshScope注解
 *      2 更改远程gitHub上的配置文件，此时config配置中心的配置文件已经实时改变，但是客户端上配置文件还没有改变，是取得内存中的配置文件
 *      3 post一下客户端的接口http://localhost:8001/refresh即可（需依赖actuator，里面有/refresh的API接口）
 *      4 刷新客户端接口，即可看到该配置已更新
 */
