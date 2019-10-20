package server.mappers;

import lombok.NoArgsConstructor;
import server.dtos.ChallengeDto;
import server.models.Challenge;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ChallengeMapper {
    public static ChallengeDto challengeToDto(Challenge challenge){
        return ChallengeDto.builder()
                .challengeType(ChallengeTypeMapper.challengeTypeToDto(challenge.getChallengeType()))
                .teacher(TeacherMapper.teacherToDto(challenge.getTeacher()))
                .code(challenge.getCode())
                .build();
    }
}
