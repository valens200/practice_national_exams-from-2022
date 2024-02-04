package com.templates.valens.v1.dtos.requests;

import com.templates.valens.v1.models.enums.EProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDTO {

    private String code;
    private String name;
    private double price;
    private Date inDate;
    private String  image;
}
