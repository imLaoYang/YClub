package com.yang.auth.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.auth.infra.entity.AuthRolePremission;
import com.yang.auth.infra.service.AuthRolePremissionService;
import com.yang.auth.infra.mapper.AuthRolePremissionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Yang
* @description 针对表【auth_role_premission】的数据库操作Service实现
* @createDate 2024-02-10 20:47:34
*/
@Service
public class AuthRolePremissionServiceImpl extends ServiceImpl<AuthRolePremissionMapper, AuthRolePremission>
    implements AuthRolePremissionService{

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean addRolePermission(List<AuthRolePremission> list) {
    return this.saveBatch(list);
  }
}




