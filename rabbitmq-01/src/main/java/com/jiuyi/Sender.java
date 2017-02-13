package com.jiuyi;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/13 10:47
 */
@SpringBootApplication
@RestController
public class Sender implements CommandLineRunner {


    @Autowired
    private RabbitTemplate rabbitmqTemplate;

    @Bean
    public Queue myQueue(){
        return new Queue("my-queue");
    }

    @RequestMapping("/send")
    public String send () {
        rabbitmqTemplate.convertAndSend("my-queue", "send-rabbitmq!");
        System.out.println("send success!");
        return "send success!";
    }

    @Override
    public void run(String... args) throws Exception {
        rabbitmqTemplate.convertAndSend("my-queue", "测试-rabbitmq!");
    }
}
