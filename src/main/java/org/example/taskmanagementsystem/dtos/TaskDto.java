package org.example.taskmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.taskmanagementsystem.models.Priority;
import org.example.taskmanagementsystem.models.TaskStatus;
import org.example.taskmanagementsystem.models.User;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class TaskDto {
    //private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private LocalDate dueDate;
    private Long userId;



}
