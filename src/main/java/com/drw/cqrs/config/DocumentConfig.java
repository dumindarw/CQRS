package com.drw.cqrs.config;

import com.drw.cqrs.registry.DocumentServiceFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentConfig {

    @Bean(name = "documentServiceFactory")
    public FactoryBean<?> factoryBean(){
        final ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(DocumentServiceFactory.class);
        return bean;
    }

    @Bean
    public Object documentFactory() throws Exception {
        return factoryBean().getObject();
    }
}
