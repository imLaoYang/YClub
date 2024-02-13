package com.yang.auth.application.controller;

import com.google.common.base.Preconditions;
import com.yang.auth.application.convert.AuthUserDTOConvert;
import com.yang.auth.application.entity.AuthUserDTO;
import com.yang.auth.infra.entity.AuthUser;
import com.yang.auth.infra.service.AuthUserService;
import com.yang.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 */
@RestController
@RequestMapping("user")
@Slf4j
public class AuthUserController {

  @Resource
  private AuthUserService authUserService;

  /**
   * 登录
   *
   * @return
   */
  @PostMapping("doLogin")
  public Result doLogin() {
    return null;
  }


  /**
   * 注册
   *
   * @return
   */
  @PostMapping("register")
  public Result register(@RequestBody AuthUserDTO authUserDTO) {
    try {
      Preconditions.checkNotNull(authUserDTO.getUserName(), "用户名不能为空");
      Preconditions.checkNotNull(authUserDTO.getPassword(), "密码不能为空");
      Preconditions.checkNotNull(authUserDTO.getEmail(), "邮箱不能为空");
      AuthUser authUser = AuthUserDTOConvert.INSTANCE.toAuthUser(authUserDTO);
      return Result.ok(authUserService.register(authUser));
    } catch (Exception e) {
      log.info("注册失败{}", e.getMessage(), e);
      return Result.fail("注册失败");
    }
  }

  /**
   * 更新
   *
   * @return
   */
  @PostMapping("update")
  public Result update(@RequestBody AuthUserDTO authUserDTO) {
    try {
      AuthUser authUser = AuthUserDTOConvert.INSTANCE.toAuthUser(authUserDTO);
      return Result.ok(authUserService.updateUser(authUser));
    } catch (Exception e) {
      log.info("更新用户失败{}", e.getMessage(), e);
      return Result.fail("更新用户失败");
    }
  }

  /**
   * 删除用户
   *
   * @return
   */
  @PostMapping("delete")
  public Result delete(@RequestBody AuthUserDTO authUserDTO) {
    try {
      Preconditions.checkNotNull(authUserDTO.getId(), "用户Id不能为空");
      AuthUser authUser = AuthUserDTOConvert.INSTANCE.toAuthUser(authUserDTO);
      return Result.ok(authUserService.deleteUser(authUser));
    } catch (Exception e) {
      log.info("删除用户失败{}", e.getMessage(), e);
      return Result.fail("删除用户失败");
    }
  }


  /**
   * 用户启用/禁用
   *
   * @return
   */
  @PostMapping("changeStatus")
  public Result changeStatus(@RequestBody AuthUserDTO authUserDTO) {
    try {
      Preconditions.checkNotNull(authUserDTO.getId(), "用户Id不能为空");
      Preconditions.checkNotNull(authUserDTO.getStatus(), "用户状态不能为空");
      AuthUser authUser = AuthUserDTOConvert.INSTANCE.toAuthUser(authUserDTO);
      return Result.ok(authUserService.changeStatus(authUser));
    } catch (Exception e) {
      log.info("用户启用/禁用失败{}", e.getMessage(), e);
      return Result.fail("用户启用/禁用失败");
    }
  }


  /**
   * 个人信息查询
   *
   * @return
   */
  @PostMapping("getUserInfo")
  public Result getUserInfo(@RequestBody AuthUserDTO authUserDTO) {
    try {
      Preconditions.checkNotNull(authUserDTO.getUserName(), "用户名不能为空");
      AuthUser authUser = AuthUserDTOConvert.INSTANCE.toAuthUser(authUserDTO);
      AuthUser user = authUserService.getUserInfo(authUser);
      AuthUserDTO result = AuthUserDTOConvert.INSTANCE.toAuthUserDTO(user);
      return Result.ok(result);
    } catch (Exception e) {
      log.info("个人信息查询异常{}", e.getMessage(), e);
      return Result.fail("未查询到相关用户");
    }
  }


}
