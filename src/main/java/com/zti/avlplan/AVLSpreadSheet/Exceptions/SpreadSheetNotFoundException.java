package com.zti.avlplan.AVLSpreadSheet.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Requested spreadsheet does not exist"
)

public class SpreadSheetNotFoundException extends RuntimeException {
    public SpreadSheetNotFoundException() {
        super();
    }
}
