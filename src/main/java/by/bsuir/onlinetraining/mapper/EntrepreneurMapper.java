package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.request.EntrepreneurEditRequest;
import by.bsuir.onlinetraining.response.EntrepreneurResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EntrepreneurMapper {
    EntrepreneurResponse mapToEntrepreneurResponse(Entrepreneur entrepreneur);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntrepreneur(EntrepreneurEditRequest request, @MappingTarget Entrepreneur entrepreneur);
}
