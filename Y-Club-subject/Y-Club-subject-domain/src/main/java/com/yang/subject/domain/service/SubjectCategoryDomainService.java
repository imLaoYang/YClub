package com.yang.subject.domain.service;

import com.yang.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

public interface SubjectCategoryDomainService {




  void add(SubjectCategoryBO subjectCategoryBO);

  Boolean update(SubjectCategoryBO subjectCategoryBO);

  List<SubjectCategoryBO>  queryPrimaryCategory(SubjectCategoryBO subjectCategoryBO);

  List<SubjectCategoryBO>  queryCategoryByPrimary(SubjectCategoryBO subjectCategoryBO);

  void queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO);

  Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
