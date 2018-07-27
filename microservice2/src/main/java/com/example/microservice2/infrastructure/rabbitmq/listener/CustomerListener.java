package com.example.microservice2.infrastructure.rabbitmq.listener;

import com.example.microservice2.infrastructure.rabbitmq.annotation.RabbitConsumer;
import com.example.microservice2.infrastructure.rabbitmq.listener.handler.CustomerCreateMessageHandler;
import com.example.microservice2.infrastructure.rabbitmq.listener.handler.CustomerDeleteMessageHandler;
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate;
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerDelete;
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
public class CustomerListener {

    CustomerCreateMessageHandler customerCreateMessageHandler;
    CustomerDeleteMessageHandler customerDeleteMessageHandler;
    
    @RabbitListener(queues = QueueNames.CUSTOMERS_CREATE)
    public void onCreate(@NonNull CustomerCreate customerCreate) {
        customerCreateMessageHandler.process(customerCreate);
    }

    @RabbitListener(queues = QueueNames.CUSTOMERS_DELETE)
    public void onDelete(@NonNull CustomerDelete customerDelete) {
        customerDeleteMessageHandler.process(customerDelete);
    }
}
