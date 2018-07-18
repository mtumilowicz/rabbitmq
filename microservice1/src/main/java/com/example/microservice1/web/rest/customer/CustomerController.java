package com.example.microservice1.web.rest.customer;

import com.example.microservice1.infrastructure.customer.rabbitmq.CustomerCreatePublisher;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {
    CustomerCreatePublisher sender;

    @GetMapping("send")
    public void send() {
        sender.publish();
    }
}
