package com.yang.auth.infra.service;

import com.yang.auth.infra.entity.AuthUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Yang
* @description 针对表【auth_user】的数据库操作Service
* @createDate 2024-02-10 20:47:34
*/
public interface AuthUserService extends IService<AuthUser> {

  Boolean register(AuthUser authUser);

  Boolean updateUser(AuthUser authUser);

  Boolean deleteUser(AuthUser authUser);

  Boolean changeStatus(AuthUser authUser);

  AuthUser getUserInfo(AuthUser authUser);
}
