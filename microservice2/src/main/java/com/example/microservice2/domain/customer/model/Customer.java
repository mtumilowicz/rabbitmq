package com.example.microservice2.domain.customer.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Entity
@Value
@Builder
public class Customer implements Serializable {
    @Id
    private Integer id;
    private String firstName;
}