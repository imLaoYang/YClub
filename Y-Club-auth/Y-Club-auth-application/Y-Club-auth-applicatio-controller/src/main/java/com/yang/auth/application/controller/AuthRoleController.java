package com.yang.auth.application.controller;

import com.google.common.base.Preconditions;
import com.yang.auth.application.convert.AuthRoleDTOConvert;
import com.yang.auth.application.entity.AuthRoleDTO;
import com.yang.auth.infra.entity.AuthRole;
import com.yang.auth.infra.service.AuthRoleService;
import com.yang.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
@Slf4j
public class AuthRoleController {

  @Autowired
  private AuthRoleService authRoleService;

  /**
   * 新增角色
   * @param authRoleDTO
   * @return
   */
  @PostMapping("add")
  public Result add(@RequestBody AuthRoleDTO authRoleDTO){
    try {
      Preconditions.checkNotNull(authRoleDTO.getRoleName(), "角色名不能为空");
      Preconditions.checkNotNull(authRoleDTO.getRoleKey(), "roleKey不能为空");
      AuthRole authUser = AuthRoleDTOConvert.INSTANCE.toAuthUser(authRoleDTO);
      return Result.ok(authRoleService.addRole(authUser));
    } catch (Exception e) {
      log.info("新增角色异常{}", e.getMessage(), e);
      return Result.fail("新增角色失败");
    }
  }


  /**
   * 更新角色
   * @param authRoleDTO
   * @return
   */
  @PostMapping("update")
  public Result update(@RequestBody AuthRoleDTO authRoleDTO){
    try {

      Preconditions.checkNotNull(authRoleDTO.getRoleName(), "角色名不能为空");
      Preconditions.checkNotNull(authRoleDTO.getId(), "角色ID不能为空");
      Preconditions.checkNotNull(authRoleDTO.getRoleKey(), "roleKey不能为空");
      AuthRole authUser = AuthRoleDTOConvert.INSTANCE.toAuthUser(authRoleDTO);
      return Result.ok(authRoleService.updateRole(authUser));
    } catch (Exception e) {
      log.info("更新角色异常{}", e.getMessage(), e);
      return Result.fail("更新角色失败");
    }
  }


  /**
   * delete
   * @param authRoleDTO
   * @return
   */
  @PostMapping("delete")
  public Result delete(@RequestBody AuthRoleDTO authRoleDTO){
    try {
      Preconditions.checkNotNull(authRoleDTO.getId(), "角色ID不能为空");
      AuthRole authUser = AuthRoleDTOConvert.INSTANCE.toAuthUser(authRoleDTO);
      return Result.ok(authRoleService.deleteRole(authUser));
    } catch (Exception e) {
      log.info("删除角色异常{}", e.getMessage(), e);
      return Result.fail("删除角色失败");
    }
  }





}
