package server.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dtos.ChallengeDto;
import server.mappers.ChallengeMapper;
import server.models.Challenge;
import server.repositories.ChallengeRepository;
import server.repositories.ChallengeTypeRepository;
import server.repositories.TeacherRepository;
import server.requests.ChallengeRequest;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final ChallengeTypeRepository challengeTypeRepository;
    private final TeacherRepository teacherRepository;

    public void saveChallenge(ChallengeRequest request){
        Challenge challenge = new Challenge();
        challenge.setChallengeType(challengeTypeRepository.getOne(request.getChallengeTypeId()));
        challenge.setCode(request.getCode());
        challenge.setTeacher(teacherRepository.getOne(request.getTeacherLogin()));
        challengeRepository.save(challenge);
    }

    public ChallengeDto getChallenge(String code){
        return ChallengeMapper.challengeToDto(challengeRepository.getOne(code));
    }
}
