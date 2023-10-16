package br.com.joao.todolist.user.interfaces;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.todolist.user.UserModel;

public interface IUSerRepository extends JpaRepository<UserModel, UUID>{
    UserModel findByUsername(String username);
}
