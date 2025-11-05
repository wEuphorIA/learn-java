package com.itheima.consumer.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

/**
 * @author Mr.M
 * @version 1.0
 * @description TODO
 * @date 2024/10/12 9:30
 */
@Component
@Slf4j
public class SpringRabbitListener {

    //监听simple.queue队列的消息
   @RabbitListener(queues = "simple.queue")
   public void listenSimpleQueueMsg(String msg) {
       log.info("spring-boot-rabbitmq-simple-queue 收到消息：{}", msg);
       if (true){
           throw new RuntimeException("测试");
       }
   }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1接收到消息：【" + msg + "】" + LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2........接收到消息：【" + msg + "】" + LocalTime.now());
        Thread.sleep(200);
    }
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) {
        System.out.println("消费者1接收到Fanout消息：【" + msg + "】");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) {
        System.out.println("消费者2接收到Fanout消息：【" + msg + "】");
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void listenDirectQueue1(String msg) {
        System.out.println("消费者1接收到direct.queue1的消息：【" + msg + "】");
    }
//    @RabbitListener(queues = "direct.queue1")
//    public void listenDirectQueue1(String msg) {
//        System.out.println("消费者1接收到direct.queue1的消息：【" + msg + "】");
//    }

//    @RabbitListener(queues = "direct.queue2")
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirectQueue2(String msg) {
        System.out.println("消费者2接收到direct.queue2的消息：【" + msg + "】");
    }

    @RabbitListener(queues = "topic.queue1")
    public void listenTopicQueue1(String msg){
        System.out.println("消费者1接收到topic.queue1的消息：【" + msg + "】");
    }

    @RabbitListener(queues = "topic.queue2")
    public void listenTopicQueue2(String msg){
        System.out.println("消费者2接收到topic.queue2的消息：【" + msg + "】");
    }

    //监听object.queue
    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String,Object> msg) {
        System.out.println("object.queue 收到消息，msg：" + msg);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage2(String msg) throws InterruptedException {
        log.info("spring 消费者接收到消息：【" + msg + "】");
        if (true) {
            throw new RuntimeException("故意的");
        }
        log.info("消息处理完成");
    }
//    @RabbitListener(queues = "simple.queue")
//    public void listenSimpleQueueMessage2(String msg,Channel channel,Message message) throws InterruptedException {
//        log.info("spring 消费者接收到消息：【" + msg + "】");
//        String messageId = message.getMessageProperties().getMessageId();
//        log.info("消息id：{}", messageId);
//        if (true) {
//            throw new RuntimeException("故意的");
//        }
//        log.info("消息处理完成");
//    }

//    @RabbitListener(queues = "simple.queue")
//    public void listenSimpleQueueMessage(String msg, Channel channel, Message message) throws InterruptedException, IOException {
//        log.info("spring 消费者接收到消息：【" + msg + "】");
//        //返回nack
//        //每个参数的意义：1.消息的标记 2.是否确认之前所有未确认的消息 3.是否重新入队
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
////        log.info("消息处理完成");
////        //返回ack,每个参数的意义：1.消息的标记 2.是否确认之前所有消息
////        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//    }

    @RabbitListener(queues = "error.queue")
    public void listenErrorQueue(String msg) throws InterruptedException {
        System.out.println("接收失败消息：【" + msg + "】" + LocalTime.now());
        //存入数据库失败消息表...
    }
    @RabbitListener(queues = "delay.queue")
    public void listenDelayQueue(String msg) throws InterruptedException {
        System.out.println("接收延迟消息：【" + msg + "】" + LocalTime.now());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "delay.queue", durable = "true"),
            exchange = @Exchange(name = "delay.direct", delayed = "true",type = ExchangeTypes.DIRECT, durable = "true"),
            key = "delay"
    ))
    public void listenDelayMessage(String msg){
        System.out.println("接收延迟消息：【" + msg + "】" + LocalTime.now());
    }
}
