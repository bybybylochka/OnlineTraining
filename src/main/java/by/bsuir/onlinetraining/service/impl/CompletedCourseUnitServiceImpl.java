package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.mapper.CompletedCourseUnitMapper;
import by.bsuir.onlinetraining.models.CompletedCourseUnit;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.repositories.CompletedCourseUnitRepository;
import by.bsuir.onlinetraining.request.CompletedCourseUnitRequest;
import by.bsuir.onlinetraining.request.SearchCompletedUnitsRequest;
import by.bsuir.onlinetraining.response.CompletedCourseUnitResponse;
import by.bsuir.onlinetraining.response.list.CompletedUnitListResponse;
import by.bsuir.onlinetraining.service.CompletedCourseUnitService;
import by.bsuir.onlinetraining.service.CourseService;
import by.bsuir.onlinetraining.service.CourseUnitService;
import by.bsuir.onlinetraining.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompletedCourseUnitServiceImpl implements CompletedCourseUnitService {
    private final CompletedCourseUnitRepository courseUnitRepository;
    private final CompletedCourseUnitMapper courseUnitMapper;
    private final StudentService studentService;
    private final CourseService courseService;
    @Override
    public CompletedCourseUnitResponse completeCourseUnit(CompletedCourseUnitRequest completedCourseUnitRequest) {
        // TODO if student and courseUnit exist
        CompletedCourseUnit courseUnit = courseUnitMapper.mapToCompletedCourseUnit(completedCourseUnitRequest);
        courseUnitRepository.save(courseUnit);

        return courseUnitMapper.mapToCompletedCourseUnitResponse(courseUnit);
    }

    @Override
    public CompletedUnitListResponse findCompletedUnits(SearchCompletedUnitsRequest searchCompletedUnitsRequest) {
        Student student = studentService.findStudentEntityById(searchCompletedUnitsRequest.getStudentId());
        Course course = courseService.findCourseEntityById(searchCompletedUnitsRequest.getCourseId());
        List<CompletedCourseUnit> courseUnitsByStudent = courseUnitRepository.findCompletedCourseUnitsByStudent(student);
        List<CompletedCourseUnit> completedCourseUnitsByStudentAndCourse = courseUnitsByStudent.stream()
                .filter((completedCourseUnit -> completedCourseUnit.getCourseUnit().getCourse().equals(course)))
                .toList();

        return new CompletedUnitListResponse(completedCourseUnitsByStudentAndCourse
                .stream()
                .map(courseUnitMapper::mapToCompletedCourseUnitResponse)
                .toList());
    }
}
