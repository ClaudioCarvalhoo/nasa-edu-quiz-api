package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.ChallengeType;

public interface ChallengeTypeRepository extends JpaRepository<ChallengeType, String> {
}
