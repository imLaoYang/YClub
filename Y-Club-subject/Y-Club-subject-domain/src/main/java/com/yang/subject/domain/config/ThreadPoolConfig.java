package com.yang.subject.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池配置
 */
@Configuration
public class ThreadPoolConfig {

  /**
   * 题目标签线程池
   * @return
   */
  @Bean("labelThreadPool")
  public ThreadPoolExecutor getLabelThreadPool() {
    return new ThreadPoolExecutor(20, 100, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>(40), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
  }

}
