package com.yang.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签DTO
 */
@Data
public class SubjectLabelBO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 标签分类
     */
    private String labelName;

    /**
     * 排序
     */
    private Integer sortNum;

    /**
     *
     */
    private Long categoryId;



    private static final long serialVersionUID = 1L;

}