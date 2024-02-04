package com.templates.valens.v1.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UNauthorizedException  extends RuntimeException{
    public UNauthorizedException(String message){
        super(message);
    }
}
