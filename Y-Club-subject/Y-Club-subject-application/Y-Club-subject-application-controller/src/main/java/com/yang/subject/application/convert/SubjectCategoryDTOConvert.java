package com.yang.subject.application.convert;

import com.yang.subject.application.dto.SubjectCategoryDTO;
import com.yang.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectCategoryDTOConvert {


 SubjectCategoryDTOConvert INSTANCE = Mappers.getMapper(SubjectCategoryDTOConvert.class);


 SubjectCategoryBO toSubjectCategoryBO(SubjectCategoryDTO subjectCategoryDTO);

}
