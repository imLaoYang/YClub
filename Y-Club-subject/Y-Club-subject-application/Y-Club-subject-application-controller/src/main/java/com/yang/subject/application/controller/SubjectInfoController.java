package com.yang.subject.application.controller;

import com.yang.subject.application.convert.SubjectInfoDTOConvert;
import com.yang.subject.application.dto.SubjectInfoDTO;
import com.yang.subject.common.entity.PageResult;
import com.yang.subject.common.entity.Result;
import com.yang.subject.domain.entity.SubjectAnswerBO;
import com.yang.subject.domain.entity.SubjectInfoBO;
import com.yang.subject.domain.service.SubjectInfoDomainService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 題目Controller
 */
@RestController
@RequestMapping("subject")
public class SubjectInfoController {

  @Resource
  private SubjectInfoDomainService subjectInfoDomainService;

  /**
   * 新增題目
   *
   * @return
   */
  @PostMapping("add")
  public Result add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
    try {
      SubjectInfoBO subjectInfoBO = SubjectInfoDTOConvert.INSTANCE.toSubjectInfoBO(subjectInfoDTO);
      List<SubjectAnswerBO> optionList = SubjectInfoDTOConvert.INSTANCE.toSubjectAnswerBOList(subjectInfoDTO.getOptionList());
      subjectInfoBO.setOptionList(optionList);
      subjectInfoDomainService.add(subjectInfoBO);
      return Result.ok("添加成功");
    } catch (Exception e) {
      return Result.fail("添加失败");
    }
  }

  /**
   * 查询题目列表(分页)
   *
   * @return
   */
  @PostMapping("getSubjectPage")
  public Result getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {

    try {
      SubjectInfoBO subjectInfoBO = SubjectInfoDTOConvert.INSTANCE.toSubjectInfoBO(subjectInfoDTO);
      PageResult<SubjectInfoBO> pageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
      return Result.ok(pageResult);
    } catch (Exception e) {
      return Result.fail(e.getMessage());
    }
  }


  /**
   * 查询题目详情
   *
   * @return
   */
  @PostMapping("querySubjectInfo")
  public Result querySubjectInfo() {
    return null;
  }


}
