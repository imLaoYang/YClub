package com.yang.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.subject.infra.basic.entity.SubjectInfo;
import com.yang.subject.infra.basic.mapper.SubjectInfoMapper;
import com.yang.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Yang
* @description 针对表【subject_info(题目信息表)】的数据库操作Service实现
* @createDate 2024-02-04 21:44:01
*/
@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo>
    implements SubjectInfoService{

  @Resource
  private SubjectInfoMapper subjectInfoMapper;

  @Override
  public void add(SubjectInfo subjectInfo) {
      subjectInfoMapper.add(subjectInfo );
  }


  @Override
  public List<SubjectInfo> getSubjectPage(SubjectInfo subjectInfo,Integer categoryId,Integer labelId,Long start, Long pageSize) {
    return subjectInfoMapper.getSubjectPage(subjectInfo,categoryId,labelId, start,pageSize);
  }

  @Override
  public Long countByCondition(SubjectInfo subjectInfo,Integer categoryId,Integer labelId) {
    return subjectInfoMapper.countByCondition(subjectInfo,categoryId,labelId);
  }
}




