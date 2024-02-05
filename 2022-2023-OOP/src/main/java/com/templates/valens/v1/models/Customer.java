package com.templates.valens.v1.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Customer extends  Member{

    @OneToOne
    @JoinColumn(name = "cat_id")
    private Cart cat;
}
