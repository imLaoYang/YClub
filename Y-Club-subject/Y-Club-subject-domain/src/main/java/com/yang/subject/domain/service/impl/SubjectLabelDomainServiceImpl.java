package com.yang.subject.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yang.subject.domain.convert.SubjectLabelBOConvert;
import com.yang.subject.domain.entity.SubjectLabelBO;
import com.yang.subject.domain.service.SubjectLabelDomainService;
import com.yang.subject.infra.basic.entity.SubjectLabel;
import com.yang.subject.infra.basic.service.SubjectLabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

  @Resource
  private SubjectLabelService subjectLabelService;

  @Override
  public void add(SubjectLabelBO subjectLabelBO) {
    SubjectLabel subjectLabel = SubjectLabelBOConvert.INSTANCE.toSubjectLabel(subjectLabelBO);
    subjectLabelService.save(subjectLabel);
  }

  @Override
  public Boolean update(SubjectLabelBO subjectLabelBO) {
    SubjectLabel subjectLabel = SubjectLabelBOConvert.INSTANCE.toSubjectLabel(subjectLabelBO);
    return subjectLabelService.updateById(subjectLabel);
  }

  /**
   * 根据分类查询标签
   * @param subjectLabelBO
   * @return
   */
  @Override
  public List<SubjectLabel> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
    SubjectLabel subjectLabel = SubjectLabelBOConvert.INSTANCE.toSubjectLabel(subjectLabelBO);
    LambdaQueryWrapper<SubjectLabel> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(SubjectLabel::getCategoryId,subjectLabel.getCategoryId());
    List<SubjectLabel> subjectLabelList = subjectLabelService.list(queryWrapper);
    if (log.isInfoEnabled()){
      log.info("SubjectLabelDomainService. List<SubjectLabel>:{}", JSON.toJSONString(subjectLabelList));
    }
    return subjectLabelList;
  }

  @Override
  public Boolean delete(SubjectLabelBO subjectLabelBO) {
    SubjectLabel subjectLabel = SubjectLabelBOConvert.INSTANCE.toSubjectLabel(subjectLabelBO);
    return subjectLabelService.removeById(subjectLabel);
  }
}
