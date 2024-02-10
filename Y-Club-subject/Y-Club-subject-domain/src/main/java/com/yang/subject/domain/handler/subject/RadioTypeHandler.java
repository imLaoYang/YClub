package com.yang.subject.domain.handler.subject;

import com.yang.subject.common.enums.SubjectInfoType;
import com.yang.subject.domain.convert.SubjectRadioConvert;
import com.yang.subject.domain.entity.SubjectAnswerBO;
import com.yang.subject.domain.entity.SubjectInfoBO;
import com.yang.subject.infra.basic.entity.SubjectRadio;
import com.yang.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 单选题目策略实现类
 */
@Component
public class RadioTypeHandler implements SubjectInfoTypeHandler {

  @Resource
  private SubjectRadioService subjectRadioService;

  @Override
  public SubjectInfoType getSubjectInfoType() {
    return SubjectInfoType.RADIO;
  }

  /**
   * 添加单选题目
   */
  @Override
  public void add(SubjectInfoBO subjectInfoBO) {
    List<SubjectAnswerBO> optionList = subjectInfoBO.getOptionList();
    if (CollectionUtils.isEmpty(optionList)) {
      throw new RuntimeException("optionList为空");
    }
    List<SubjectRadio> subjectRadioList = new ArrayList<>();
    optionList.forEach(option -> {
      SubjectRadio subjectRadio = SubjectRadioConvert.INSTANCE.toSubjectRadio(option);
      subjectRadio.setSubjectId(subjectInfoBO.getId());
      subjectRadioList.add(subjectRadio);
    });
    subjectRadioService.saveBatch(subjectRadioList);
  }
}
