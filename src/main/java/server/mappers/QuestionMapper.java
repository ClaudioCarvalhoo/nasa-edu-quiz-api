package server.mappers;

import lombok.NoArgsConstructor;
import server.dtos.ChoiceDto;
import server.dtos.QuestionDto;
import server.models.Question;
import server.responses.QuestionResponse;

import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class QuestionMapper {
    public static QuestionDto questionToDto(Question question){
        return QuestionDto.builder()
                .challengeType(ChallengeTypeMapper.challengeTypeToDto(question.getChallengeType()))
                .helpImageUrl(question.getHelpImageUrl())
                .helpText(question.getHelpText())
                .id(question.getId())
                .imageUrl(question.getImageUrl())
                .text(question.getText())
                .build();
    }

    public static QuestionResponse dtoToResponse(QuestionDto questionDto, Set<ChoiceDto> choices){
        return QuestionResponse.builder()
                .challengeType(questionDto.getChallengeType())
                .helpImageUrl(questionDto.getHelpImageUrl())
                .helpText(questionDto.getHelpText())
                .id(questionDto.getId())
                .imageUrl(questionDto.getImageUrl())
                .text(questionDto.getText())
                .choices(choices)
                .build();
    }
}
