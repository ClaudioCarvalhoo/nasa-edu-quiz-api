package server.mappers;

import lombok.NoArgsConstructor;
import server.dtos.TeacherDto;
import server.models.Teacher;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TeacherMapper {
    public static TeacherDto teacherToDto(Teacher teacher){
        return TeacherDto.builder().login(teacher.getLogin()).build();
    }
}
