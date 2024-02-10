package com.yang.subject.domain.convert;

import com.yang.subject.domain.entity.SubjectAnswerBO;
import com.yang.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectRadioConvert {

  SubjectRadioConvert INSTANCE = Mappers.getMapper(SubjectRadioConvert.class);

  SubjectRadio toSubjectRadio(SubjectAnswerBO option);
}
