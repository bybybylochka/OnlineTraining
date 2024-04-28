package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.EntrepreneurServiceQualifier;
import by.bsuir.onlinetraining.mapper.qualifier.ImageServiceQualifier;
import by.bsuir.onlinetraining.mapper.qualifier.MentorServiceQualifier;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.request.CourseRequest;
import by.bsuir.onlinetraining.response.CourseResponse;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {MentorMapper.class, EntrepreneurMapper.class,
                CourseUnitMapper.class, MentorServiceQualifier.class,
                EntrepreneurServiceQualifier.class, ImageServiceQualifier.class}
)
public interface CourseMapper {
    @Mapping(target = "mentor", source = "mentorId", qualifiedByName = "findMentorById")
    @Mapping(target = "status", constant = "NOT_FILLED_IN")
    Course mapToCourse(CourseRequest request);

    @Mapping(target = "image", source = "imagePath", qualifiedByName = "downloadImage")
    CourseResponse mapToCourseResponse(Course course);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCourse(CourseRequest request, @MappingTarget Course course);
}
