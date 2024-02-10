package com.yang.subject.domain.convert;

import com.yang.subject.domain.entity.SubjectAnswerBO;
import com.yang.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMultipleConvert {

  SubjectMultipleConvert INSTANCE = Mappers.getMapper(SubjectMultipleConvert.class);

SubjectMultiple toSubjectMultiple(SubjectAnswerBO option);
}
