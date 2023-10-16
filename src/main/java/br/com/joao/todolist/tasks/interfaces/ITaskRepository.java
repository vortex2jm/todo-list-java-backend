package br.com.joao.todolist.tasks.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.todolist.tasks.TaskModel;
import java.util.List;


public interface ITaskRepository extends JpaRepository<TaskModel, UUID>{
    List<TaskModel> findByUserId(UUID userId);
}
