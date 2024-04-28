package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.mapper.CompletedCourseUnitMapper;
import by.bsuir.onlinetraining.models.CompletedCourseUnit;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.repositories.CompletedCourseUnitRepository;
import by.bsuir.onlinetraining.request.CompletedCourseUnitRequest;
import by.bsuir.onlinetraining.request.SearchCompletedUnitsRequest;
import by.bsuir.onlinetraining.response.CompletedCourseUnitResponse;
import by.bsuir.onlinetraining.response.list.CompletedUnitListResponse;
import by.bsuir.onlinetraining.service.CompletedCourseUnitService;
import by.bsuir.onlinetraining.service.CourseService;
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
        CompletedCourseUnit savedCourseUnit = courseUnitRepository.save(courseUnit);

        return courseUnitMapper.mapToCompletedCourseUnitResponse(savedCourseUnit);
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

//    @Override
//    public StudentRatingListResponse findStudentsRating(Long courseId) {
//        Course course = courseService.findCourseEntityById(courseId);
//        List<CourseUnit> courseUnits = course.getCourseUnitList();
//        List<Lesson> lessons = new ArrayList<>();
//        List<Task> tasks = new ArrayList<>();
//        List<Test> tests = new ArrayList<>();
//
//        courseUnits.forEach(courseUnit -> {
//            if(courseUnit instanceof Lesson) lessons.add((Lesson) courseUnit);
//            else if (courseUnit instanceof Task) tasks.add((Task) courseUnit);
//            else tests.add((Test) courseUnit);
//        });
//
//        tasks.stream().reduce(0.0, task)
//    }
}
