package com.example.microservice1.domain.customer.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@EqualsAndHashCode(of = "id")
public class Customer {
    @Id
    Integer id;
    String firstName;
    String lastName;
}
