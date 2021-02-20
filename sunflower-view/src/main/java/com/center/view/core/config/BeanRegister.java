package com.center.view.core.config;

import com.center.common.mapper.IBeanConverter;
import com.center.common.mapper.impl.BeanConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanRegister {

    @Bean
    public IBeanConverter beanConverter() {
        return new BeanConverter();
    }

    /*@Bean
    public Validator validator() {

        *//*ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();*//*

     *//*ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();*//*
        return validator;
    }*/


}
