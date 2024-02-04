package com.templates.valens.v1.models;

import com.templates.valens.v1.models.enums.EProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String code;
    private String name;

    private EProductType type;

    private double price;
    private Date inDate;
    private String  image;

}
