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
import server.dtos.SubmissionDto;
import server.requests.SubmissionRequest;
import server.services.SubmissionService;

import javax.validation.Valid;

@RestController
@RequestMapping("/submissions")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SubmissionController {
    private final SubmissionService submissionService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long insertSubmission(@RequestBody @Valid SubmissionRequest request){
        return submissionService.saveSubmission(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubmissionDto getTeacher(@PathVariable("id") Long id){
        return submissionService.getSubmission(id);
    }
}
