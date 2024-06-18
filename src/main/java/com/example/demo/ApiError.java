package com.example.demo;

public class ApiError {

  private int errorCode;
  private String message;

  public int getErrorCode() {
    return errorCode;
  }

  public ApiError(int errorCode, String message) {
    this.errorCode = errorCode;
    this.message = message;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
