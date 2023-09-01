
package com.silagedik.todo_project.controller.api.impl;

        import com.silagedik.todo_project.business.dto.TodoDto;
        import com.silagedik.todo_project.business.services.ITodoServices;
        import com.silagedik.todo_project.controller.api.ITodoApi;
        import jakarta.validation.Valid;
        import lombok.RequiredArgsConstructor;
        import lombok.extern.log4j.Log4j2;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/todo/api/v1")
public class TodoApiImpl implements ITodoApi<TodoDto> {

    private final ITodoServices iTodoServices;

    //CREATE
    // http://localhost:4444/todo/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> todoApiCreate(@Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(iTodoServices.todoServiceCreate(todoDto));

    }


    @Override
    @GetMapping("/list")
    public ResponseEntity<List<TodoDto>> todoApiList() {
        return ResponseEntity.status(HttpStatus.OK).body(iTodoServices.todoServiceList());
    }

    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<?> todoApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iTodoServices.todoServiceFindById(id));
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<?> todoApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(iTodoServices.todoServiceUpdate(id, todoDto));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> todoApiDeleteById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(iTodoServices.todoServiceDeleteById(id), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/all")
    public ResponseEntity<String> todoApiAllDelete() {
        // Tüm verileri silme işlemini burada gerçekleştirin
        return ResponseEntity.ok("All data deleted.");
    }

   /* @Override
    public ResponseEntity<List<TodoDto>> todoApiSpeedData(Long key) {
        return null; // Daha sonra doldurabilirsiniz.
    }*/
}

