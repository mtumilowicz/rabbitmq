package com.example.microservice1.app.customer.rabbit.publisher;

import com.example.microservice1.infrastructure.rabbitmq.annotation.RabbitPublisher;
import com.example.microservice1.app.customer.rabbit.message.CustomerDeleteMessage;
import com.example.microservice1.app.customer.rabbit.message.CustomerSaveMessage;
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
