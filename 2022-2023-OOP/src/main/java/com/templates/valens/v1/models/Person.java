package com.templates.valens.v1.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class Person {

    private String firstName;
    private String lastName;
    private String phone;
}
