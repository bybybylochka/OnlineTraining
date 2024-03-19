package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.CompletedCourseUnitResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CompletedUnitListResponse {
    private List<CompletedCourseUnitResponse> completedUnits;
}
