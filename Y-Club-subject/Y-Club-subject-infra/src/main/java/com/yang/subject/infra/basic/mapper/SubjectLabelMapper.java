package com.yang.subject.infra.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.subject.infra.basic.entity.SubjectLabel;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Yang
* @description 针对表【subject_label(题目标签表)】的数据库操作Mapper
* @createDate 2024-02-04 21:44:01
* @Entity generator.domain.SubjectLabel
*/@Mapper
public interface SubjectLabelMapper extends BaseMapper<SubjectLabel> {

}




