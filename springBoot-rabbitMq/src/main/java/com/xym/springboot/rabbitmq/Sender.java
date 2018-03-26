package com.xym.springboot.rabbitmq;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xym
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String content = "Hello " + new Date();
        System.out.println("Sender : " + content);
        this.amqpTemplate.convertAndSend("", content);
    }

}
