package com.demo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final KafkaTemplate<String,RiderLocation>kafkaTemplate2;
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, RiderLocation> kafkaTemplate2) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplate2 = kafkaTemplate2;
    }


    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send("my-topic",message);
        return "Message sent: "+message;
    }

    @PostMapping("/location")
    public String sendLocation(@RequestBody RiderLocation riderLocation){
        kafkaTemplate2.send("my-new-topic-3",riderLocation);
        return "Rider Location send : "+riderLocation.getRiderId()+ "  "+ riderLocation.getLatitude()+"  "+riderLocation.getLongitude();
    }

}
