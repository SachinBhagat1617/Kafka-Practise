package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "my-new-group")
    public void listen(String message){
        System.out.println("Received Message: " +message);
    }

}
