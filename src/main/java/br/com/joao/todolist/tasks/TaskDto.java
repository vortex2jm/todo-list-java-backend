package br.com.joao.todolist.tasks;

import lombok.Data;

@Data
public class TaskDto {
    
    private String title;

    private String task;

    private Priority priority;
}
