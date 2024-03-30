package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.exception.ModifyIsNotAllowedException;
import by.bsuir.onlinetraining.mapper.TaskMapper;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.Lesson;
import by.bsuir.onlinetraining.models.Task;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import by.bsuir.onlinetraining.repositories.TaskRepository;
import by.bsuir.onlinetraining.request.TaskRequest;
import by.bsuir.onlinetraining.response.TaskResponse;
import by.bsuir.onlinetraining.response.list.TaskListResponse;
import by.bsuir.onlinetraining.service.CourseService;
import by.bsuir.onlinetraining.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final CourseService courseService;

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = taskMapper.mapToTask(taskRequest);
        validateCourseStatus(task);
        Task savedTask = taskRepository.save(task);

        return taskMapper.mapToTaskResponse(savedTask);
    }

    @Override
    public TaskListResponse findTasksByCourse(Long courseId) {
        Course course = courseService.findCourseEntityById(courseId);
        List<Task> tasksByCourse = taskRepository.findTasksByCourse(course);

        return new TaskListResponse(tasksByCourse
                .stream()
                .map(taskMapper::mapToTaskResponse)
                .toList());
    }

    @Override
    public TaskResponse editTask(Long taskId, TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException(taskId, Task.class));
        validateCourseStatus(task);
        taskMapper.updateTask(taskRequest, task);
        Task updatedTask = taskRepository.save(task);

        return taskMapper.mapToTaskResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException(taskId, Lesson.class));
        validateCourseStatus(task);
        taskRepository.delete(task);
    }

    private static void validateCourseStatus(Task task) {
        CourseStatus status = task.getCourse().getStatus();
        if (!status.equals(CourseStatus.NOT_FILLED_IN))
            throw new ModifyIsNotAllowedException(status);
    }
}
