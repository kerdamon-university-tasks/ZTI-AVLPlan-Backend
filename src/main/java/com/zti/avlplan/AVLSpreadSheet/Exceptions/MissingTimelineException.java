package com.zti.avlplan.AVLSpreadSheet.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Timeline is not present in this spreadsheet"
)
public class MissingTimelineException extends RuntimeException {
    public MissingTimelineException() {
        super();
    }
}
