package com.demo.poc.commons.custom.exceptions;

import com.demo.poc.commons.core.constants.Symbol;
import com.demo.poc.commons.core.errors.exceptions.GenericException;
import lombok.Getter;

@Getter
public class NoSuchUserException extends GenericException {

  public NoSuchUserException(long userId) {
    super(ErrorDictionary.NO_SUCH_USER.getMessage() + Symbol.COLON_WITH_SPACE + userId, ErrorDictionary.parse(NoSuchUserException.class));
  }
}
