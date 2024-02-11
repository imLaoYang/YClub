package com.yang.subject.common.enums;

import lombok.Getter;


/**
 * 题目类型 1单选 2多选 3判断 4简答
 */
@Getter
public enum SubjectInfoType {


  RADIO(1, "单选"),
  MULTIPLE(2, "多选"),
  JUDGE(3, "判断"),
  BRIEF(4, "简答");

  private final Integer code;

  private final String desc;

  SubjectInfoType(Integer code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static SubjectInfoType getByCode(int code) {
    switch (code) {
      case 1:
        return RADIO;
      case 2:
        return MULTIPLE;
      case 3:
        return JUDGE;
      case 4:
        return BRIEF;
    }

    return null;
  }
}
