package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.mapper.CourseUnitMapper;
import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.repositories.CourseUnitRepository;
import by.bsuir.onlinetraining.response.CourseUnitResponse;
import by.bsuir.onlinetraining.response.list.CourseUnitListResponse;
import by.bsuir.onlinetraining.service.CourseUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseUnitServiceImpl implements CourseUnitService {
    private final CourseUnitRepository courseUnitRepository;
    private final CourseUnitMapper courseUnitMapper;

    @Override
    public CourseUnit findCourseUnitEntityById(Long courseUnitId) {
        return courseUnitRepository.findById(courseUnitId)
                .orElseThrow(() -> new IllegalArgumentException("Course unit was not found by id"));
    }

    @Override
    public CourseUnitResponse findCourseUnitById(Long courseUnitId) {
        return null;
    }

    @Override
    public CourseUnitListResponse findAllCourseUnits() {
        return null;
    }


    @Override
    public void deleteCourseUnit(Long courseUnitId) {

    }
}
