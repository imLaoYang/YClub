package com.yang.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {

  @Autowired
  private RedisTemplate redisTemplate;

  private String authPermissionPrefix = "auth.permission";

  private String authRolePrefix = "auth.role";


  @Override
  public List<String> getPermissionList(Object loginId, String loginType) {
    String permission = (String) redisTemplate.opsForValue().get(authPermissionPrefix + "." + loginId.toString());
    // 返回此 loginId 拥有的权限列表
    if (StringUtils.isEmpty(permission)) {
      return Collections.emptyList();
    }
    List<String> permissionList = new ArrayList<>();
    permissionList.add(permission);
    return permissionList;
  }

  @Override
  public List<String> getRoleList(Object loginId, String loginType) {
    // 返回此 loginId 拥有的角色列表
    String role = (String) redisTemplate.opsForValue().get(authRolePrefix + "." + loginId.toString());
    // 返回此 loginId 拥有的权限列表
    if (StringUtils.isEmpty(role)) {
      return Collections.emptyList();
    }
    List<String> roleList = new ArrayList<>();
    roleList.add(role);
    return roleList;
  }

}
