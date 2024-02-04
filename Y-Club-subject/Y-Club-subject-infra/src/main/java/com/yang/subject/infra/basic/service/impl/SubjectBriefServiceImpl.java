package com.yang.subject.infra.basic.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.subject.infra.basic.mapper.SubjectBriefMapper;
import com.yang.subject.infra.basic.po.SubjectBrief;
import com.yang.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;

/**
* @author Yang
* @description 针对表【subject_brief(简答题)】的数据库操作Service实现
* @createDate 2024-02-04 21:44:01
*/
@Service
public class SubjectBriefServiceImpl extends ServiceImpl<SubjectBriefMapper, SubjectBrief>
    implements SubjectBriefService{

}




