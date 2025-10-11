package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "my-new-group")
    public void listen1(String message){
        System.out.println("Received Message from listen1: " +message);
    }
    // this helps in loadBalancing since there are multiple consumer in same groupId
    // so any one of them will receive the message but if there are different groupId or group
    // listening to same topic then both the group will receive message like broadcasting.
    @KafkaListener(topics = "my-topic", groupId = "my-new-group")
    public void listen2(String message){
        System.out.println("Received Message from listen2: " +message);
    }

    @KafkaListener(topics = "my-topic", groupId = "my-new-group2")
    public void listen3(String message){
        System.out.println("Received Message from listen3: " +message);
    }
    @KafkaListener(topics="my-new-topic-3",groupId = "my-group-3")
    public void listen4(RiderLocation riderLocation){
        System.out.println("Received RiderLocation : "+  riderLocation.getRiderId()+ "  "+ riderLocation.getLatitude()+"  "+riderLocation.getLongitude());
    }

}
