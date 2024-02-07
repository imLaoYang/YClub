package com.yang.subject.application.convert;

import com.yang.subject.application.dto.SubjectInfoDTO;
import com.yang.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectInfoDTOConvert {


 SubjectInfoDTOConvert INSTANCE = Mappers.getMapper(SubjectInfoDTOConvert.class);


 SubjectInfoBO toSubjectInfoBO(SubjectInfoDTO subjectInfoDTO);

}
