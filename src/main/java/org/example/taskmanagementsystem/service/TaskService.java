package org.example.taskmanagementsystem.service;

import org.example.taskmanagementsystem.dtos.TaskDto;
import org.example.taskmanagementsystem.models.Task;
import org.example.taskmanagementsystem.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService  implements TaskServiceInterface{

    @Autowired
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task createTask(TaskDto taskDto) {
        //create a new task object
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setDueDate(taskDto.getDueDate());
        task.setPriority(taskDto.getPriority());
       // task.setUserId(taskDto.getUserId());

        //set the created at and updated at date
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());




        //save the task to the database using the repository
        return taskRepository.save(task);



    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task updatedTask, Long id) {
        //get the task by id from the database using the repository
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("task not found"));

        //update the task with the new values
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());
        task.setPriority(updatedTask.getPriority());
       // task.setUserId(updatedTask.getUserId());
        task.setUpdatedAt(LocalDateTime.now());


        //save the updated task to the database using the repository
        taskRepository.save(task);

        return task;
    }

    @Override
    public void deleteTask(Long id) {
        //get the task by id from the database using the repository
       Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("task not found"));

        //delete the task from the database using the repository
        taskRepository.delete(task);

        //taskRepository.deleteById(id);

    }

//    @Override
//    public List<Task> searchTask(String title) {
//        return taskRepository.findByTitle(title);
//    }
//
//
//    @Override
//    public List<Task> searchTaskByStatus(String status) {
//        return taskRepository.findByStatus(status);
//    }
//
//    @Override
//    public List<Task> searchTaskByPriority(String priority) {
//        return taskRepository.findByPriority(priority);
//    }
//
//    @Override
//    public List<Task> searchTaskByDueDate(LocalDate dueDate) {
//        return taskRepository.findByDueDate(dueDate);
//    }
//
//    @Override
//    public List<Task> searchTaskByDescription(String description) {
//        return taskRepository.findByDescription(description);
//    }


}
