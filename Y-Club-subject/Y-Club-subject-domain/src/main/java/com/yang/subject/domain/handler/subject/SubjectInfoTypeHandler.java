package com.yang.subject.domain.handler.subject;

import com.yang.subject.common.enums.SubjectInfoType;
import com.yang.subject.domain.entity.SubjectInfoBO;

public interface SubjectInfoTypeHandler {
  /**
   * 返回题目类型
   * @return
   */
  SubjectInfoType getSubjectInfoType();

  /**
   * 添加题目
   */
  void add(SubjectInfoBO subjectInfoBO);

}
