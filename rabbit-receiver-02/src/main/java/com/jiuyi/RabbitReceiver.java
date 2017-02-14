package com.jiuyi;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/10 17:10
 */
@Component
public class RabbitReceiver {

    @RabbitListener(queues = "rabbitmq.topic.receiver02")
    public void receiveMsg(String msg) {
        System.out.println("receiver02-----Received <"+ msg +">");
    }

}
