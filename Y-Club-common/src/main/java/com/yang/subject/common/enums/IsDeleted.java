package com.yang.subject.common.enums;


import lombok.Getter;

/**
 * 逻辑删标志
 */
@Getter
public enum IsDeleted {

  DELETED(1,"已经删除"),
  UN_DELETED(0,"未删除");


  private final Integer code;

  private final String desc;

  IsDeleted(Integer code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
