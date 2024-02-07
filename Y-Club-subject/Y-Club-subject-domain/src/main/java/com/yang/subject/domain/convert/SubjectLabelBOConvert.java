package com.yang.subject.domain.convert;

import com.yang.subject.domain.entity.SubjectLabelBO;
import com.yang.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectLabelBOConvert {

  SubjectLabelBOConvert INSTANCE = Mappers.getMapper(SubjectLabelBOConvert.class);


  SubjectLabel toSubjectLabel(SubjectLabelBO subjectLabelBO);

}
