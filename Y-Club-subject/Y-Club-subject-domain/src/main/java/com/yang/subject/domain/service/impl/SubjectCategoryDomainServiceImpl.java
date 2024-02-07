package com.yang.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yang.subject.domain.convert.SubjectCategoryBOConvert;
import com.yang.subject.domain.entity.SubjectCategoryBO;
import com.yang.subject.domain.service.SubjectCategoryDomainService;
import com.yang.subject.infra.basic.entity.SubjectCategory;
import com.yang.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

  @Resource
  private SubjectCategoryService subjectCategoryService;

  @Override
  public void add(SubjectCategoryBO subjectCategoryBO) {

    SubjectCategory subjectCategory = SubjectCategoryBOConvert.INSTANCE.toSubjectCategory(subjectCategoryBO);
    subjectCategoryService.save(subjectCategory);

  }

  @Override
  public Boolean update(SubjectCategoryBO subjectCategoryBO) {
    SubjectCategory subjectCategory = SubjectCategoryBOConvert.INSTANCE.toSubjectCategory(subjectCategoryBO);
    return subjectCategoryService.updateById(subjectCategory);
  }

  @Override
  public List<SubjectCategory> queryPrimaryCategory(SubjectCategoryBO subjectCategoryBO) {
    SubjectCategory subjectCategory = SubjectCategoryBOConvert.INSTANCE.toSubjectCategory(subjectCategoryBO);
    LambdaQueryWrapper<SubjectCategory> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(SubjectCategory::getCategoryType, subjectCategory.getCategoryType());
    List<SubjectCategory> subjectCategoryList = subjectCategoryService.list(queryWrapper);
    if (log.isInfoEnabled()) {
      log.info("SubjectCategoryDomainServiceImpl.List<SubjectCategory>:{}", JSON.toJSONString(subjectCategoryList));
    }
    return subjectCategoryList;
  }

  @Override
  public List<SubjectCategory> queryCategoryByPrimary(SubjectCategoryBO subjectCategoryBO) {
    SubjectCategory subjectCategory = SubjectCategoryBOConvert.INSTANCE.toSubjectCategory(subjectCategoryBO);
    LambdaQueryWrapper<SubjectCategory> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(SubjectCategory::getCategoryType, subjectCategory.getCategoryType())
            .eq(SubjectCategory::getParentId, subjectCategory.getParentId());
    List<SubjectCategory> subjectCategoryList = subjectCategoryService.list(queryWrapper);
    if (log.isInfoEnabled()) {
      log.info("SubjectCategoryDomainServiceImpl.List<SubjectCategory>:{}", JSON.toJSONString(subjectCategoryList));
    }
    return subjectCategoryList;
  }

  @Override
  public void queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO) {

  }

  @Override
  public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
    SubjectCategory subjectCategory = SubjectCategoryBOConvert.INSTANCE.toSubjectCategory(subjectCategoryBO);
    return subjectCategoryService.removeById(subjectCategory);
  }
}
