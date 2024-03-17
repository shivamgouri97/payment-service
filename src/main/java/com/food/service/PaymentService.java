package com.food.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {
//
//    @Autowired
//    private PaymentRepository orderRepository;

//    @Value("${topic.name.producer}")
//    private String topicName;
//
//    @Autowired
//    private  KafkaTemplate<String, String> kafkaTemplate;

//    public void createOrder(Order order) throws JsonProcessingException {
//        order.setStatus(Status.CREATED);
//        orderRepository.save(order);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String reqJson = mapper.writeValueAsString(order);
//        kafkaTemplate.send(topicName, reqJson);
//        log.info("pushed to kafka queue");
//    }
}
