package com.yang.subject.infra.basic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.subject.infra.basic.entity.SubjectLabel;

/**
* @author Yang
* @description 针对表【subject_label(题目标签表)】的数据库操作Service
* @createDate 2024-02-04 21:44:01
*/
public interface SubjectLabelService extends IService<SubjectLabel> {

  void addLabel(SubjectLabel subjectLabel);
}
