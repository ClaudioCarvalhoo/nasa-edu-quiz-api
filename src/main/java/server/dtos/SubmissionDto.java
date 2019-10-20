package server.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

import java.util.Set;

@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonDeserialize(builder = SubmissionDto.SubmissionDtoBuilder.class)
public class SubmissionDto {
    @NonNull Long id;

    @NonNull String studentName;

    @NonNull Long score;

    @NonNull ChallengeDto challenge;

    @NonNull Set<@NonNull ChoiceDto> choices;
}
