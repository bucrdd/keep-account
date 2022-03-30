package org.bucr.keepaccount.handler;

import lombok.Data;

@Data
public class ResponseData<T> {

  private Integer code;

  private String message;

  private T data;

  private long timestamp;

  public ResponseData() {
    this.timestamp = System.currentTimeMillis();
  }

  public ResponseData(T data, Integer code, String message) {
    this.code = code;
    this.message = message;
    this.data = data;
    this.timestamp = System.currentTimeMillis();
  }

  public static<T> ResponseData<T> success(T data) {
    ResponseData<T> response = new ResponseData<>();
    response.setCode(ReturnCode.SUCCESS.getCode());
    response.setMessage(ReturnCode.SUCCESS.getMessage());
    response.setData(data);
    return response;
  }

}
