package br.com.joao.todolist.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskSerivice;

    @PostMapping
    public ResponseEntity<Object> createTask(@RequestBody TaskModel task){
        return ResponseEntity.status(200).body(this.taskSerivice.create(task)); 
    }
}
