package com.yang.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OptionDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer optionType;

  private String optionContent;

  private Integer isCorrect;

}
