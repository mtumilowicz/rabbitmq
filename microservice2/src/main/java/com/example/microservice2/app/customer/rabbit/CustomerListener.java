package com.example.microservice2.app.customer.rabbit;

import com.example.microservice2.app.customer.rabbit.CustomerMessageHandler;
import com.example.microservice2.domain.customer.model.validator.CustomerDeleteMessageValidator;
import com.example.microservice2.domain.customer.model.validator.CustomerSaveMessageValidator;
import com.example.microservice2.infrastructure.rabbitmq.annotation.RabbitConsumer;
import com.example.microservice2.app.customer.rabbit.message.CustomerDeleteMessage;
import com.example.microservice2.app.customer.rabbit.message.CustomerSaveMessage;
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

    CustomerMessageHandler customerMessageHandler;

    @RabbitListener(queues = QueueNames.CUSTOMERS_CREATE)
    public void onSave(@NonNull CustomerSaveMessage message) {
        CustomerSaveMessageValidator.validate(message);
        customerMessageHandler.processSave(message);
    }

    @RabbitListener(queues = QueueNames.CUSTOMERS_DELETE)
    public void onDelete(@NonNull CustomerDeleteMessage message) {
        CustomerDeleteMessageValidator.validate(message);
        customerMessageHandler.processDelete(message);
    }
}
