package com.sagar.spring.jpa.h2.broker;

import com.sagar.spring.jpa.h2.model.Tutorial;
import com.sagar.spring.jpa.h2.model.TutorialDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Producer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${active-mq.topic}")
    private String topic;

    public void sendMessage(TutorialDTO message){
        try{
            log.info("Send message to Topic: "+ topic);
            log.info("Send message : "+ message);
            jmsTemplate.convertAndSend(topic, message);
        } catch(Exception e){
            log.error("Received Exception during send Message: ", e);
        }
    }
}
