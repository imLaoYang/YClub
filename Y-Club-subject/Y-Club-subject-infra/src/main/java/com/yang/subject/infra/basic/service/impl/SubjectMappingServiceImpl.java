package com.yang.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.subject.infra.basic.mapper.SubjectMappingMapper;
import com.yang.subject.infra.basic.entity.SubjectMapping;
import com.yang.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

/**
* @author Yang
* @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Service实现
* @createDate 2024-02-04 21:44:01
*/
@Service
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingMapper, SubjectMapping>
    implements SubjectMappingService{

}




