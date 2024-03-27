package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
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
                .orElseThrow(() -> new EntityNotFoundException(courseUnitId, CourseUnit.class));
    }

    @Override
    public CourseUnitResponse findCourseUnitById(Long courseUnitId) {
        return courseUnitRepository.findById(courseUnitId)
                .map(courseUnitMapper::mapToCourseUnitResponse)
                .orElseThrow(() -> new EntityNotFoundException(courseUnitId, CourseUnit.class));
    }

    @Override
    public CourseUnitListResponse findAllCourseUnits() {
         return new CourseUnitListResponse(courseUnitRepository.findAll()
                 .stream()
                 .map(courseUnitMapper::mapToCourseUnitResponse)
                 .toList());
    }


    @Override
    public void deleteCourseUnit(Long courseUnitId) {
        CourseUnit courseUnit = courseUnitRepository.findById(courseUnitId)
                .orElseThrow(() -> new EntityNotFoundException(courseUnitId, CourseUnit.class));
        courseUnitRepository.delete(courseUnit);
    }
}
