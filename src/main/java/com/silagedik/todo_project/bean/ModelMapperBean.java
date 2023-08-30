package com.silagedik.todo_project.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
@Configuration //spring gelip bu configurationa bakıyor. Configuration bean'e bakıyor
public class ModelMapperBean {

    @Bean //Spring Core => class içindeki methodun spring tarafında tanınmasını sağlar
    public ModelMapper modelMapperMethod(){
        return new ModelMapper();
    }
}
