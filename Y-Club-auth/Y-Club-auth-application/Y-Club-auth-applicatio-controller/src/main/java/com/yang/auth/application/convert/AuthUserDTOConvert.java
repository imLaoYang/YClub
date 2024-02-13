package com.yang.auth.application.convert;

import com.yang.auth.application.entity.AuthUserDTO;
import com.yang.auth.infra.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthUserDTOConvert {
  AuthUserDTOConvert INSTANCE = Mappers.getMapper(AuthUserDTOConvert.class);

  AuthUser toAuthUser(AuthUserDTO authUserDTO);

  AuthUserDTO  toAuthUserDTO(AuthUser authUser);


}
