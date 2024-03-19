package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.StudentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentListResponse {
    private List<StudentResponse> students;
}
