package server.mappers;

import lombok.NoArgsConstructor;
import server.dtos.ChallengeTypeDto;
import server.models.ChallengeType;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ChallengeTypeMapper {
    public static ChallengeTypeDto challengeTypeToDto(ChallengeType challengeType){
        return ChallengeTypeDto.builder()
                .description(challengeType.getDescription())
                .name(challengeType.getName())
                .build();
    }
}
