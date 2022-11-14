package com.aninfo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CbuNotFoundException extends RuntimeException {

    public CbuNotFoundException(String message) {
        super(message);
    }
}
