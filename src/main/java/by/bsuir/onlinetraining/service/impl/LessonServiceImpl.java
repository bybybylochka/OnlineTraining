package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.LessonMapper;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.Lesson;
import by.bsuir.onlinetraining.repositories.LessonRepository;
import by.bsuir.onlinetraining.request.LessonRequest;
import by.bsuir.onlinetraining.response.LessonResponse;
import by.bsuir.onlinetraining.response.list.LessonListResponse;
import by.bsuir.onlinetraining.service.CourseService;
import by.bsuir.onlinetraining.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final CourseService courseService;
    @Override
    public LessonResponse createLesson(LessonRequest lessonRequest) {
        Lesson lesson = lessonMapper.mapToLesson(lessonRequest);
        lessonRepository.save(lesson);

        return lessonMapper.mapToLessonResponse(lesson);
    }

    @Override
    public LessonListResponse findLessonsByCourse(Long courseId) {
        Course course = courseService.findCourseEntityById(courseId);
        List<Lesson> lessons = lessonRepository.findLessonsByCourse(course);

        return new LessonListResponse(lessons
                .stream()
                .map(lessonMapper::mapToLessonResponse)
                .toList());
    }

    @Override
    public LessonResponse editLesson(Long lessonId, LessonRequest request) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new EntityNotFoundException(lessonId, Lesson.class));
        lessonMapper.updateLesson(request, lesson);
        Lesson updatedLesson = lessonRepository.save(lesson);

        return lessonMapper.mapToLessonResponse(updatedLesson);
    }
}
