package com.yang.auth.application.convert;

import com.yang.auth.application.entity.AuthPermissionDTO;
import com.yang.auth.infra.entity.AuthPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthPermissionDTOConvert {
  AuthPermissionDTOConvert INSTANCE = Mappers.getMapper(AuthPermissionDTOConvert.class);

  AuthPermission toAuthPermission(AuthPermissionDTO authPermissionDTO);

  AuthPermissionDTO  toAuthUserDTO(AuthPermission authPermission);


}
