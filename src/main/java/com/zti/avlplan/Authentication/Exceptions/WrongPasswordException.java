package com.zti.avlplan.Authentication.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.UNAUTHORIZED,
        reason = "Wrong password"
)

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException() {
        super();
    }
}
