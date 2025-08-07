package com.sbkp.service;

import com.sbkp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Value("${topic.name}")
    String topicName;

    @Autowired
    KafkaTemplate<String, Customer> kafkaTemplate;

    public String addCustomer(Customer customer){
        kafkaTemplate.send(topicName, "spring",customer);
        return "Customer added to kafka topic successfully";
    }
}
