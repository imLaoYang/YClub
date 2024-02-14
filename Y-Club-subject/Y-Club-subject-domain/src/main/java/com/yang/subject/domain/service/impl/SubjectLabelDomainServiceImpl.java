package com.yang.subject.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yang.subject.domain.convert.SubjectLabelBOConvert;
import com.yang.subject.domain.entity.SubjectLabelBO;
import com.yang.subject.domain.service.SubjectLabelDomainService;
import com.yang.subject.infra.basic.entity.SubjectLabel;
import com.yang.subject.infra.basic.entity.SubjectMapping;
import com.yang.subject.infra.basic.service.SubjectLabelService;
import com.yang.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

  @Resource
  private SubjectLabelService subjectLabelService;

  @Resource
  private SubjectMappingService subjectMappingService;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void add(SubjectLabelBO subjectLabelBO) {
    SubjectLabel subjectLabel = SubjectLabelBOConvert.INSTANCE.toSubjectLabel(subjectLabelBO);
    subjectLabelService.addLabel(subjectLabel);
    SubjectMapping subjectMapping = new SubjectMapping();
    subjectMapping.setLabelId(subjectLabel.getId());
    subjectMapping.setCategoryId(subjectLabelBO.getCategoryId());
    subjectMappingService.save(subjectMapping);
  }

  @Override
  public Boolean update(SubjectLabelBO subjectLabelBO) {
    SubjectLabel subjectLabel = SubjectLabelBOConvert.INSTANCE.toSubjectLabel(subjectLabelBO);
    return subjectLabelService.updateById(subjectLabel);
  }

  /**
   * 根据分类查询标签
   *
   * @param subjectLabelBO
   * @return
   */
  @Override
  public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
    SubjectLabel subjectLabel = SubjectLabelBOConvert.INSTANCE.toSubjectLabel(subjectLabelBO);
    LambdaQueryWrapper<SubjectMapping> mappingQueryWrapper = new LambdaQueryWrapper<>();
    mappingQueryWrapper.eq(SubjectMapping::getCategoryId, subjectLabel.getCategoryId());
    // mapping表查询
    List<SubjectMapping> mappingList = subjectMappingService.list(mappingQueryWrapper);
    if (CollectionUtils.isEmpty(mappingList)) {
      return Collections.emptyList();
    }
    List<Long> lableIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
    // label表查询
    List<SubjectLabel> subjectLabelList = subjectLabelService.listByIds(lableIdList);
    // 封装BO
    List<SubjectLabelBO> subjectLabelBOList = new ArrayList<>();
    subjectLabelList.forEach(v -> {
      SubjectLabelBO bo = new SubjectLabelBO();
      bo.setId(v.getId());
      bo.setCategoryId(v.getCategoryId());
      bo.setLabelName(v.getLabelName());
      bo.setSortNum(v.getSortNum());
      subjectLabelBOList.add(bo);
    });
    if (log.isInfoEnabled()) {
      log.info("SubjectLabelDomainService. List<SubjectLabelBO>:{}", JSON.toJSONString(subjectLabelBOList));
    }
    return subjectLabelBOList;
  }

  @Override
  public Boolean delete(SubjectLabelBO subjectLabelBO) {
    SubjectLabel subjectLabel = SubjectLabelBOConvert.INSTANCE.toSubjectLabel(subjectLabelBO);
    return subjectLabelService.removeById(subjectLabel);
  }
}
