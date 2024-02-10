package com.yang.subject.domain.handler.subject;

import com.yang.subject.common.enums.SubjectInfoType;
import com.yang.subject.domain.convert.SubjectBriefConvert;
import com.yang.subject.domain.entity.SubjectInfoBO;
import com.yang.subject.infra.basic.entity.SubjectBrief;
import com.yang.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 简答题策略实现类
 */
@Component
public class BriefTypeHandler implements SubjectInfoTypeHandler {

  @Resource
  private SubjectBriefService subjectBriefService;

  @Override
  public SubjectInfoType getSubjectInfoType() {
    return SubjectInfoType.MULTIPLE;
  }

  /**
   * 添加简答题
   */
  @Override
  public void add(SubjectInfoBO subjectInfoBO) {
    SubjectBrief subjectBrief = SubjectBriefConvert.INSTANCE.toSubjectBrief(subjectInfoBO);
    subjectBriefService.save(subjectBrief);
  }
}
