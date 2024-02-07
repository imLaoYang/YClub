package com.yang.subject.infra.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.subject.infra.basic.entity.SubjectCategory;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Yang
* @description 针对表【subject_category(题目分类)】的数据库操作Mapper
* @createDate 2024-02-04 21:44:01
* @Entity generator.domain.SubjectCategory
*/@Mapper
public interface SubjectCategoryMapper extends BaseMapper<SubjectCategory> {

}




