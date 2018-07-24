package com.example.microservice2.infrastructure.rabbitmq.queue.binder;

import com.example.microservice2.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import com.example.microservice2.infrastructure.rabbitmq.queue.qualifier.CustomersCreateQueue;
import com.example.microservice2.infrastructure.rabbitmq.queue.qualifier.CustomersDeleteQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.stereotype.Component;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Configuration
@EnableRabbit
@Component
public class QueueBinder implements RabbitListenerConfigurer {
    
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
    }

    @Bean
    public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(new MappingJackson2MessageConverter());
        return factory;
    }

    @Bean
    public Binding customersCreateQueueBinding(@CustomersCreateQueue Queue queue, 
                                               @CustomersExchange Exchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("customers.create")
                .noargs();
    }

    @Bean
    public Binding customersDeleteQueueBinding(@CustomersDeleteQueue Queue queue,
                                               @CustomersExchange Exchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("customers.delete")
                .noargs();
    }

}
