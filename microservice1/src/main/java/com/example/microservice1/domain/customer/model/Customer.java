package com.example.microservice1.domain.customer.model;

import lombok.Builder;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;
    String firstName;
}
