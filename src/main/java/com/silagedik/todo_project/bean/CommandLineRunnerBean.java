package com.silagedik.todo_project.bean;

import com.silagedik.todo_project.data.TodoEntityEmbeddable;
import com.silagedik.todo_project.data.entity.TodoEntity;
import com.silagedik.todo_project.data.repository.ITodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Scanner;

//lombok
@RequiredArgsConstructor
@Configuration
@Log4j2
@Component
public class CommandLineRunnerBean {

    private final ITodoRepository iTodoRepository;


    public TodoEntity createTodo(String todoContent) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.getTodoEntityEmbeddable().setTodoContent(todoContent);
        todoEntity.getTodoEntityEmbeddable().setDone(false);
        iTodoRepository.save(todoEntity);
        return todoEntity;
    }



    public void createRandomTasks(int count) {
        for (int i = 0; i < count; i++) {
            createTodo("Task " + (i + 1));
        }
    }

    @Bean
    public CommandLineRunner todoCommandLineRunnerMethod() {
        return args -> {
            System.out.println("CommandLineRunner Çalıştı");
            log.info("CommandLineRunner Çalıştı");

            //createRandomTasks(5);
        };
    }
}