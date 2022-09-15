package com.zti.avlplan.Authentication.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.UNAUTHORIZED,
        reason = "Wrong credentials"
)
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super();
    }
}
