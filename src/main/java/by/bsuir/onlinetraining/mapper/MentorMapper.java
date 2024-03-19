package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.response.MentorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MentorMapper {
    MentorResponse mapToMentorResponse(Mentor mentor);
}
