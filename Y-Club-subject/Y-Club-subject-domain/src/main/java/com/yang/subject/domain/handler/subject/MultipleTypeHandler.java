package com.yang.subject.domain.handler.subject;

import com.yang.subject.common.enums.SubjectInfoType;
import com.yang.subject.domain.convert.SubjectMultipleConvert;
import com.yang.subject.domain.entity.SubjectAnswerBO;
import com.yang.subject.domain.entity.SubjectInfoBO;
import com.yang.subject.infra.basic.entity.SubjectMultiple;
import com.yang.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 多选题目策略实现类
 */
@Component
public class MultipleTypeHandler implements SubjectInfoTypeHandler {

  @Resource
  private SubjectMultipleService subjectMultipleService;

  @Override
  public SubjectInfoType getSubjectInfoType() {
    return SubjectInfoType.MULTIPLE;
  }

  /**
   * 添加多选题目
   */
  @Override
  public void add(SubjectInfoBO subjectInfoBO) {
    List<SubjectAnswerBO> optionList = subjectInfoBO.getOptionList();
    if (CollectionUtils.isEmpty(optionList)) {
      throw new RuntimeException("optionList为空");
    }

    List<SubjectMultiple> subjectMultipleList = new ArrayList<>();
    optionList.forEach( option ->{
      SubjectMultiple subjectMultiple = SubjectMultipleConvert.INSTANCE.toSubjectMultiple(option);
      subjectMultiple.setSubjectId(subjectInfoBO.getId());
      subjectMultipleList.add(subjectMultiple);
    } );
    subjectMultipleService.saveBatch(subjectMultipleList);
  }
}
