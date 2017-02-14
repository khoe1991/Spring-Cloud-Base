package com.jiuyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/14 18:50
 */
@Component
@RestController
public class RabbitmqSender {

    @Autowired
    private WorkUnitsSource workUnitsSource;

    @RequestMapping("/send")
    @ResponseBody
    public String send () {

        String msg = "test -- rabbitmq -- stream";
        boolean send = workUnitsSource.worksChannel().send(MessageBuilder.withPayload(msg).build());
        if (send) {
            System.out.println("send success!");
            return "send success!";
        }

        return "-1";
    }
}
