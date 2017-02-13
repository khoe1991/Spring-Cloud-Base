package com.jiuyi;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/10 17:06
 */
@Component
@RestController
public class RabbitSender implements RabbitTemplate.ConfirmCallback{

    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入
     */
    @Autowired
    public void Send(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    public String sendMsg() {
        String content = "test -rabbitmq";
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(AmqpConfig.DIRECT_EXCHANGE, AmqpConfig.ROUTINGKEY, content, correlationId);
        return "send success!";
    }

    @RequestMapping("/send")
    public String send() {
        this.sendMsg();
        return "send success!";
    }

    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费!");
        } else {
            System.out.println("消息消费失败:" + cause);
        }
    }
}
