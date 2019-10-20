package server.services;

import lombok.AllArgsConstructor;
import server.dtos.TeacherDto;
import server.mappers.TeacherMapper;
import server.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.repositories.TeacherRepository;
import server.requests.TeacherRequest;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public void saveTeacher(TeacherRequest request){
        Teacher teacher = new Teacher();
        teacher.setLogin(request.getLogin());
        teacherRepository.save(teacher);
    }

    public TeacherDto getTeacher(String login){
        Teacher teacher = teacherRepository.getOne(login);
        return TeacherMapper.teacherToDto(teacher);
    }
}
