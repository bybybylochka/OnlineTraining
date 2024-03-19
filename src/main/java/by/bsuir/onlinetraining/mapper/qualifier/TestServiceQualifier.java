package by.bsuir.onlinetraining.mapper.qualifier;

import by.bsuir.onlinetraining.models.Test;
import by.bsuir.onlinetraining.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestServiceQualifier {
    private final TestRepository testRepository;

    @Named("findTestById")
    public Test findTestById(Long testId) {
        return testRepository.findById(testId)
                .orElseThrow(() -> new IllegalArgumentException("Test was not found by id!"));
    }
}
