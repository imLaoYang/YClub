package com.yang.subject.starter;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yang")
@MapperScan("com.yang.**.mapper")
public class SubjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(SubjectApplication.class);

  }
}
