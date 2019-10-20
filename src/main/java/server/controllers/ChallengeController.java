package server.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import server.dtos.ChallengeDto;
import server.requests.ChallengeRequest;
import server.responses.ChallengeResponse;
import server.services.ChallengeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/challenges")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void insertChallenge(@RequestBody @Valid ChallengeRequest request){
        challengeService.saveChallenge(request);
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public ChallengeResponse getChallenge(@PathVariable("code") String code){
        return challengeService.getChallenge(code);
    }
}
