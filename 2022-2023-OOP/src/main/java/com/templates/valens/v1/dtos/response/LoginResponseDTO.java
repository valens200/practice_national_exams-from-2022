package com.templates.valens.v1.dtos.response;
import com.templates.valens.v1.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDTO {

    private String token;
    private User user;
}
