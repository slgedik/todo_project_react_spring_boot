package com.silagedik.todo_project.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
@Configuration
@Log4j2
public class CommandLineRunnerBean {
    public CommandLineRunner commandLineRunnerMethod(){
        return args->{
            log.info("Data set oluşturuldu");
        }; // end return
    } // end CommandLineRunnerBean method
}
