package com.zti.avlplan.AVLSpreadSheet.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.CONFLICT,
        reason = "Timeline created by this user already exists in this spreadsheet"
)
public class DuplicateTimelinesException extends RuntimeException{
}
