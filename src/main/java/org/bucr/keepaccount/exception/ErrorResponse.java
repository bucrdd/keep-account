package org.bucr.keepaccount.exception;

import org.bucr.keepaccount.handler.ReturnCode;

public class ErrorResponse {

  private Integer code;

  private String message;

  private Object trace;

  public ErrorResponse(BusinessException e) {
    this.code = e.getCode();
    this.message = e.getMessage();
    this.trace = e.getCause().getStackTrace();
  }

  public ErrorResponse(ReturnCode status, Exception e) {
    this.code = status.getCode();
    this.message = e.getMessage();
    this.trace = e.getStackTrace();
  }

}
