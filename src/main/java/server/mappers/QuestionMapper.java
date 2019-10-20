package server.mappers;

import lombok.NoArgsConstructor;
import server.dtos.QuestionDto;
import server.models.Question;

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
}
