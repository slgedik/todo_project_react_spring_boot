package com.silagedik.todo_project.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter

@Embeddable
public class TodoEntityEmbeddable {


    @Column(name = "done", nullable = false, columnDefinition = "boolean default false")
    private boolean done;

}


