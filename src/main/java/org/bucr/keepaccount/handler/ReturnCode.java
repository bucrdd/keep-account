package org.bucr.keepaccount.handler;

public enum ReturnCode {

  SUCCESS(100, "success"),
  FORBIDDEN_ERROR(40300, "Access denied"),
  UNAUTHORIZED_ERROR(40100, "Unauthorized "),
  INNER_ERROR(500, "Application inner error");

  private final Integer code;

  private final String message;

  ReturnCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
