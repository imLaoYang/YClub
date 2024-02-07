package com.yang.subject.application.controller;

import com.google.common.base.Preconditions;
import com.yang.subject.application.convert.SubjectCategoryDTOConvert;
import com.yang.subject.application.dto.SubjectCategoryDTO;
import com.yang.subject.common.entity.Result;
import com.yang.subject.domain.entity.SubjectCategoryBO;
import com.yang.subject.domain.service.SubjectCategoryDomainService;
import com.yang.subject.infra.basic.entity.SubjectCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 题目分类
 */
@RestController
@RequestMapping("subject/category")
@Slf4j
public class SubjectCategoryController {

  @Resource
  private SubjectCategoryDomainService subjectCategoryDomainService;

  /**
   * 添加
   *
   * @param subjectCategoryDTO
   * @return
   */
  @PostMapping("add")
  public Result add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
    try {
      SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConvert.INSTANCE.toSubjectCategoryBO(subjectCategoryDTO);
      subjectCategoryDomainService.add(subjectCategoryBO);
      return Result.ok();
    } catch (Exception e) {
      return Result.fail("添加失败");
    }
  }

  /**
   * 删除
   *
   * @param subjectCategoryDTO
   * @return
   */
  @PostMapping("delete")
  public Result delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
    try {

      SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConvert.INSTANCE.toSubjectCategoryBO(subjectCategoryDTO);
      Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
      return Result.ok(result);
    } catch (Exception e) {
      return Result.fail("删除失败");
    }
  }

  /**
   * 更新
   *
   * @param subjectCategoryDTO
   * @return
   */
  @PostMapping("update")
  public Result update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
    try {
      SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConvert.INSTANCE.toSubjectCategoryBO(subjectCategoryDTO);
      Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
      return Result.ok(result);
    } catch (Exception e) {
      return Result.fail("更新失败");
    }
  }

  /**
   * 查询分类
   *
   * @param subjectCategoryDTO
   * @return
   */
  @PostMapping("queryPrimaryCategory")
  public Result queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
    try {
      Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
      SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConvert.INSTANCE.toSubjectCategoryBO(subjectCategoryDTO);
      List<SubjectCategory> subjectCategoryList = subjectCategoryDomainService.queryPrimaryCategory(subjectCategoryBO);
      return Result.ok(subjectCategoryList);
    } catch (Exception e) {
      return Result.fail("查询失败");
    }
  }


  /**
   * 查询大类下分类
   *
   * @param subjectCategoryDTO
   * @return
   */
  @PostMapping("queryCategoryByPrimary")
  public Result queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
    try {
      Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "父类ID不能为空");
      Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
      SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConvert.INSTANCE.toSubjectCategoryBO(subjectCategoryDTO);
      List<SubjectCategory> subjectCategoryList = subjectCategoryDomainService.queryCategoryByPrimary(subjectCategoryBO);
      return Result.ok(subjectCategoryList);
    } catch (Exception e) {
      return Result.fail("查询失败");
    }
  }

  /**
   * todo 查询分类及标签(优化)
   *
   * @param subjectCategoryDTO
   * @return
   */
  @PostMapping("queryCategoryAndLabel")
  public Result queryCategoryAndLabel(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
    try {
      SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConvert.INSTANCE.toSubjectCategoryBO(subjectCategoryDTO);
      subjectCategoryDomainService.queryCategoryAndLabel(subjectCategoryBO);
      return Result.ok();
    } catch (Exception e) {
      return Result.fail("查询失败");
    }
  }


}
