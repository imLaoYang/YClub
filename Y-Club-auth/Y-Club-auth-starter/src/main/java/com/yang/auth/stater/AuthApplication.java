package com.yang.auth.stater;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yang")
@MapperScan("com.yang.**.mapper")
public class AuthApplication {
  public static void main(String[] args) {
    SpringApplication.run(AuthApplication.class);
    System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
  }

}
