package server.dtos;

import lombok.NonNull;
import server.dtos.ChallengeDto.ChallengeDtoBuilder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonDeserialize(builder = ChallengeDtoBuilder.class)
public class ChallengeDto {
    @NonNull String code;

    @NonNull TeacherDto teacherDto;

    @NonNull ChallengeTypeDto challengeTypeDto;
}
