package com.jiuyi;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author kejiangtao@duanrong.com
 * @since 2017/2/13 11:32
 */
@Configuration
public class AmqpConfig {

    public static final String DIRECT_EXCHANGE   = "direct-exchange";

    public static final String FANOUT_EXCHANGE   = "fanout-exchange";

    public static final String ROUTINGKEY = "spring-boot-routingKey";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("172.16.20.250:5672");
        connectionFactory.setUsername("springcloud");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("springCloud");
        connectionFactory.setPublisherConfirms(true); //必须要设置
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }

}
