package com.yang.subject.common.entity;


import com.yang.subject.common.enums.ResultCode;
import lombok.Data;

@Data
public class Result<T> {

  private Integer code;

  private String message;

  private Boolean success;

  private T data;


  public static Result<Boolean> ok() {

    Result<Boolean> result = new Result<>();
    result.setSuccess(true);
    result.setCode(ResultCode.SUCCESS.getCode());
    result.setMessage("成功");
    result.setData(true);
    return result;
  }


  public static <T> Result<T> ok(T data) {

    Result<T> result = new Result<>();
    result.setSuccess(true);
    result.setCode(ResultCode.SUCCESS.getCode());
    result.setMessage(ResultCode.SUCCESS.getDesc());
    result.setData(data);
    return result;
  }


  public static Result<Boolean> fail() {

    Result<Boolean> result = new Result<>();
    result.setSuccess(false);
    result.setCode(ResultCode.FAIL.getCode());
    result.setMessage(ResultCode.FAIL.getDesc());
    result.setData(true);
    return result;
  }


  public static <T> Result<T> fail(T data) {
    Result<T> result = new Result<>();
    result.setSuccess(false);
    result.setCode(ResultCode.FAIL.getCode());
    result.setMessage("失败");
    result.setData(data);
    return result;
  }

  public static <T> Result<T> fail(Integer code, T data) {
    Result<T> result = new Result<>();
    result.setSuccess(false);
    result.setCode(code);
    result.setMessage("失败");
    result.setData(data);
    return result;
  }


}
