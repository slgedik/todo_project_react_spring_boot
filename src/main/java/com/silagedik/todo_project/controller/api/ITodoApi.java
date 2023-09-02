package com.silagedik.todo_project.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITodoApi<D> {

    // C R U D
    // CREATE
    public ResponseEntity<?>  todoApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>>  todoApiList();


    // UPDATE
    public ResponseEntity<?>  todoApiUpdate(Long id,D d);

    // DELETE
    public ResponseEntity<?>  todoApiDeleteById(Long id);

    //////////////////////////////////////
    // ALL DELETE
    public ResponseEntity<String> todoApiAllDelete();

    // SPEED DATA
   // public ResponseEntity<List<D>> todoApiSpeedData(Long key);
}