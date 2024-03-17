package com.food.producer;


import com.food.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentProcessedEventProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    public void produce(Payment payment){
        kafkaTemplate.send(topicName, payment);
        log.info(String.format("Message Pushed to Queue -> %s", payment));
    }
}
