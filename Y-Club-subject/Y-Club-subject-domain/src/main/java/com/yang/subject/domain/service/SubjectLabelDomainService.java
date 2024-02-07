package com.yang.subject.domain.service;

import com.yang.subject.domain.entity.SubjectLabelBO;

import java.util.List;

public interface SubjectLabelDomainService {




  void add(SubjectLabelBO subjectLabelBO);

  Boolean update(SubjectLabelBO subjectLabelBO);

  List<SubjectLabelBO>  queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);


  Boolean delete(SubjectLabelBO subjectLabelBO);
}
