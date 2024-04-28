package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.CourseUnitMapper;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.repositories.CourseUnitRepository;
import by.bsuir.onlinetraining.response.CourseUnitResponse;
import by.bsuir.onlinetraining.response.list.CourseUnitListResponse;
import by.bsuir.onlinetraining.service.CourseService;
import by.bsuir.onlinetraining.service.CourseUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseUnitServiceImpl implements CourseUnitService {
    private final CourseUnitRepository courseUnitRepository;
    private final CourseUnitMapper courseUnitMapper;
    private final CourseService courseService;

    @Override
    public CourseUnit findCourseUnitEntityById(Long courseUnitId) {
        return courseUnitRepository.findById(courseUnitId)
                .orElseThrow(() -> new EntityNotFoundException(courseUnitId, CourseUnit.class));
    }

    @Override
    public CourseUnitResponse findCourseUnitById(Long courseUnitId) {
        return courseUnitRepository.findById(courseUnitId)
                .map(courseUnitMapper::mapToCourseUnitResponse)
                .orElseThrow(() -> new EntityNotFoundException(courseUnitId, CourseUnit.class));
    }

    @Override
    public CourseUnitListResponse findAllUnitsByCourse(Long courseId) {
        Course course = courseService.findCourseEntityById(courseId);
        List<CourseUnit> units = courseUnitRepository.findCourseUnitsByCourse(course);
        return new CourseUnitListResponse(units
                 .stream()
                 .map(courseUnitMapper::mapToCourseUnitResponse)
                 .toList());
    }

    @Override
    public List<CourseUnit> findAllUnitsEntityByCourse(Long courseId) {
        Course course = courseService.findCourseEntityById(courseId);

        return courseUnitRepository.findCourseUnitsByCourse(course);
    }


    @Override
    public void deleteCourseUnit(Long courseUnitId) {
        CourseUnit courseUnit = courseUnitRepository.findById(courseUnitId)
                .orElseThrow(() -> new EntityNotFoundException(courseUnitId, CourseUnit.class));
        courseUnitRepository.delete(courseUnit);
    }
}
