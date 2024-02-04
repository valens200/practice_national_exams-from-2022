package com.templates.valens.v1.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {

    private String userName;
    private String email;
    private String password;
    private String adminKey;
}
