package com.yang.subject.application.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * mvc全局配置
 */
@Configuration
public class GlobalConfig extends WebMvcConfigurationSupport {

  @Override
  protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    super.configureMessageConverters(converters);
    converters.add(httpMessageConverter());
  }

  private MappingJackson2HttpMessageConverter httpMessageConverter(){
    ObjectMapper objectMapper = new ObjectMapper();
    // 允许返回空的list
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
    // 返回值为null时不显示
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return new MappingJackson2HttpMessageConverter(objectMapper);


  }

}
