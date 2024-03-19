package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.CourseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseListResponse {
    private List<CourseResponse> courses;
}
