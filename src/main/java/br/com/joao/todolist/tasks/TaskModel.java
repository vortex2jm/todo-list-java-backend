package br.com.joao.todolist.tasks;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

enum Priority {
    LOW, MEDIUM, HIGH;
}

@Data
@Entity(name = "tasks_tb")
public class TaskModel {    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(length = 50)
    private String title;

    private String task;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private UUID userId;
}
