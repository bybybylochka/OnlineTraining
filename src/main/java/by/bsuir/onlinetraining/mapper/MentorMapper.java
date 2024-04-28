package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.ImageServiceQualifier;
import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.request.EditMentorRequest;
import by.bsuir.onlinetraining.response.MentorResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ImageServiceQualifier.class)
public interface MentorMapper {
    @Mapping(target = "login", source = "authorizationData.login")
    @Mapping(target = "image", source = "imagePath", qualifiedByName = "downloadImage")
    MentorResponse mapToMentorResponse(Mentor mentor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMentor(EditMentorRequest request, @MappingTarget Mentor mentor);
}
