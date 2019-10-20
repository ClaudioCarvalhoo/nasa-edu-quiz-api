package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
}
