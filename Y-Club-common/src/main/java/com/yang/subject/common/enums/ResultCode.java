package com.yang.subject.common.enums;


import lombok.Getter;

@Getter
public enum ResultCode {

  SUCCESS(200,"成功"),
  FAIL(400,"失败");


  private final Integer code;

  private final String desc;

  ResultCode(Integer code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
