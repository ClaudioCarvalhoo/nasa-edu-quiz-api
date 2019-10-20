package server.mappers;

import lombok.NoArgsConstructor;
import server.dtos.ChoiceDto;
import server.models.Choice;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ChoiceMapper {
    public static ChoiceDto choiceToDto(Choice choice){
        return ChoiceDto.builder()
                .id(choice.getId())
                .imageUrl(choice.getImageUrl())
                .knowledgeImageUrl(choice.getKnowledgeImageUrl())
                .knowledgeText(choice.getKnowledgeText())
                .questionDto(QuestionMapper.questionToDto(choice.getQuestion()))
                .score(choice.getScore())
                .text(choice.getText())
                .build();
    }
}
