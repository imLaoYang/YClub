package com.yang.subject.domain.service;

import com.yang.subject.domain.entity.SubjectCategoryBO;
import com.yang.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

public interface SubjectCategoryDomainService {




  void add(SubjectCategoryBO subjectCategoryBO);

  Boolean update(SubjectCategoryBO subjectCategoryBO);

  List<SubjectCategory>  queryPrimaryCategory(SubjectCategoryBO subjectCategoryBO);

  List<SubjectCategory> queryCategoryByPrimary(SubjectCategoryBO subjectCategoryBO);

  void queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO);

  Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
