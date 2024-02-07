package com.yang.subject.infra.basic.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.subject.infra.basic.mapper.SubjectCategoryMapper;
import com.yang.subject.infra.basic.entity.SubjectCategory;
import com.yang.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;


/**
* @author Yang
* @description 针对表【subject_category(题目分类)】的数据库操作Service实现
* @createDate 2024-02-04 21:44:01
*/
@Service
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryMapper, SubjectCategory>
    implements SubjectCategoryService{

}




