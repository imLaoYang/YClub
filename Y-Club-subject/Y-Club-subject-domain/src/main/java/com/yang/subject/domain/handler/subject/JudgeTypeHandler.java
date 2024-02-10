package com.yang.subject.domain.handler.subject;

import com.yang.subject.common.enums.SubjectInfoType;
import com.yang.subject.domain.entity.SubjectAnswerBO;
import com.yang.subject.domain.entity.SubjectInfoBO;
import com.yang.subject.infra.basic.entity.SubjectJudge;
import com.yang.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 判断题目策略实现类
 */
@Component
public class JudgeTypeHandler implements SubjectInfoTypeHandler {

  @Resource
  private SubjectJudgeService subjectJudgeService;

  @Override
  public SubjectInfoType getSubjectInfoType() {
    return SubjectInfoType.MULTIPLE;
  }

  /**
   * 添加判断题
   */
  @Override
  public void add(SubjectInfoBO subjectInfoBO) {
    List<SubjectAnswerBO> optionList = subjectInfoBO.getOptionList();
    SubjectAnswerBO subjectAnswerBO = optionList.get(0);
    SubjectJudge subjectJudge = new SubjectJudge();
    subjectJudge.setSubjectId(subjectInfoBO.getId());
    subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
    subjectJudgeService.save(subjectJudge);
  }
}
