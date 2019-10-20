package server.responses;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import server.dtos.ChallengeTypeDto;
import server.dtos.ChoiceDto;
import server.repositories.QuestionRepository;

import java.util.Set;

@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonDeserialize(builder = QuestionResponse.QuestionResponseBuilder.class)
public class QuestionResponse {
    @NonNull Long id;

    @NonNull String text;

    String imageUrl;

    String helpText;

    String helpImageUrl;

    @NonNull ChallengeTypeDto challengeType;

    Set<ChoiceDto> choices;
}
