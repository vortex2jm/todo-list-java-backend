package br.com.joao.todolist.tasks;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskSerivice;

    @PostMapping("/")
    public ResponseEntity<Object> createTask(@RequestBody  TaskDto taskDto, HttpServletRequest request){
        var task = new TaskModel();
        BeanUtils.copyProperties(taskDto, task);
        task.setUserId((UUID)request.getAttribute("userId"));        
        return ResponseEntity.status(200).body(this.taskSerivice.create(task)); 
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskModel>> getOwnTasks(HttpServletRequest request){        
        var foundTasks = this.taskSerivice.find((UUID)request.getAttribute("userId")); 
        return ResponseEntity.status(200).body(foundTasks);
    }

    // TODO============================================
    // Update method with verifications and validations
    // Mix request body with saved user in database
    // *The user can modify only your tasks*
    // Take care about the title lenght
    // Add exception handlers in all layers
    // Add Dto layer to User Domain
}
