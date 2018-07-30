package com.example.microservice2.app.rabbit.customer;

import com.example.microservice2.infrastructure.rabbitmq.annotation.RabbitConsumer;
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate;
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerDelete;
import com.example.microservice2.infrastructure.rabbitmq.listener.handler.CustomerMessageHandler;
import com.example.microservice2.infrastructure.rabbitmq.queue.QueueNames;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RabbitConsumer
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
class CustomerListener {

    CustomerMessageHandler customerMessageHandler;
    
    @RabbitListener(queues = QueueNames.CUSTOMERS_CREATE)
    void onCreate(@NonNull CustomerCreate customerCreate) {
        customerMessageHandler.processCreate(customerCreate);
    }

    @RabbitListener(queues = QueueNames.CUSTOMERS_DELETE)
    void onDelete(@NonNull CustomerDelete customerDelete) {
        customerMessageHandler.processDelete(customerDelete);
    }
}
