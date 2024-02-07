package com.yang.subject.domain.convert;

import com.yang.subject.domain.entity.SubjectCategoryBO;
import com.yang.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectCategoryBOConvert {

  SubjectCategoryBOConvert INSTANCE = Mappers.getMapper(SubjectCategoryBOConvert.class);


  SubjectCategory toSubjectCategory(SubjectCategoryBO SubjectCategoryBO);

}
