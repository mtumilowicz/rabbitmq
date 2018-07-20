package com.example.microservice1.infrastructure.rabbitmq.publisher;

import com.example.microservice1.infrastructure.rabbitmq.annotation.RabbitPublisher;
import com.example.microservice1.infrastructure.rabbitmq.event.CustomerCreate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Created by mtumilowicz on 2018-07-20.
 */
@RabbitPublisher
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerPublisher {
    CustomerCreatePublisher createPublisher;
    
    public void publishCreate(CustomerCreate customerCreate) {
        createPublisher.publish(customerCreate);
    }
}
