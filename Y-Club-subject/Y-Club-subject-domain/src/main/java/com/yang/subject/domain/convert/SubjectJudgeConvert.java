package com.yang.subject.domain.convert;

import com.yang.subject.domain.entity.SubjectAnswerBO;
import com.yang.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectJudgeConvert {

  SubjectJudgeConvert INSTANCE = Mappers.getMapper(SubjectJudgeConvert.class);

  SubjectJudge toSubjectJudge(SubjectAnswerBO option);
}
