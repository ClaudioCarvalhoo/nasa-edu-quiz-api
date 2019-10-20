package server.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dtos.ChallengeDto;
import server.dtos.QuestionDto;
import server.mappers.ChallengeMapper;
import server.mappers.ChoiceMapper;
import server.mappers.QuestionMapper;
import server.models.Challenge;
import server.repositories.ChallengeRepository;
import server.repositories.ChallengeTypeRepository;
import server.repositories.ChoiceRepository;
import server.repositories.QuestionRepository;
import server.repositories.TeacherRepository;
import server.requests.ChallengeRequest;
import server.responses.ChallengeResponse;
import server.responses.QuestionResponse;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final ChallengeTypeRepository challengeTypeRepository;
    private final TeacherRepository teacherRepository;
    private final QuestionRepository questionRepository;
    private final ChoiceRepository choiceRepository;

    public void saveChallenge(ChallengeRequest request){
        Challenge challenge = new Challenge();
        challenge.setChallengeType(challengeTypeRepository.getOne(request.getChallengeTypeName()));
        challenge.setCode(request.getCode());
        challenge.setTeacher(teacherRepository.getOne(request.getTeacherLogin()));
        challengeRepository.save(challenge);
    }

    public ChallengeResponse getChallenge(String code){
        ChallengeDto challengeDto = ChallengeMapper.challengeToDto(challengeRepository.getOne(code));
        Set<QuestionDto> questions = questionRepository.getQuestionsByChallengeTypeName(challengeDto.getChallengeType().getName()).stream().map(QuestionMapper::questionToDto).collect(Collectors.toSet());
        Set<QuestionResponse> questionResponses = questions.stream().map( questionDto ->
                QuestionMapper.dtoToResponse(questionDto, choiceRepository.getChoicesByQuestionId(questionDto.getId()).stream().map(ChoiceMapper::choiceToDto).collect(Collectors.toSet()))
        ).collect(Collectors.toSet());
        return ChallengeMapper.dtoToResponse(challengeDto, questionResponses);
    }
}
