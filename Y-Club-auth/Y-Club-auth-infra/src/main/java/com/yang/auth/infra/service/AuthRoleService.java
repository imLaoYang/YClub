package com.yang.auth.infra.service;

import com.yang.auth.infra.entity.AuthRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Yang
* @description 针对表【auth_role】的数据库操作Service
* @createDate 2024-02-10 20:47:34
*/
public interface AuthRoleService extends IService<AuthRole> {

  Boolean addRole(AuthRole authUser);

  Boolean updateRole(AuthRole authUser);

  Boolean deleteRole(AuthRole authUser);
}
