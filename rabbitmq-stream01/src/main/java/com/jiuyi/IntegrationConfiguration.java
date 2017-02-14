package com.jiuyi;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/14 17:51
 */
@Configuration
@EnableBinding(WorkUnitsSource.class)
@IntegrationComponentScan
public class IntegrationConfiguration {
}
