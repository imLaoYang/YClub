package com.yang.subject.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.yang.subject.common.entity.PageResult;
import com.yang.subject.domain.convert.SubjectInfoBOConvert;
import com.yang.subject.domain.entity.SubjectInfoBO;
import com.yang.subject.domain.handler.subject.SubjectInfoTypeHandler;
import com.yang.subject.domain.handler.subject.factory.SubjectInfoHandlerFactory;
import com.yang.subject.domain.service.SubjectInfoDomainService;
import com.yang.subject.infra.basic.entity.SubjectInfo;
import com.yang.subject.infra.basic.entity.SubjectMapping;
import com.yang.subject.infra.basic.service.SubjectInfoService;
import com.yang.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

  @Resource
  private SubjectInfoService subjectInfoService;

  @Resource
  private SubjectMappingService subjectMappingService;

  @Resource
  private SubjectInfoHandlerFactory subjectInfoHandlerFactory;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void add(SubjectInfoBO subjectInfoBO) {
    if (log.isInfoEnabled()) {
      log.info("SubjectInfoDomainServiceImpl.add.SubjectInfoBO:{}", JSON.toJSONString(subjectInfoBO));
    }

    SubjectInfo subjectInfo = SubjectInfoBOConvert.INSTANCE.toSubjectInfo(subjectInfoBO);
    //   subjectInfo
    subjectInfoService.add(subjectInfo);
    subjectInfoBO.setId(subjectInfo.getId());


    SubjectInfoTypeHandler handler = subjectInfoHandlerFactory.getHandler(subjectInfo.getSubjectType());
    // 根据题目类型插入
    handler.add(subjectInfoBO);
    //  subject_mapping插入
    List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
    List<Integer> labelIds = subjectInfoBO.getLabelIds();
    if (CollectionUtils.isEmpty(categoryIds) || CollectionUtils.isEmpty(labelIds)) {
      throw new RuntimeException("categoryIds、labelIds为空");
    }

    List<SubjectMapping> subjectMappingList = new ArrayList<>();
    for (Integer categoryId : categoryIds) {
      for (Integer labelId : labelIds) {
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setLabelId(Long.valueOf(labelId));
        subjectMapping.setCategoryId(Long.valueOf(categoryId));
        subjectMappingList.add(subjectMapping);
      }
    }
    subjectMappingService.saveBatch(subjectMappingList);
  }

  @Override
  public Boolean update(SubjectInfoBO subjectInfoBO) {
    return null;
  }

  @Override
  public Boolean delete(SubjectInfoBO subjectInfoBO) {
    return null;
  }

  @Override
  public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
    SubjectInfo subjectInfo = SubjectInfoBOConvert.INSTANCE.toSubjectInfo(subjectInfoBO);
    PageResult<SubjectInfoBO> pageResult = new PageResult<>();
    Long start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
    pageResult.setStart(start);
    pageResult.setEnd(subjectInfoBO.getPageSize());
    long count = subjectInfoService.countByCondition(subjectInfo, subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId());
    List<SubjectInfo> subjectInfoList = subjectInfoService.getSubjectPage(
            subjectInfo, subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId(), start, subjectInfoBO.getPageSize());
    List<SubjectInfoBO> subjectInfoBOList = SubjectInfoBOConvert.INSTANCE.toSubjectInfoBOList(subjectInfoList);
    pageResult.setRecords(subjectInfoBOList);
    pageResult.setTotal(count);
    return pageResult;
  }
}
