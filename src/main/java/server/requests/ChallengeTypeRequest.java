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
public class ChallengeTypeRequest {
    @NonNull Long id;

    @NonNull String description;
}
