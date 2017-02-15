package com.jiuyi;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/14 17:56
 */
@Configuration
@EnableBinding(WorkUnitsSink.class)
public class IntegrationConfiguration {
}
