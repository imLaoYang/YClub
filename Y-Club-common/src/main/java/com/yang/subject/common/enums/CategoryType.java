package com.yang.subject.common.enums;


import lombok.Getter;

/**
 * 逻辑删标志
 */
@Getter
public enum CategoryType {

  PRIMARY(1,"岗位大类"),
  SECOND(2,"二级分类");

  private final Integer code;

  private final String desc;

  CategoryType(Integer code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
