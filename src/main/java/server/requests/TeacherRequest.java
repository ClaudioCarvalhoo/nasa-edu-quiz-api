package server.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class TeacherRequest {
    @NotNull String login;
}
