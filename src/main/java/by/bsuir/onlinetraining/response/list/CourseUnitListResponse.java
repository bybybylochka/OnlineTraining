package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.CourseUnitResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseUnitListResponse {
    private List<CourseUnitResponse> courseUnits;
}
