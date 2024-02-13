package com.yang.auth.infra.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.auth.infra.constans.AuthConstant;
import com.yang.auth.infra.entity.AuthRole;
import com.yang.auth.infra.entity.AuthUser;
import com.yang.auth.infra.entity.AuthUserRole;
import com.yang.auth.infra.mapper.AuthUserMapper;
import com.yang.auth.infra.service.AuthRoleService;
import com.yang.auth.infra.service.AuthUserRoleService;
import com.yang.auth.infra.service.AuthUserService;
import com.yang.subject.common.enums.IsDeleted;
import com.yang.subject.common.enums.UserStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang
 * @description 针对表【auth_user】的数据库操作Service实现
 * @createDate 2024-02-10 20:47:34
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser>
        implements AuthUserService {

  @Autowired
  private AuthRoleService authRoleService;

  @Autowired
  private AuthUserRoleService authUserRoleService;

  private String salt = "yang";

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean register(AuthUser authUser) {
    String pwd = SaSecureUtil.md5BySalt(authUser.getPassword(), salt);
    authUser.setPassword(pwd);
    baseMapper.insertAll(authUser);

    AuthRole authRole = new AuthRole();
    authRole.setRoleKey(AuthConstant.NORMAL_USER);
    LambdaQueryWrapper<AuthRole> wrapper = new LambdaQueryWrapper<AuthRole>().eq(AuthRole::getRoleKey, authRole.getRoleKey());
    AuthRole role = authRoleService.getOne(wrapper);
    // 用户角色关联
    AuthUserRole authUserRole = new AuthUserRole();
    authUserRole.setUserId(authUser.getId());
    authUserRole.setRoleId(role.getId());
    authUserRoleService.save(authUserRole);

    // 权限加入redis中

    return true;
  }

  @Override
  public Boolean updateUser(AuthUser authUser) {

    if (authUser.getStatus().equals(UserStatus.DISABLE.getCode())) {
      return false;
    }
    if (StringUtils.isNotEmpty(authUser.getPassword())) {
      String pwd = SaSecureUtil.md5BySalt(authUser.getPassword(), salt);
      authUser.setPassword(pwd);
    }
    return updateById(authUser);
  }

  @Override
  public Boolean deleteUser(AuthUser authUser) {
    return removeById(authUser.getId());
  }

  @Override
  public Boolean changeStatus(AuthUser authUser) {
    LambdaUpdateWrapper<AuthUser> updateWrapper = new LambdaUpdateWrapper<>();
    updateWrapper.eq(AuthUser::getId, authUser.getId())
            .eq(AuthUser::getStatus, authUser.getStatus())
            .eq(AuthUser::getIsDeleted, IsDeleted.UN_DELETED);
   return update(updateWrapper);
  }

  @Override
  public AuthUser getUserInfo(AuthUser authUser) {
    LambdaUpdateWrapper<AuthUser> wrapper  = new LambdaUpdateWrapper<>();
    wrapper.eq(AuthUser::getUserName,authUser.getUserName())
            .eq(AuthUser::getStatus,UserStatus.OPEN)
                    .eq(AuthUser::getIsDeleted,IsDeleted.UN_DELETED);
   return getOne(wrapper);
  }
}




