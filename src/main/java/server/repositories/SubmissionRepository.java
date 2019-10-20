package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
