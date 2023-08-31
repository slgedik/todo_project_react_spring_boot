package com.silagedik.todo_project.data.repository;


import com.silagedik.todo_project.data.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepository extends JpaRepository<TodoEntity, Long> {
}
