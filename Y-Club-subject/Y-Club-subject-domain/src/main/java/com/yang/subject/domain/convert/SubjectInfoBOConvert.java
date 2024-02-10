package com.yang.subject.domain.convert;

import com.yang.subject.domain.entity.SubjectInfoBO;
import com.yang.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoBOConvert {

  SubjectInfoBOConvert INSTANCE = Mappers.getMapper(SubjectInfoBOConvert.class);

  SubjectInfo toSubjectInfo(SubjectInfoBO subjectInfoBO);

  List<SubjectInfoBO> toSubjectInfoBOList(List<SubjectInfo> subjectInfoList);
}
