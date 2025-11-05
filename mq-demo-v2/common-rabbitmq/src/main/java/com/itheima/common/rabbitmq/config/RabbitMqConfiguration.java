package com.itheima.common.rabbitmq.config;

import com.itheima.common.rabbitmq.client.RabbitClient;
import com.itheima.common.rabbitmq.dao.FailMsgDao;
import com.itheima.common.rabbitmq.dao.impl.FailMsgDaoImpl;
import com.itheima.common.rabbitmq.properties.RabbitmqProperties;
import com.itheima.common.rabbitmq.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;
import org.springframework.util.NumberUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.nio.charset.Charset;

/**
 @author itcast */
@Configuration
@ConditionalOnProperty(prefix = "rabbit-mq", name = "enable", havingValue = "true")
@Import({RabbitClient.class, FailMsgDaoImpl.class})
@Slf4j
public class RabbitMqConfiguration implements ApplicationContextAware {

    /**
     并发数量
     */
    public static final int DEFAULT_CONCURRENT = 10;

    @Autowired(required = false)
    private FailMsgDao failMsgDao;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // // 获取RabbitTemplate
        RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);
        //定义returnCallback回调方法
        rabbitTemplate.setReturnsCallback(
                new RabbitTemplate.ReturnsCallback() {
                    @Override
                    public void returnedMessage(ReturnedMessage returnedMessage) {
                        byte[] body = returnedMessage.getMessage().getBody();
                        //消息id
                        String messageId = returnedMessage.getMessage().getMessageProperties().getMessageId();
                        String content = new String(body, Charset.defaultCharset());
                        log.info("消息发送失败，应答码{}，原因{}，交换机{}，路由键{},消息id{},消息内容{}",
                                returnedMessage.getReplyCode(),
                                returnedMessage.getReplyText(),
                                returnedMessage.getExchange(),
                                returnedMessage.getRoutingKey(),
                                messageId,
                                content);
                        if (failMsgDao != null) {
                            failMsgDao.save(messageId, returnedMessage.getExchange(), returnedMessage.getRoutingKey(), content, 0, DateUtils.getCurrentTime() + 10, "returnCallback");
                        }
                    }
                }
        );
    }
}
