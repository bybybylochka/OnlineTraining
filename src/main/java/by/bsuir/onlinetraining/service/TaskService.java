package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.request.TaskRequest;
import by.bsuir.onlinetraining.response.TaskResponse;
import by.bsuir.onlinetraining.response.list.TaskListResponse;

public interface TaskService {
    TaskResponse createTask(TaskRequest taskRequest);

    TaskListResponse findTasksByCourse(Long courseId);

    TaskResponse findTaskById(Long taskId);

    TaskResponse editTask(Long taskId, TaskRequest taskRequest);

    void deleteTask(Long taskId);
}
