package com.food.listener;

import com.food.model.Order;
import com.food.model.Payment;
import com.food.producer.PaymentProcessedEventProducer;
import com.food.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreatedEventListener {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentProcessedEventProducer paymentProcessedEventProducer;

    @KafkaListener(topics = "order-created", groupId = "orders_group")
    public void consume(Order order){
        log.info(String.format("Message received -> %s", order));
        Payment payment = new Payment();
        payment.setAmount(order.getTotalOrderPrice());
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        paymentProcessedEventProducer.produce(payment);


        //,containerFactory = "orderKafkaListenerContainerFactory"
        }
}
