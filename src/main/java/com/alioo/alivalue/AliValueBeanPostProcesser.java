package com.alioo.alivalue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Component
public class AliValueBeanPostProcesser implements BeanPostProcessor {

    private static Logger logger = LoggerFactory.getLogger(AliValueBeanPostProcesser.class);

    @Autowired
    private PropertiesUtil propertiesUtil;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("before... bean=" + bean + ",beanName=" + beanName);

        evaluation(bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("after... bean=" + bean + ",beanName=" + beanName);

        return bean;
    }


    public boolean evaluation(Object bean) {
        List<Field> list = Arrays.asList(bean.getClass().getDeclaredFields());
        for (int i = 0; i < list.size(); i++) {
            Field field = list.get(i);

            AliValue aliValue = field.getAnnotation(AliValue.class); //获取指定类型注解
            if (aliValue == null) {
                continue;
            }

            String annovalue = aliValue.value();
            String realvalue = propertiesUtil.getString(annovalue);
            logger.info("find a bean need alivalue annotation annovalue=" + annovalue + ",realvalue=" + realvalue);

            doEvaluation(bean,field,realvalue);

        }
        return true;
    }

    public void doEvaluation(Object bean,Field field,String realvalue){
        field.setAccessible(true);
        try {
            field.set(bean,realvalue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
