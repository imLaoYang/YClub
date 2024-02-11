package com.yang.auth.application.controller;

import com.yang.subject.common.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("user")
public class AuthUserController {
  /**
   * 登录
   * @return
   */
  @PostMapping("doLogin")
  public Result doLogin() {
    return null;
  }


  /**
   * 注册
   * @return
   */
  @PostMapping("register")
  public Result register() {
    return null;
  }

  /**
   * 退出登录
   * @return
   */
  @PostMapping("logout")
  public Result logout() {
    return null;
  }




}
