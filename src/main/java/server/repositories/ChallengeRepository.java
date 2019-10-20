package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, String> {
}
