package com.url.shortner.url_shortner.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
  String message;
}
