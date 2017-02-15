package com.jiuyi;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/14 19:03
 */
@Component
public class RabbitmqReceiver {

    @StreamListener(WorkUnitsSink.CHANNEL_NAME)
    public void receiver (Message<Object> message) {

        Object payload = message.getPayload();
        MessageHeaders headers = message.getHeaders();

        System.out.println(payload);
        System.out.println(headers);

    }
}
