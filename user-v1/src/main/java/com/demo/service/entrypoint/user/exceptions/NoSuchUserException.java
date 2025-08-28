package com.demo.service.entrypoint.user.exceptions;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.demo.commons.errors.exceptions.GenericException;

public class NoSuchUserException extends GenericException {

  public static final String INVALID_FIELD_CODE = "01.02.02";

  public NoSuchUserException(long userId) {
    super(
        INVALID_FIELD_CODE,
        "No such user: " + userId,
        NOT_FOUND
    );
  }
}
