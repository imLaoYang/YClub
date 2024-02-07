package com.yang.subject.application.controller;

import com.yang.subject.common.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 題目Controller
 */
@RestController
@RequestMapping("subject")
public class SubjectController {

  /**
   * 新增題目
   * @return
   */
  @PostMapping("add")
  public Result add(){
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
