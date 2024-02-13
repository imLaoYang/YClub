package com.yang.auth.application.controller;


import com.google.common.base.Preconditions;
import com.yang.auth.application.convert.AuthPermissionDTOConvert;
import com.yang.auth.application.entity.AuthPermissionDTO;
import com.yang.auth.application.entity.AuthRolePermissionDTO;
import com.yang.auth.infra.entity.AuthPermission;
import com.yang.auth.infra.entity.AuthRolePremission;
import com.yang.auth.infra.service.AuthPermissionService;
import com.yang.auth.infra.service.AuthRolePremissionService;
import com.yang.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限模块
 */
@RestController
@RequestMapping("permission")
@Slf4j
public class AUthPermissionController {

  @Resource
  private AuthPermissionService authPermissionService;

  @Resource
  private AuthRolePremissionService authRolePremissionService;

  /**
   * 新增权限
   *
   * @return
   */
  @PostMapping("add")
  public Result addPermission(@RequestBody AuthPermissionDTO authPermissionDTO) {
    try {
      Preconditions.checkNotNull(authPermissionDTO.getPermissionKey(), "PermissionKey不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getName(), "name不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getMenuUrl(), "enuUrl不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getType(), "Type不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getStatus(), "Status不能为空");

      AuthPermission authPermission = AuthPermissionDTOConvert.INSTANCE.toAuthPermission(authPermissionDTO);
      Boolean result = authPermissionService.addPermission(authPermission);
      return Result.ok(result);
    } catch (Exception e) {
      if (log.isInfoEnabled()) {
        log.info("{}", e.getMessage(), e);
      }
      return Result.fail("新增权限失败");
    }

  }

  /**
   * 新增角色权限
   *
   * @return
   */
  @PostMapping("add")
  public Result addRolePermission(@RequestBody AuthRolePermissionDTO authRolePermissionDTO) {
    try {
      Preconditions.checkNotNull(authRolePermissionDTO.getRoleId(), "角色ID不能为空");
      Preconditions.checkNotNull(authRolePermissionDTO.getPermissionIdList(), "权限ID不能为空");
      List<AuthRolePremission> authRolePremissionList = authRolePermissionDTO.getPermissionIdList().stream().map(permissionId -> {
        AuthRolePremission authRolePremission = new AuthRolePremission();
        authRolePremission.setRoleId(authRolePermissionDTO.getRoleId());
        authRolePremission.setPermissionId(permissionId);
        return authRolePremission;
      }).collect(Collectors.toList());

      return Result.ok(authRolePremissionService.addRolePermission(authRolePremissionList));
    } catch (Exception e) {
      if (log.isInfoEnabled()) {
        log.info("{}", e.getMessage(), e);
      }
      return Result.fail();
    }

  }


  /**
   * 更新权限
   *
   * @return
   */
  @PostMapping("update")
  public Result update(@RequestBody AuthPermissionDTO authPermissionDTO) {
    try {
      Preconditions.checkNotNull(authPermissionDTO.getId(), "ID不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getPermissionKey(), "PermissionKey不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getName(), "name不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getMenuUrl(), "enuUrl不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getType(), "Type不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getStatus(), "Status不能为空");

      AuthPermission authPermission = AuthPermissionDTOConvert.INSTANCE.toAuthPermission(authPermissionDTO);
      Boolean result = authPermissionService.updatePermission(authPermission);
      return Result.ok(result);
    } catch (Exception e) {
      if (log.isInfoEnabled()) {
        log.info("{}", e.getMessage(), e);
      }
      return Result.fail();
    }

  }

  /**
   * 启用/禁用权限
   *
   * @return
   */
  @PostMapping("update")
  public Result status(@RequestBody AuthPermissionDTO authPermissionDTO) {
    try {
      Preconditions.checkNotNull(authPermissionDTO.getId(), "ID不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getStatus(), "Status不能为空");
      AuthPermission authPermission = AuthPermissionDTOConvert.INSTANCE.toAuthPermission(authPermissionDTO);
      Boolean result = authPermissionService.status(authPermission);
      return Result.ok(result);
    } catch (Exception e) {
      if (log.isInfoEnabled()) {
        log.info("{}", e.getMessage(), e);
      }
      return Result.fail();
    }
  }

  /**
   * 展示/不展示权限
   *
   * @return
   */
  @PostMapping("update")
  public Result show(@RequestBody AuthPermissionDTO authPermissionDTO) {
    try {
      Preconditions.checkNotNull(authPermissionDTO.getId(), "ID不能为空");
      Preconditions.checkNotNull(authPermissionDTO.getShow(), "show不能为空");
      AuthPermission authPermission = AuthPermissionDTOConvert.INSTANCE.toAuthPermission(authPermissionDTO);
      Boolean result = authPermissionService.show(authPermission);
      return Result.ok(result);
    } catch (Exception e) {
      if (log.isInfoEnabled()) {
        log.info("{}", e.getMessage(), e);
      }
      return Result.fail();
    }
  }

  /**
   * 删除权限
   *
   * @return
   */
  @PostMapping("delete")
  public Result delete(@RequestBody AuthPermissionDTO authPermissionDTO) {
    try {
      Preconditions.checkNotNull(authPermissionDTO.getId(), "ID不能为空");
      AuthPermission authPermission = AuthPermissionDTOConvert.INSTANCE.toAuthPermission(authPermissionDTO);
      Boolean result = authPermissionService.deletePermission(authPermission);
      return Result.ok(result);
    } catch (Exception e) {
      if (log.isInfoEnabled()) {
        log.info("{}", e.getMessage(), e);
      }
      return Result.fail();
    }
  }


}
