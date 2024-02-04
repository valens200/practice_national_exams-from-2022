package com.templates.valens.v1.dtos.requests;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuantityDTO {

    private double quantity;

    private String operation;

    private Date date;

    private UUID productId;



}
