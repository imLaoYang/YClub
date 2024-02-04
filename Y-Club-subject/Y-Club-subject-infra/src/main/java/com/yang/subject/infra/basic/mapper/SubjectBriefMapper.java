package com.yang.subject.infra.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.subject.infra.basic.po.SubjectBrief;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Yang
* @description 针对表【subject_brief(简答题)】的数据库操作Mapper
* @createDate 2024-02-04 21:44:01
* @Entity generator.domain.SubjectBrief
*/
@Mapper
public interface SubjectBriefMapper extends BaseMapper<SubjectBrief> {

}




