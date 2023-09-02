package com.silagedik.todo_project.business.services.impl;

import com.silagedik.todo_project.bean.ModelMapperBean;
import com.silagedik.todo_project.business.dto.TodoDto;
import com.silagedik.todo_project.business.services.ITodoServices;
import com.silagedik.todo_project.data.entity.TodoEntity;
import com.silagedik.todo_project.data.repository.ITodoRepository;
import com.silagedik.todo_project.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class TodoServicesImpl implements ITodoServices<TodoDto, TodoEntity> {

    private final ITodoRepository iTodoRepository;
    private final ModelMapperBean modelMapperBean;

    @Override
    public TodoDto entityToDto(TodoEntity todoEntity) {
        return modelMapperBean.modelMapperMethod().map(todoEntity, TodoDto.class);
    }

    @Override
    public TodoEntity dtoToEntity(TodoDto todoDto) {
        return modelMapperBean.modelMapperMethod().map(todoDto, TodoEntity.class);
    }

    @Override
    @Transactional
    public TodoDto todoServiceCreate(TodoDto todoDto) {
        if (todoDto != null) {
            TodoEntity todoEntity = dtoToEntity(todoDto);
            iTodoRepository.save(todoEntity);
            todoDto.setId(todoEntity.getTodoId());
            todoDto.setCreatedDate(todoEntity.getCreatedDate());
        } else {
            throw new NullPointerException("todoDto is null");
        }
        return todoDto;
    }

    @Override
    public List<TodoDto> todoServiceList() {
        Iterable<TodoEntity> entityIterable = iTodoRepository.findAll();
        List<TodoDto> todoDtoList = new ArrayList<>();
        for (TodoEntity entity : entityIterable) {
            TodoDto todoDto = entityToDto(entity);
            todoDtoList.add(todoDto);
        }
        log.info("List Size: " + todoDtoList.size());
        return todoDtoList;
    }

    @Override
    public TodoDto todoServiceFindById(Long id) {
        TodoEntity findTodoEntity = iTodoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + " does not exist"));
        return entityToDto(findTodoEntity);
    }

    @Override
    @Transactional
    public TodoDto todoServiceUpdate(Long id, TodoDto todoDto) {
        TodoDto todoFindDto = todoServiceFindById(id);
        if (todoFindDto != null) {
            TodoEntity todoEntity = dtoToEntity(todoFindDto);
           // todoEntity.getTodoEntityEmbeddable().setTodoContent(todoDto.getTodoContent());
            todoEntity.setTodoContent(todoDto.getTodoContent());
            todoEntity.getTodoEntityEmbeddable().setDone(todoDto.isDone());
            iTodoRepository.save(todoEntity);
        }
        return todoDto;
    }

    @Override
    @Transactional
    public TodoDto todoServiceDeleteById(Long id) {
        TodoDto todoFindDto = todoServiceFindById(id);
        if (todoFindDto != null) {
            iTodoRepository.deleteById(id);
        }
        return todoFindDto;
    }
}