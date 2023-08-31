package com.silagedik.todo_project.data.repository;


import com.silagedik.todo_project.data.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends JpaRepository<TodoEntity, Long> {
    // Özel sorguları burada tanımlayabilirsiniz, örneğin:
    // List<TaskEntity> findByDone(boolean done);
}
