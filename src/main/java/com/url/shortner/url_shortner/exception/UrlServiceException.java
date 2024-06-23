package com.url.shortner.url_shortner.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UrlServiceException extends RuntimeException {
  public UrlServiceException(String message) {
    super(message);
  }
}
