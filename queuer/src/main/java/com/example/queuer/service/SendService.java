package com.example.queuer.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class SendService {

    @Autowired
    ResourceLoader resourceLoader;
    private final JmsTemplate jmsTemplate;

    public SendService(JmsTemplate jmsTemplate) {
        jmsTemplate.setDefaultDestination(new ActiveMQQueue("learning_queue"));
        this.jmsTemplate = jmsTemplate;
    }

    public void send() throws IOException {
        Path fileName = Path.of("src/main/resources/order.json");
        jmsTemplate.convertAndSend(Files.readString(fileName));
    }

}
