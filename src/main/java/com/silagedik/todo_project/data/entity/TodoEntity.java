package com.silagedik.todo_project.data.entity;



import com.silagedik.todo_project.auditing.AuditingAwareBaseEntity;
import com.silagedik.todo_project.data.TodoEntityEmbeddable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@Log4j2

// ENTITY
@Entity
@Table(name = "todos")
// Blog(N)  Category(1)
public class TodoEntity extends AuditingAwareBaseEntity implements Serializable {

    // serileştirme
    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="todo_id",unique = true,nullable = false,insertable = true,updatable = false)
    private Long todoId;


    // Embedded
    @Embedded
    private TodoEntityEmbeddable todoEntityEmbeddable=new TodoEntityEmbeddable();


    // Constructor (Parametresiz)
    public TodoEntity() {

    }

    // Constructor (Parametreli)
    public TodoEntity(TodoEntityEmbeddable todoEntityEmbeddable) {
        this.todoEntityEmbeddable = todoEntityEmbeddable;
    }


} //end class
