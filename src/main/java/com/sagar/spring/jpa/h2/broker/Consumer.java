package com.sagar.spring.jpa.h2.broker;

import com.sagar.spring.jpa.h2.model.Tutorial;
import com.sagar.spring.jpa.h2.model.TutorialDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class Consumer implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            TutorialDTO tutorialObj = (TutorialDTO)objectMessage.getObject();
            log.info("Received Message from Topic: "+ tutorialObj.toString());
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }

    }

}
