package com.yang.subject.domain.service;


import com.yang.subject.common.entity.PageResult;
import com.yang.subject.domain.entity.SubjectInfoBO;

public interface SubjectInfoDomainService {


  void add(SubjectInfoBO subjectInfoBO);

  Boolean update(SubjectInfoBO subjectInfoBO);

  Boolean delete(SubjectInfoBO subjectInfoBO);

  PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);
}
