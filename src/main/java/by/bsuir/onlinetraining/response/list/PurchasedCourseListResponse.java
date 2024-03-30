package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.PurchasedCourseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PurchasedCourseListResponse {
    List<PurchasedCourseResponse> purchasedCourses;
}
