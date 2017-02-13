package com.jiuyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/10 17:06
 */
@Service
@Component
public class RabbitSender {

    @Autowired
    private Barica source;

    // 发送消息
    public String sendMessage(){
        try{
            Object obj = new Object();
            source.logOutPut().send(MessageBuilder.withPayload(obj).build());
            System.out.println("发送");

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
