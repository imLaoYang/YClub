package com.yang.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.subject.infra.basic.entity.SubjectInfo;

import java.util.List;

/**
 * @author Yang
 * @description 针对表【subject_info(题目信息表)】的数据库操作Service
 * @createDate 2024-02-04 21:44:01
 */
public interface SubjectInfoService extends IService<SubjectInfo> {

  void add(SubjectInfo subjectInfo);

  List<SubjectInfo> getSubjectPage( SubjectInfo subjectInfo,Integer categoryId, Integer labelId,Long start, Long pageSize);

  Long countByCondition(SubjectInfo subjectInfo,Integer categoryId,Integer labelId);
}
