package com.yang.gateway.auth;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Sa-Token 权限认证] 配置类
 */
@Configuration
public class SaTokenConfigure {
  // 注册 Sa-Token全局过滤器
  @Bean
  public SaReactorFilter getSaReactorFilter() {
    return new SaReactorFilter()
            // 拦截地址 
            .addInclude("/**")    /* 拦截全部path */
            // 开放地址 
            .addExclude("/favicon.ico")
            // 鉴权方法：每次访问进入 
            .setAuth(obj -> {
              // System.out.println("-------- 前端访问path：" + SaHolder.getRequest().getRequestPath());
              // 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
              SaRouter.match("/**", "auth/user/doLogin", r -> StpUtil.checkLogin());

              // 权限认证 -- 不同模块, 校验不同权限
              SaRouter.match("auth/user/**", r -> StpUtil.checkPermission("user"));
              SaRouter.match("subject/subject/**", r -> StpUtil.checkLogin());
              SaRouter.match("subject/subject/add", r -> StpUtil.checkPermission("add"));
            });

  }
}
