package com.yang.auth.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.auth.infra.entity.AuthRole;
import com.yang.auth.infra.service.AuthRoleService;
import com.yang.auth.infra.mapper.AuthRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Yang
* @description 针对表【auth_role】的数据库操作Service实现
* @createDate 2024-02-10 20:47:34
*/
@Service
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRole>
    implements AuthRoleService{


  @Override
  public Boolean addRole(AuthRole authUser) {
    return save(authUser);
  }

  @Override
  public Boolean updateRole(AuthRole authUser) {
    return updateById(authUser);
  }

  @Override
  public Boolean deleteRole(AuthRole authUser) {
    return removeById(authUser.getId());
  }
}




