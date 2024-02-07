package com.yang.subject.application.controller;

import com.yang.subject.application.convert.SubjectLabelDTOConvert;
import com.yang.subject.application.dto.SubjectLabelDTO;
import com.yang.subject.common.entity.Result;
import com.yang.subject.domain.entity.SubjectLabelBO;
import com.yang.subject.domain.service.SubjectLabelDomainService;
import com.yang.subject.infra.basic.entity.SubjectLabel;
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
@RequestMapping("subject/label")
@Slf4j
public class SubjectLabelController {

  @Resource
  private SubjectLabelDomainService subjectLabelDomainService;

  /**
   * 添加
   *
   * @param subjectLabelDTO
   * @return
   */
  @PostMapping("add")
  public Result add(@RequestBody SubjectLabelDTO subjectLabelDTO) {
    try {
      SubjectLabelBO subjectLabelBO = SubjectLabelDTOConvert.INSTANCE.toSubjectCategoryBO(subjectLabelDTO);
      subjectLabelDomainService.add(subjectLabelBO);
      return Result.ok();
    } catch (Exception e) {
      return Result.fail("添加失败");
    }
  }

  /**
   * 删除
   *
   * @param subjectLabelDTO
   * @return
   */
  @PostMapping("delete")
  public Result delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {
    try {

      SubjectLabelBO subjectLabelBO = SubjectLabelDTOConvert.INSTANCE.toSubjectCategoryBO(subjectLabelDTO);
      Boolean result = subjectLabelDomainService.delete(subjectLabelBO);
      return Result.ok(result);
    } catch (Exception e) {
      return Result.fail("删除失败");
    }
  }

  /**
   * 更新
   *
   * @param subjectLabelDTO
   * @return
   */
  @PostMapping("update")
  public Result update(@RequestBody SubjectLabelDTO subjectLabelDTO) {
    try {
      SubjectLabelBO subjectLabelBO = SubjectLabelDTOConvert.INSTANCE.toSubjectCategoryBO(subjectLabelDTO);
      Boolean result = subjectLabelDomainService.update(subjectLabelBO);
      return Result.ok(result);
    } catch (Exception e) {
      return Result.fail("更新失败");
    }
  }

  /**
   * 根据分类查询标签
   *
   * @param subjectLabelDTO
   * @return
   */
  @PostMapping("queryLabelByCategoryId")
  public Result queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {
    try {
      SubjectLabelBO subjectLabelBO = SubjectLabelDTOConvert.INSTANCE.toSubjectCategoryBO(subjectLabelDTO);
        List<SubjectLabel> subjectLabelList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
      return Result.ok(subjectLabelList);
    } catch (Exception e) {
      return Result.fail("查询失败");
    }
  }




}
