package server.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class ChallengeRequest {
    @NonNull String code;

    @NonNull String teacherLogin;

    @NonNull String challengeTypeName;
}
