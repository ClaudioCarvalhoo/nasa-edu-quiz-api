package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.models.Choice;
import server.models.Question;

import java.util.Set;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {

    @Query(value = "SELECT * FROM challenges.CHOICE WHERE question_id = :question_id", nativeQuery = true)
    Set<Choice> getChoicesByQuestionId(@Param("question_id") Long questionId);

}
