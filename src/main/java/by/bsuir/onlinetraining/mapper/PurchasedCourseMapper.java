package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.CourseServiceQualifier;
import by.bsuir.onlinetraining.mapper.qualifier.StudentServiceQualifier;
import by.bsuir.onlinetraining.models.PurchasedCourse;
import by.bsuir.onlinetraining.request.PurchasedCourseRequest;
import by.bsuir.onlinetraining.response.PurchasedCourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses={StudentServiceQualifier.class, CourseServiceQualifier.class}
)
public interface PurchasedCourseMapper {
    @Mapping(target = "student", source = "studentId", qualifiedByName = "findStudentById")
    @Mapping(target = "course", source = "courseId", qualifiedByName = "findCourseById")
    PurchasedCourse mapToPurchasedCourse(PurchasedCourseRequest request);
    @Mapping(target = "studentId", source = "purchasedCourse.student.id")
    @Mapping(target = "courseId", source = "purchasedCourse.course.id")
    @Mapping(target = "courseName", source = "purchasedCourse.course.name")
    PurchasedCourseResponse mapToPurchasedCourseResponse(PurchasedCourse purchasedCourse);
}
