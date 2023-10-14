package br.com.anagabriela.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.anagabriela.todolist.user.UserModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tasks")
@Data
public class TaskModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private UUID userId;

    private String description;

    @Column(length = 30)
    private String title;

    private String priority;

    private LocalDateTime startAt;

    private LocalDateTime fishedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
