package com.silagedik.todo_project.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface ITodoServices<D, E> {

    // Model Mapper
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // C R U D
    // CREATE
    public D todoServiceCreate(D d);

    // LIST
    public List<D> todoServiceList();

    // FIND BY
    public D todoServiceFindById(Long id);

    // FIND BY DONE
    //public List<D> todoServiceFindByDone(boolean done);

    // UPDATE
    public D todoServiceUpdate(Long id,D d);

    // DELETE
    public D todoServiceDeleteById(Long id);
}