package org.example.taskmanagementsystem.repositories;

import org.example.taskmanagementsystem.dtos.TaskDto;
import org.example.taskmanagementsystem.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task save(Task task);

    List<Task> findAll();




//    List<Task> findByStatus(String status);
//
//    List<Task> findByPriority(String priority);
//
//    List<Task> findByDueDate(LocalDate dueDate);
//
//
//    List<Task> findByTitle(String title);
//
//    List<Task> findByDescription(String description);

}
