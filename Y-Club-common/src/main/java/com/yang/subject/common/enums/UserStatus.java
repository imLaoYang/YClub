package com.yang.subject.common.enums;

import lombok.Getter;

/**
 * 用户是否启用
 */
@Getter
public enum UserStatus {

  OPEN(1,"用户启用"),
  DISABLE(0,"用户禁用");

  private final Integer code;

  private final String desc;

  UserStatus(Integer code, String desc) {
    this.code = code;
    this.desc = desc;
  }

}
