package com.example.template.annotation;

import com.example.template.SpringBootTemplateApplication;
import com.example.template.config.db.PostgresSqlContainerConfig;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = {
        SpringBootTemplateApplication.class,
        PostgresSqlContainerConfig.class,
})
public @interface MainTestTemplate {
}
