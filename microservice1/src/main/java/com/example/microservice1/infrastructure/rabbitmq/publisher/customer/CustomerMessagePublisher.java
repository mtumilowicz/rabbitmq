package com.example.microservice1.infrastructure.rabbitmq.publisher.customer;

import com.example.microservice1.infrastructure.rabbitmq.annotation.RabbitPublisher;
import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerDeleteMessage;
import com.example.microservice1.infrastructure.rabbitmq.event.customer.CustomerSaveMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Created by mtumilowicz on 2018-07-20.
 */
@RabbitPublisher
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerMessagePublisher {
    CustomerSavePublisher savePublisher;
    CustomerDeletePublisher deletePublisher;
    
    public void publishSave(@NonNull CustomerSaveMessage message) {
        savePublisher.publish(message);
    }
    
    public void publishDelete(@NonNull CustomerDeleteMessage message) {
        deletePublisher.publish(message);
    }
}
