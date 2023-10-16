package br.com.joao.todolist.tasks;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.todolist.tasks.interfaces.ITaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private ITaskRepository taskRepo;

    public TaskModel create(TaskModel task){
        return this.taskRepo.save(task);
    }
    public List<TaskModel> find(UUID userId){
        return this.taskRepo.findByUserId(userId);
    }
}
