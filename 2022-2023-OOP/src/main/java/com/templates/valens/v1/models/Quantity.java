package com.templates.valens.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double quantity;

    private String operation;

    private Date date;

    @ManyToMany(mappedBy = "quantities", fetch = FetchType.LAZY)
    @JsonIgnore
    private  List<Cart> cats;


    public Quantity(Product product, double quantity, String operation, Date date) {
        this.product = product;
        this.quantity = quantity;
        this.operation = operation;
        this.date = date;
    }
}
