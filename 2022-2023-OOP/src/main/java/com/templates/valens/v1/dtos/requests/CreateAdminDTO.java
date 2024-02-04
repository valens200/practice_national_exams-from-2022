package com.templates.valens.v1.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAdminDTO extends CreateUserDTO{
    private String adminKey;

}
