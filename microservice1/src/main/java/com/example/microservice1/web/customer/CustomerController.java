package com.example.microservice1.web.customer;

import com.example.microservice1.infrastructure.customer.rabbitmq.CustomerCreatePublisher;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerCreatePublisher sender;

    @GetMapping("send")
    public void send() {
        sender.publish();
    }
}
