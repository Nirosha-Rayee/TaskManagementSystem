package org.example.taskmanagementsystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanagementsystem.dtos.TaskDto;
import org.example.taskmanagementsystem.models.Task;

import org.example.taskmanagementsystem.service.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")

@Tag(
        name = "CRUD REST APIs for Task Resource"
)
public class TaskController {

@Autowired
TaskServiceInterface taskService;

public TaskController(TaskServiceInterface taskService) {
    this.taskService = taskService;
}

    @Operation(
            summary = "Create Task REST API",
            description = "Create Task REST API is used to save Task into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )

    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
@PostMapping("/create")
public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
    return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);


}

    @Operation(
            summary = "Update Task REST API",
            description = "Create Task REST API is used to save task into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )

    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")


@PutMapping("/update/{id}")
public ResponseEntity<Task> updateTask(@RequestBody Task updatedTask, @PathVariable(name = "id") Long id) {
    return new ResponseEntity<>(taskService.updateTask(updatedTask, id), HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Task REST API",
            description = "Delete Task REST API is used to save task into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )

    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteTask(@PathVariable(name = "id") Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);

}
    @Operation(
            summary = "Get All Tasks REST API",
            description = "Get All Tasks REST API is used to fetch all the tasks from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )

@GetMapping("/all")
public ResponseEntity<List<Task>> getAllTasks() {
    return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
}


////search by title or description
//@GetMapping("/searchByTitle")
//public ResponseEntity<List<Task>> searchTask(@RequestParam String title) {
//    return new ResponseEntity<>(taskService.searchTask(title), HttpStatus.OK);
//}
//
//@GetMapping("/searchByDescription")
//public ResponseEntity<List<Task>> searchTaskByDescription(@RequestParam String description) {
//    return new ResponseEntity<>(taskService.searchTaskByDescription(description), HttpStatus.OK);
//}
//
////search by status, priority, due date
//@GetMapping("/searchByStatus")
//public ResponseEntity<List<Task>> searchTaskByStatus(@RequestParam String status) {
//    return new ResponseEntity<>(taskService.searchTaskByStatus(status), HttpStatus.OK);
//}
//
//@GetMapping("/searchByPriority")
//public ResponseEntity<List<Task>> searchTaskByPriority(@RequestParam String priority) {
//    return new ResponseEntity<>(taskService.searchTaskByPriority(priority), HttpStatus.OK);
//}
//
//@GetMapping("/searchByDueDate")
//public ResponseEntity<List<Task>> searchTaskByDueDate(@RequestParam LocalDate dueDate) {
//    return new ResponseEntity<>(taskService.searchTaskByDueDate(dueDate), HttpStatus.OK);
//}

}

