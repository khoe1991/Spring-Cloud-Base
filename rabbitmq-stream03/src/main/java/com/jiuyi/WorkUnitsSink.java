package com.jiuyi;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/14 17:55
 */
public interface WorkUnitsSink {

    String CHANNEL_NAME = "worksChannel";

    @Input
    SubscribableChannel worksChannel();
}
