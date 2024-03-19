package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.TestServiceQualifier;
import by.bsuir.onlinetraining.models.Question;
import by.bsuir.onlinetraining.request.QuestionRequest;
import by.bsuir.onlinetraining.response.QuestionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = TestServiceQualifier.class)
public interface QuestionMapper {
    @Mapping(target = "test", source = "testId", qualifiedByName = "findTestById")
    Question mapToQuestion(QuestionRequest request);

    List<Question> mapToQuestionList(List<QuestionRequest> requestList);

    @Mapping(target = "testId", source = "question.test.id")
    QuestionResponse mapToQuestionResponse(Question question);

    List<QuestionResponse> mapToQuestionResponseList(List<Question> questionList);
}
