package com.food.listener;

import com.food.enums.Status;
import com.food.model.Order;
import com.food.model.Payment;
import com.food.producer.PaymentSuccessfulEventProducer;
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
    PaymentSuccessfulEventProducer paymentSuccessfulEventProducer;

    @KafkaListener(topics = "order-created", groupId = "orders_1")
    public void consume(Order order){
        log.info(String.format("Message received  from order-> %s", order));
        Payment payment = new Payment();
        payment.setAmount(order.getTotalOrderPrice());
        payment.setOrderId(order.getId());
        payment.setStatus(Status.SUCCESSFUL);
        paymentRepository.save(payment);
        //make payment through payment gateway, currently make it Successful

        payment.setStatus(Status.SUCCESSFUL);
        paymentRepository.save(payment);

        paymentSuccessfulEventProducer.produce(order);


        }
}
