package com.zti.avlplan.Authentication.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.CONFLICT,
        reason = "User with that username already exists in database"
)
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException() {
        super();
    }
}
