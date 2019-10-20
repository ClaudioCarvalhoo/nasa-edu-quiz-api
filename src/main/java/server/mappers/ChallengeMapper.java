package server.mappers;

import lombok.NoArgsConstructor;
import server.dtos.ChallengeDto;
import server.dtos.QuestionDto;
import server.models.Challenge;
import server.responses.ChallengeResponse;
import server.responses.QuestionResponse;

import java.util.Set;

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

    public static ChallengeResponse dtoToResponse(ChallengeDto challengeDto, Set<QuestionResponse> questions){
        return ChallengeResponse.builder()
                .challengeType(challengeDto.getChallengeType())
                .code(challengeDto.getCode())
                .teacher(challengeDto.getTeacher())
                .questions(questions)
                .build();
    }
}
