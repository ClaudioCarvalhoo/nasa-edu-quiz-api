package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.models.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
