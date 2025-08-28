package com.demo.service.commons.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import com.demo.commons.errors.exceptions.GenericException;

public class AlwaysEncryptedConfigException extends GenericException {

  public static final String INVALID_FIELD_CODE = "01.02.03";

  public AlwaysEncryptedConfigException() {
    super(
        INVALID_FIELD_CODE,
        "Error on always encrypted configuration",
        INTERNAL_SERVER_ERROR
    );
  }
}
