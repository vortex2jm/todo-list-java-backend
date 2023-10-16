package br.com.joao.todolist.tasks.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.todolist.tasks.TaskModel;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID>{}
