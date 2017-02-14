package com.jiuyi;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.RoutingConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
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

    public static final String DIRECT_EXCHANGE   = "direct.exchange";
    public static final String FANOUT_EXCHANGE   = "fanout.exchange";
    public static final String TOPIC_EXCHANGE   = "topic.exchange";
    public static final String ROUTING_KEY = "spring-boot-routingKey";

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
        return new RabbitTemplate(connectionFactory());
    }

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     *
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */

    /**
     * direct-exchange
     */
/*    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }
    @Bean
    public Queue queue() {
        return new Queue("direct-exchange-queue", true); //队列持久
    }
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(AmqpConfig.ROUTINGKEY);
    }*/

    /**
     * fanout-exchange
     */
/*    @Bean
    public FanoutExchange fanoutExchange () {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }
    @Bean
    public Queue queue() {
        return new Queue("rabbitmq.receiver01", true); //队列持久
    }
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(fanoutExchange());
    }*/

    /**
     * topic-exchange
     */
    @Bean
    public TopicExchange topicExchange () {
        return new TopicExchange(TOPIC_EXCHANGE);
    }
    @Bean
    public Queue queue () {
        return new Queue("rabbitmq.topic.receiver01");
    }
    @Bean
    public Binding binding () {
        return BindingBuilder.bind(queue()).to(topicExchange()).with("rabbitmq.topic.#");
    }

/*    @Bean
    public SimpleMessageListenerContainer messageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {

            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                System.out.println("rabbitmq-01 *******  receive msg : " + new String(body));
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
            }
        });
        return container;
    }*/

}
