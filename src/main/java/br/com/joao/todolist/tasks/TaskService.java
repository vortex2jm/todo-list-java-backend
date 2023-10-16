package br.com.joao.todolist.tasks;

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
}
