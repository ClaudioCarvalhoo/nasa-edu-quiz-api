package server.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.util.Set;

@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class SubmissionRequest {
    @NonNull String studentName;

    @NonNull Long score;

    @NonNull String challengeCode;

    @NonNull Set<@NonNull Long> choiceIds;
}
