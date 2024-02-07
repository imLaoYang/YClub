package com.yang.subject.application.convert;

import com.yang.subject.application.dto.SubjectLabelDTO;
import com.yang.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectLabelDTOConvert {


 SubjectLabelDTOConvert INSTANCE = Mappers.getMapper(SubjectLabelDTOConvert.class);


 SubjectLabelBO toSubjectCategoryBO(SubjectLabelDTO subjectLabelDTO);

}
