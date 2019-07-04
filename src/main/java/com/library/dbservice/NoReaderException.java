package com.library.dbservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "reason not found")
public class NoReaderException extends RuntimeException {
}
