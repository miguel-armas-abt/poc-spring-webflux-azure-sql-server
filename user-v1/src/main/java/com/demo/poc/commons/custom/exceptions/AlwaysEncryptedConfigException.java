package com.demo.poc.commons.custom.exceptions;

import com.demo.poc.commons.core.errors.exceptions.GenericException;
import lombok.Getter;

@Getter
public class AlwaysEncryptedConfigException extends GenericException {

  public AlwaysEncryptedConfigException() {
    super(ErrorDictionary.ERROR_CONFIGURING_ALWAYS_ENCRYPTED.getMessage(), ErrorDictionary.parse(AlwaysEncryptedConfigException.class));
  }
}
