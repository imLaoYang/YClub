package com.yang.auth.application.convert;

import com.yang.auth.application.entity.AuthRoleDTO;
import com.yang.auth.application.entity.AuthUserDTO;
import com.yang.auth.infra.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthRoleDTOConvert {
  AuthRoleDTOConvert INSTANCE = Mappers.getMapper(AuthRoleDTOConvert.class);

  AuthRole toAuthUser(AuthRoleDTO authRoleDTO);

  AuthUserDTO  toAuthUserDTO(AuthRole authRole);


}
