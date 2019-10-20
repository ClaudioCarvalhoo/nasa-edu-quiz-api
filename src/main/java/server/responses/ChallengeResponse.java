package server.responses;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import server.dtos.ChallengeDto;
import server.dtos.ChallengeTypeDto;
import server.dtos.QuestionDto;
import server.dtos.TeacherDto;

import java.util.Set;

@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonDeserialize(builder = ChallengeResponse.ChallengeResponseBuilder.class)
public class ChallengeResponse {
    @NonNull String code;

    @NonNull TeacherDto teacher;

    @NonNull ChallengeTypeDto challengeType;

    Set<QuestionResponse> questions;
}
