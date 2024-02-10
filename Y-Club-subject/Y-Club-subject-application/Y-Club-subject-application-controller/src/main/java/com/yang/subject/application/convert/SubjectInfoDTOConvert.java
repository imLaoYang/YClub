package com.yang.subject.application.convert;

import com.yang.subject.application.dto.SubjectAnswerDTO;
import com.yang.subject.application.dto.SubjectInfoDTO;
import com.yang.subject.domain.entity.SubjectAnswerBO;
import com.yang.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoDTOConvert {


 SubjectInfoDTOConvert INSTANCE = Mappers.getMapper(SubjectInfoDTOConvert.class);


 SubjectInfoBO toSubjectInfoBO(SubjectInfoDTO subjectInfoDTO);

 List<SubjectAnswerBO> toSubjectAnswerBOList(List<SubjectAnswerDTO> subjectAnswerDTOList);

}
