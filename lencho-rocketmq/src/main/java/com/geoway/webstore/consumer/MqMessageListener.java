package com.geoway.webstore.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/14 16:52
 * @Description:
 */
@Component
@RocketMQMessageListener(topic = "first-topic", consumerGroup = "my-consumer-group")
@Slf4j
public class MqMessageListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info(s);
    }
}
