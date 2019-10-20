package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.ChallengeType;

@Repository
public interface ChallengeTypeRepository extends JpaRepository<ChallengeType, String> {
}
