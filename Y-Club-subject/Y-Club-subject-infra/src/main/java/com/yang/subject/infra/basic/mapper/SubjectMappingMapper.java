package com.yang.subject.infra.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.subject.infra.basic.entity.SubjectMapping;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Yang
* @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Mapper
* @createDate 2024-02-04 21:44:01
* @Entity generator.domain.SubjectMapping
*/@Mapper
public interface SubjectMappingMapper extends BaseMapper<SubjectMapping> {

}




