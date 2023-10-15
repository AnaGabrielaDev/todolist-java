package br.com.anagabriela.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping()
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        taskModel.setUserId((UUID) request.getAttribute("userId"));

        var currentDate = LocalDateTime.now();
        if (currentDate.now().isAfter(taskModel.getStartAt()) || currentDate.now().isAfter(taskModel.getFinishedAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("startedAt and finishedAt must be after today");
        }

        TaskModel task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(200).body(task);
    }
}
