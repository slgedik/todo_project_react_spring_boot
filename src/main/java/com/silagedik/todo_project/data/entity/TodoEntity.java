package com.silagedik.todo_project.data.entity;



//import com.silagedik.data.BlogEntityEmbeddable;
import com.silagedik.todo_project.auditing.AuditingAwareBaseEntity;
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

    // Content of the Todo
    @Column(name = "content", nullable = false)
    private String todoContent;

    // Status of the Todo (Done or Not Done)
    @Column(name = "done", nullable = false)
    private boolean done;
    // Embedded
    /*@Embedded
    private BlogEntityEmbeddable blogEntityEmbeddable=new BlogEntityEmbeddable();*/


    // Constructor (Parametresiz)
    public TodoEntity() {
    }

    // Constructor (Parametreli)
    public TodoEntity(String todoContent, boolean done) {
        this.todoContent = todoContent;
        this.done = done;
    }

    // Constructor (Parametreli)
   /*public BlogEntity(BlogEntityEmbeddable blogEntityEmbeddable, CategoryEntity relationCategoryEntity) {
        this.blogEntityEmbeddable = blogEntityEmbeddable;
        this.relationCategoryEntity = relationCategoryEntity;
    }*/
} //end class
