package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, String> {
}
