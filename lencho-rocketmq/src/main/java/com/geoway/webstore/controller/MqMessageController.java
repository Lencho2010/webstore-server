package com.geoway.webstore.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/14 16:47
 * @Description:
 */
@RestController
@RequestMapping("/mq")
@Slf4j
public class MqMessageController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @PutMapping("/pushMessage")
    public String get(@RequestParam("msg") String msg) {
        rocketMQTemplate.convertAndSend("first-topic", "你好,Java旅途:" + msg);
        return "发送消息成功";
    }
}
