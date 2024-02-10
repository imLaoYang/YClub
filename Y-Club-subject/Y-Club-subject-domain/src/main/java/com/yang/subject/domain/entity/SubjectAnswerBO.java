package com.yang.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubjectAnswerBO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer optionType;

  private String optionContent;

  private Integer isCorrect;

}
