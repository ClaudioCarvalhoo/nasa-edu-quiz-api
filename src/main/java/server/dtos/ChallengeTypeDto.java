package server.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonDeserialize(builder = ChallengeTypeDto.ChallengeTypeDtoBuilder.class)
public class ChallengeTypeDto {
    @NonNull String name;

    @NonNull String description;
}
