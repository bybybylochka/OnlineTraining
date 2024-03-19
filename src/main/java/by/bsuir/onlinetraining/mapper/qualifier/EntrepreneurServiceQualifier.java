package by.bsuir.onlinetraining.mapper.qualifier;

import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.service.EntrepreneurService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntrepreneurServiceQualifier {
    private final EntrepreneurService entrepreneurService;

    @Named("findEntrepreneurById")
    public Entrepreneur findEntrepreneurById(Long entrepreneurId) {
        return entrepreneurService.findEntrepreneurEntityById(entrepreneurId);
    }
}
