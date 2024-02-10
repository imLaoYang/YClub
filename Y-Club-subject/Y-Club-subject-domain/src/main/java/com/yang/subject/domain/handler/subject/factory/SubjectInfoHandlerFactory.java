package com.yang.subject.domain.handler.subject.factory;

import com.yang.subject.common.enums.SubjectInfoType;
import com.yang.subject.domain.handler.subject.SubjectInfoTypeHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型策略类工厂
 */
@Component
public class SubjectInfoHandlerFactory implements BeanPostProcessor {

  @Resource
  private List<SubjectInfoTypeHandler> list;

  private Map<SubjectInfoType,SubjectInfoTypeHandler> handlerMap = new HashMap<>();

  /**
   * 拿到具体题目类型策略类
   * @return
   */
  public SubjectInfoTypeHandler getHandler(int type){
    SubjectInfoType subjectInfoType = SubjectInfoType.getByCode(type);
    return handlerMap.get(subjectInfoType);

  }


  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    for (SubjectInfoTypeHandler subjectInfoTypeHandler : list) {
      handlerMap.put(subjectInfoTypeHandler.getSubjectInfoType(),subjectInfoTypeHandler);
    }
    return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
  }
}
