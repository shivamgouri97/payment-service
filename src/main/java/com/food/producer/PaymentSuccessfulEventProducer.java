package com.food.producer;


import com.food.model.Order;
import com.food.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentSuccessfulEventProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void produce(Order order){
        kafkaTemplate.send(topicName, order);
        log.info(String.format("Message Pushed to payment-successful Queue -> %s", order));
    }
}
