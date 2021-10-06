package com.lyd.learnspringboot;

import com.lyd.demo.controller.SampleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
/*
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScans
*/

@SpringBootApplication //一个顶上面三个
public class LearnSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory =new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.parse("10240KB"));
        factory.setMaxRequestSize(DataSize.parse("1024000KB"));
        return factory.createMultipartConfig();
    }
}
