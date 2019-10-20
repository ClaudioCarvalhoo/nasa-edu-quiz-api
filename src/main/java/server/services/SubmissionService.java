package server.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dtos.SubmissionDto;
import server.mappers.SubmissionMapper;
import server.models.Submission;
import server.repositories.ChallengeRepository;
import server.repositories.ChoiceRepository;
import server.repositories.SubmissionRepository;
import server.requests.SubmissionRequest;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SubmissionService {
    private final SubmissionRepository submissionRepository;
    private final ChallengeRepository challengeRepository;
    private final ChoiceRepository choiceRepository;

    public Long saveSubmission(SubmissionRequest request){
        Submission submission = new Submission();
        submission.setChallenge(challengeRepository.getOne(request.getChallengeCode()));
        submission.setScore(request.getScore());
        submission.setStudentName(request.getStudentName());
        submission.setChoices(request.getChoiceIds().stream().map(choiceRepository::getOne).collect(Collectors.toSet()));
        return submissionRepository.save(submission).getId();
    }

    public SubmissionDto getSubmission(Long id){
        return SubmissionMapper.submissionToDto(submissionRepository.getOne(id));
    }
}
