package com.yang.subject.domain.convert;

import com.yang.subject.domain.entity.SubjectInfoBO;
import com.yang.subject.infra.basic.entity.SubjectBrief;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectBriefConvert {

  SubjectBriefConvert INSTANCE = Mappers.getMapper(SubjectBriefConvert.class);

  SubjectBrief toSubjectBrief(SubjectInfoBO subjectInfoBO);
}
