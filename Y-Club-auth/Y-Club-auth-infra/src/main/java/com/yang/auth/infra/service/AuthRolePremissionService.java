package com.yang.auth.infra.service;

import com.yang.auth.infra.entity.AuthRolePremission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Yang
* @description 针对表【auth_role_premission】的数据库操作Service
* @createDate 2024-02-10 20:47:34
*/
public interface AuthRolePremissionService extends IService<AuthRolePremission> {

  Boolean addRolePermission(List<AuthRolePremission> list);
}
