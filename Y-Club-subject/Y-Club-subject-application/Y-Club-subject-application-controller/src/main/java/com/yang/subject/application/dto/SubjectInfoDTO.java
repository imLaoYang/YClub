package com.yang.subject.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SubjectInfoDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  /**
   * 题目名称
   */
  private String subjectName;

  /**
   * 题目难度
   */
  private Integer subjectDifficult;

  /**
   * 出题人名
   */
  private String settleName;

  /**
   * 题目类型 1单选 2多选 3判断 4简答
   */
  private Integer subjectType;

  /**
   * 题目分数
   */
  private Integer subjectScore;

  /**
   * 题目解析
   */
  private String subjectParse;

  /**
   * 类型数组
   */
  private List<Integer> categoryIds;

  /**
   * 标签数组
   */
  private List<Integer> labelIds;

  /**
   *
   */
  private List<OptionDTO> optionList;


}
