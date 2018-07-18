package com.example.microservice1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RabbitHealthCheck {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void send() {
        assertThat(restTemplate
                        .getForEntity(createURLWithPort("send"), Void.class)
                        .getStatusCode(),
                is(HttpStatus.OK));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
