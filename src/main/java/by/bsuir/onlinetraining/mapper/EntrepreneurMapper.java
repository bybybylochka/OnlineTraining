package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.response.EntrepreneurResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EntrepreneurMapper {
    EntrepreneurResponse mapToEntrepreneurResponse(Entrepreneur entrepreneur);
}
