package com.yang.auth.application.convert;

import com.yang.auth.application.entity.AuthRolePermissionDTO;
import com.yang.auth.infra.entity.AuthRolePremission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthRolePermissionDTOConvert {
  AuthRolePermissionDTOConvert INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConvert.class);

  AuthRolePremission toAuthRolePremission(AuthRolePermissionDTO authRolePermissionDTO);

  AuthRolePermissionDTO  toAuthRolePermissionDTO(AuthRolePremission authRolePremission);


}
