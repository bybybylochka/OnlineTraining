package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.TaskResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TaskListResponse {
    private List<TaskResponse> tasks;
}
