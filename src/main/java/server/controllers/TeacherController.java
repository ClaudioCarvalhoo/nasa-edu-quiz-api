package server.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import server.requests.TeacherRequest;
import server.services.TeacherService;

import javax.validation.Valid;

@RestController
@RequestMapping("/teachers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void insertTeacher(@RequestBody @Valid TeacherRequest request){
        teacherService.saveTeacher(request);
    }
}
