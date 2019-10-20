package server.mappers;

import lombok.NoArgsConstructor;
import server.dtos.SubmissionDto;
import server.models.Submission;

import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SubmissionMapper {
    public static SubmissionDto submissionToDto(Submission submission){
        return SubmissionDto.builder()
                .challenge(ChallengeMapper.challengeToDto(submission.getChallenge()))
                .id(submission.getId())
                .score(submission.getScore())
                .studentName(submission.getStudentName())
                .choices(submission.getChoices().stream().map(ChoiceMapper::choiceToDto).collect(Collectors.toSet()))
                .build();
    }
}
