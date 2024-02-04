package com.yang.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.subject.infra.basic.mapper.SubjectInfoMapper;
import com.yang.subject.infra.basic.po.SubjectInfo;
import com.yang.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

/**
* @author Yang
* @description 针对表【subject_info(题目信息表)】的数据库操作Service实现
* @createDate 2024-02-04 21:44:01
*/
@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo>
    implements SubjectInfoService{

}




