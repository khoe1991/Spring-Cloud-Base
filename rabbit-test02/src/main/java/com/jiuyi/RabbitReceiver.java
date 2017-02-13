package com.jiuyi;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/10 17:10
 */
@EnableBinding(Barica.class)
public class RabbitReceiver {

    @StreamListener(Barica.INPUT_CHANNEL)
    public void receiver(Message<Object> message){
        Object obj = message.getPayload();
        System.out.println("接受对象:"+obj+"\n");
    }

}
