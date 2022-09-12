package com.zti.avlplan.AVLItem.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Requested timeline does not exist"
)
public class TimelineNotFoundException extends RuntimeException {
    public TimelineNotFoundException() {
        super();
    }
}
