package com.yang.subject.common.enums;

import lombok.Getter;


/**
 * 题目类型 1单选 2多选 3判断 4简答
 */
@Getter
public enum SubjectType {


  BRIEF(1, "单选"),
  MULTIPLE(2, "多选"),
  JUDGE(3, "判断"),
  RADIO(3, "简单");

  private final Integer code;

  private final String desc;

  SubjectType(Integer code, String desc) {
    this.code = code;
    this.desc = desc;
  }

}
