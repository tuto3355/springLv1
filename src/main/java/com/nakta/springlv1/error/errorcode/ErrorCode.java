package com.nakta.springlv1.error.errorcode;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String name();

    HttpStatus getHttpStatus();

    String getMessage();
}
