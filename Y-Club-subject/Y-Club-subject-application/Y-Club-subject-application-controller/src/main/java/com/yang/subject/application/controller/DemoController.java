package com.yang.subject.application.controller;

import com.yang.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {


  @Resource
  private SubjectCategoryService subjectCategoryService;

  @GetMapping("/test")
  public String test(){

    return subjectCategoryService.getById(1).getCategoryName();

  }


}
