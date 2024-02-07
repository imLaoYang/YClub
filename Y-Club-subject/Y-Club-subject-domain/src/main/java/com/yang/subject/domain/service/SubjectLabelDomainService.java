package com.yang.subject.domain.service;

import com.yang.subject.domain.entity.SubjectLabelBO;
import com.yang.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

public interface SubjectLabelDomainService {




  void add(SubjectLabelBO subjectLabelBO);

  Boolean update(SubjectLabelBO subjectLabelBO);

  List<SubjectLabel>  queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);


  Boolean delete(SubjectLabelBO subjectLabelBO);
}
