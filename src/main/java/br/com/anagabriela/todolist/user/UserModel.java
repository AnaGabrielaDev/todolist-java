package br.com.anagabriela.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "users") // entidade cria no banco de dados
@Data // lombok add getters and setter to Model
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true)
    private String name;

    private String username;

    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
