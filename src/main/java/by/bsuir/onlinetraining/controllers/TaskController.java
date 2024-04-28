package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.TaskRequest;
import by.bsuir.onlinetraining.response.TaskResponse;
import by.bsuir.onlinetraining.response.list.TaskListResponse;
import by.bsuir.onlinetraining.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);
    }

    @GetMapping("/course/{courseId}")
    public TaskListResponse findTasksByCourse(@PathVariable Long courseId) {
        return taskService.findTasksByCourse(courseId);
    }

    @GetMapping("/{taskId}")
    public TaskResponse findTaskById(@PathVariable Long taskId) {
        return taskService.findTaskById(taskId);
    }

    @PutMapping("/{taskId}")
    public TaskResponse editTask(@PathVariable Long taskId, @RequestBody TaskRequest taskRequest) {
        return taskService.editTask(taskId, taskRequest);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
