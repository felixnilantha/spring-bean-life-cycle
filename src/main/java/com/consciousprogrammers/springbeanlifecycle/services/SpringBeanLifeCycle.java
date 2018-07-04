package com.consciousprogrammers.springbeanlifecycle.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBeanLifeCycle implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean : " + name + " is set " );
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Property has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context has been set");
    }

    @PostConstruct
    public void preConstruct(){
        System.out.println("@PostConstruct activated");
    }

    @PreDestroy
    public void postConstruct(){
        System.out.println("@PreDestroy activated");
    }

    public void beforeInit(){
        System.out.println("Before Init - Post Processor");
    }
    public void afterInit(){
        System.out.println("After Init - Post Processor");
    }
}
