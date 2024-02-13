package com.yang.auth.infra.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.auth.infra.entity.AuthPermission;
import com.yang.auth.infra.mapper.AuthPermissionMapper;
import com.yang.auth.infra.service.AuthPermissionService;
import com.yang.subject.common.enums.IsDeleted;
import org.springframework.stereotype.Service;

/**
 * @author Yang
 * @description 针对表【auth_permission】的数据库操作Service实现
 * @createDate 2024-02-10 20:47:34
 */
@Service
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionMapper, AuthPermission>
        implements AuthPermissionService {

  @Override
  public Boolean addPermission(AuthPermission authPermission) {
    return this.save(authPermission);
  }

  @Override
  public Boolean updatePermission(AuthPermission authPermission) {
    return this.updateById(authPermission);
  }

  @Override
  public Boolean status(AuthPermission authPermission) {
    LambdaUpdateWrapper<AuthPermission> wrapper = new LambdaUpdateWrapper<>();
    wrapper.eq(AuthPermission::getId, authPermission.getId())
            .eq(AuthPermission::getStatus, authPermission.getStatus())
            .eq(AuthPermission::getIsDeleted, IsDeleted.UN_DELETED);
    return this.update(wrapper);
  }

  @Override
  public Boolean show(AuthPermission authPermission) {
    LambdaUpdateWrapper<AuthPermission> wrapper = new LambdaUpdateWrapper<>();
    wrapper.eq(AuthPermission::getId, authPermission.getId())
            .eq(AuthPermission::getShow, authPermission.getShow())
            .eq(AuthPermission::getIsDeleted, IsDeleted.UN_DELETED);
    return this.update(wrapper);
  }

  @Override
  public Boolean deletePermission(AuthPermission authPermission) {
    return this.removeById(authPermission);
  }
}




