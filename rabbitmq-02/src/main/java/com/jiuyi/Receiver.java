package com.jiuyi;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/13 11:08
 */
@Component
public class Receiver {

    @RabbitListener(queues = "my-queue")
    public void receiveMsg(String msg) {
        System.out.println("Received msg : <" + msg + ">");
    }
}
