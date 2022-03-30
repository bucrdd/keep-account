package org.bucr.keepaccount.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseData<String> exception(Exception e) {
    ResponseData<String> response = new ResponseData<>();
    response.setMessage(e.getMessage());
    response.setCode(ReturnCode.INNER_ERROR.getCode());
    log.error(e.getMessage());
    return response;
  }

}
