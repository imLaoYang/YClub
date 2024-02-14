package com.yang.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.subject.infra.basic.mapper.SubjectLabelMapper;
import com.yang.subject.infra.basic.entity.SubjectLabel;
import com.yang.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

/**
* @author Yang
* @description 针对表【subject_label(题目标签表)】的数据库操作Service实现
* @createDate 2024-02-04 21:44:01
*/
@Service
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelMapper, SubjectLabel>
    implements SubjectLabelService{

  @Override
  public void addLabel(SubjectLabel subjectLabel) {
    this.baseMapper.addLabel(subjectLabel);
  }
}




