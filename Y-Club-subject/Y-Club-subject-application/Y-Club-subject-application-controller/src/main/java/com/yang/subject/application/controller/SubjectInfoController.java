package com.yang.subject.application.controller;

import com.yang.subject.application.convert.SubjectInfoDTOConvert;
import com.yang.subject.application.dto.SubjectInfoDTO;
import com.yang.subject.common.entity.Result;
import com.yang.subject.domain.entity.SubjectInfoBO;
import com.yang.subject.domain.service.SubjectInfoDomainService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
   * @return
   */
  @PostMapping("add")
  public Result add(@RequestBody SubjectInfoDTO subjectInfoDTO){
    SubjectInfoBO subjectInfoBO = SubjectInfoDTOConvert.INSTANCE.toSubjectInfoBO(subjectInfoDTO);

    return null;
  }

  /**
   * 查询题目列表
   * @return
   */
  @PostMapping("getSubjectPage")
  public Result getSubjectPage(){
    return null;
  }


  /**
   * 查询题目详情
   * @return
   */
  @PostMapping("querySubjectInfo")
  public Result querySubjectInfo(){
    return null;
  }


}
