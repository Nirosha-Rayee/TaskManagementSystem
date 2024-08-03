package org.example.taskmanagementsystem.service;

import org.example.taskmanagementsystem.dtos.TaskDto;
import org.example.taskmanagementsystem.models.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskServiceInterface {
   Task createTask(TaskDto taskDto);
   List<Task> getAllTasks();
   Task updateTask(Task task, Long id);
   void deleteTask(Long id);

//   List<Task> searchTask(String title );
//
//   List<Task> searchTaskByStatus(String status);
//
//   List<Task> searchTaskByPriority(String priority);
//
//   List<Task> searchTaskByDueDate(LocalDate dueDate);
//
//   List<Task> searchTaskByDescription(String description);

}
