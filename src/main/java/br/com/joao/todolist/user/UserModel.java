package br.com.joao.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "users_tb")
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    // @Column(name = "pipipopo") - If you wanna change the column name in database
    
    @Column(unique = true)
    private String name;
    private String username;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
