package org.bucr.keepaccount.handler;

public enum ReturnCode {

  SUCCESS(100, "success"),
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
