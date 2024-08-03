package org.example.taskmanagementsystem.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResponse {
    private List<TaskDto> tasks;
    private int pageNo;
    private int pageSize;
    private long totalTasks;
    private int totalPages;
}
