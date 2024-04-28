package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.request.LessonRequest;
import by.bsuir.onlinetraining.response.LessonResponse;
import by.bsuir.onlinetraining.response.list.LessonListResponse;

public interface LessonService {

    LessonResponse findLessonById(Long lessonId);
    LessonResponse createLesson(LessonRequest lessonRequest);

    LessonListResponse findLessonsByCourse(Long courseId);

    LessonResponse editLesson(Long lessonId, LessonRequest request);

    void deleteLesson(Long lessonId);
}
