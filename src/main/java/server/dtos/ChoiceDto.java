package server.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonDeserialize(builder = ChoiceDto.ChoiceDtoBuilder.class)
public class ChoiceDto {
    @NonNull Long id;

    @NonNull String text;

    @NonNull Long score;

    @NonNull String imageUrl;

    @NonNull String knowledgeText;

    String knowledgeImageUrl;

    @NonNull QuestionDto questionDto;
}
