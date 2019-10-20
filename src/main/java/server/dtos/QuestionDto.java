package server.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonDeserialize(builder = QuestionDto.QuestionDtoBuilder.class)
public class QuestionDto {
    @NonNull Long id;

    @NonNull String text;

    String imageUrl;

    String helpText;

    String helpImageUrl;

    @NonNull ChallengeTypeDto challengeType;
}
