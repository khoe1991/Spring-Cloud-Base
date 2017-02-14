package com.jiuyi;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/14 17:52
 */
public interface WorkUnitsSource {

    String CHANNEL_NAME = "worksChannel";

    @Output
    MessageChannel worksChannel();
}
