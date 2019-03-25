package com.eomcs.lms.context;
import java.lang.reflect.Method;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;


@Component
public class RequestMappingAnnotationBeanPostProcessor implements BeanPostProcessor{

  RequestMappingHandlerMapping handlerMapping;

  public RequestMappingAnnotationBeanPostProcessor(
      RequestMappingHandlerMapping handlerMapping) {
    this.handlerMapping = handlerMapping;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

    Method[] methods = bean.getClass().getMethods();
    
    for (Method m : methods) {
      RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
      if (requestMapping == null) 
        continue;

      RequestMappingHandler handler = new RequestMappingHandler(bean, m);

      handlerMapping.add(requestMapping.value(), handler);
    }

    return bean;
  }
}
